package com.matomaylla.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunctionController {

    private final ChatClient chatClient;

    public FunctionController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/function")
    public String dateTool(){
        return chatClient.prompt("Que dia es mañana?")
                .tools(new com.matomaylla.springai.tools.DateTools())
                .call()
                .content();
    }


}
