package com.matomaylla.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {

    private final ChatClient chatClient;


    public MemoryController(ChatClient.Builder builder) {

        ChatMemory chatMemory = MessageWindowChatMemory.builder().build();

        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();


    }

    @RequestMapping("/memory")
    public String memory(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call().content();
    }



}
