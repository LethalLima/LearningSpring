package com.lethallima;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */

@Component
public class RandomText {
    private static String[] texts = {
        "I'll be back.",
        "Hasta La Vista, Baby.",
        "Get in the Choppa!",
        null
    };

    public String getText() {
        Random random = new Random();

        return texts[random.nextInt(texts.length)];
    }
}
