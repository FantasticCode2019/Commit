package com.yyj.community.controller;

import com.yyj.community.dto.PaginationDTO;
import com.yyj.community.mapper.UserMapper;
import com.yyj.community.model.User;
import com.yyj.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @RequestMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return "index";
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "=" + cookie.getValue());
            if ((cookie.getName()).equals("token")) {
                String token = cookie.getValue();
                // System.out.println("second&&&&&&" + token);
                user = userMapper.findUserByToken(token);
                if (user != null)
                    request.getSession().setAttribute("user", user);
                break;
            }
        }
        if (user == null) return "redirect:/";
        if ("question".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("repies".equals(action)) {
            model.addAttribute("section", "repies");
            model.addAttribute("sectionName", "最新回复");
        }
        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("paginationDTO", paginationDTO);
        return "profile";
    }
}
