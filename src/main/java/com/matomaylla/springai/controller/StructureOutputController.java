package com.matomaylla.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StructureOutputController {

    public final ChatClient chatClient;


    public StructureOutputController(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    @GetMapping("/structureOutput")
    public Itinerario structureOutput(){
        return chatClient.prompt()
                .user("Cuales son los mejores lugares para visitar en Lima por 5 dias?")
                .call()
                .entity(Itinerario.class);
    }


    record Actividad(String nombre, String localidad, String dia, String hora) {}

    record Itinerario(List<Actividad> actividades){}
}
