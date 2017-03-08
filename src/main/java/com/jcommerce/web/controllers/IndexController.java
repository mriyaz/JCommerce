package com.jcommerce.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Riyazuddin M on 3/8/2017.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
