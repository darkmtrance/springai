package com.matomaylla.springai.tools;

import org.springframework.ai.tool.annotation.Tool;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTools {

    @Tool(description = "Obtiene el día y hora actual según la zona horaria del usuario")
    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(ZoneId.of("America/Lima"))
                .toString();
    }
}
