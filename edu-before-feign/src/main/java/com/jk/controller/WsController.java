package com.jk.controller;

import com.jk.modelapi.UserBean;
import com.jk.modelapi.WiselyMessage;
import com.jk.modelapi.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class WsController {

    @RequestMapping("reurnWs")
    public String reurnWs(){
        return "ws";
    }
    @MessageMapping("/welcome")//1
    @SendTo("/topic/getResponse")//2
    public WiselyResponse say(WiselyMessage message) throws Exception {

        return new WiselyResponse( message.getName() );
    }
}
