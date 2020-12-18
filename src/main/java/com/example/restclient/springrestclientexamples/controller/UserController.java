package com.example.restclient.springrestclientexamples.controller;

import com.example.restclient.springrestclientexamples.Service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {
    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }
    @PostMapping("/user")
    public String formPost(Model model, ServerWebExchange serverWebExchange){
        MultiValueMap<String,String > multiValueMap=serverWebExchange.getFormData().block();
        Integer limit=new Integer(multiValueMap.get("limit").get(0));
        if(limit==0 || limit==null){
            limit=10;
        }
//        Model model1 = model.addAttribute("users", apiService
//                .getUser(serverWebExchange
//                        .getFormData()
//                        .map(data -> new Integer(data.getFirst("limit")));
        return "userlist";

    }
}
