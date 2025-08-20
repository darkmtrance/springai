package com.matomaylla.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController {

    private final ChatClient chatClient;

    public PromptController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @RequestMapping("/post/new")
    public String newPost(@RequestParam String topic){
        var system = """
                 Eres un Senior Backend Engineer especializado en Java, con experiencia en arquitecturas escalables y buenas prácticas de desarrollo.
                 Tu tarea es escribir un mini blog técnico de aproximadamente 100 palabras.      
                                El blog debe tener:         
                                Una introducción breve (1-2 líneas) que plantee el tema o problema.
                                Un cuerpo conciso (4-5 líneas) que explique la solución, experiencia o reflexión técnica.
                                Una conclusión clara (1-2 líneas) que deje una idea final o invitación a explorar más.
                                Tono: Profesional, directo, con toques reflexivos. Eres experto, pero accesible.
                """;

        return chatClient.prompt()
                .system(system)
                .user(
                        user -> {user.text("Generar blog para {topic}");
                        user.param("topic", topic);}
                ).call().content();
    }
}
