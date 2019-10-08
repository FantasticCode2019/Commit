package com.yyj.community.controller;

import com.yyj.community.dto.PaginationDTO;
import com.yyj.community.mapper.UserMapper;
import com.yyj.community.model.User;
import com.yyj.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return "index";
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "=" + cookie.getValue());
            if ((cookie.getName()).equals("token")) {
                String token = cookie.getValue();
                // System.out.println("second&&&&&&" + token);
                User user = userMapper.findUserByToken(token);
                if (user != null)
                    request.getSession().setAttribute("user", user);
                break;
            }
        }
        PaginationDTO pagination = questionService.getList(page, size);
        //model.addObject();
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
