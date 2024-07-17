package org.redthsgayclub.chatter.chat;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.utils.NetworkUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Chatter {
    public static List<String> lines = Collections.emptyList();
    private static int n = 0;
    private static final Random random = new Random();

    public static void load() {
        try {
            String string = NetworkUtils.getString("https://raw.githubusercontent.com/Redths-Gay-Club/Chatter/main/src/main/resources/text.txt");
            lines = Arrays.asList(string.split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doChatter() {
        int min = 1;
        int max = lines.size();
        n = random.nextInt((max - min) + 1) + min;
        UChat.say(lines.get(n));
    }
}
