package com.yyj.community.controller;

import com.yyj.community.dto.AccessTokenDTO;
import com.yyj.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;
    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("b89debdbcd1b60523e56");
        accessTokenDTO.setClient_secret("5e200d2fc5f3423ce19dac1259ad732a4fbc3d1b");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8181/callback");
        accessTokenDTO.setState(state);
        githubProvider.getAccessTokenCode(accessTokenDTO);
        return "index";
    }
}
