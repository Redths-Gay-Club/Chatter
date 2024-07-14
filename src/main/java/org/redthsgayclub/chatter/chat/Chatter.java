package org.redthsgayclub.chatter.chat;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.utils.NetworkUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chatter {
    public static List<String> lines = Collections.emptyList();
    private static int n = 0;

    public static void load() {
        try {
            String string = NetworkUtils.getString("https://raw.githubusercontent.com/Redths-Gay-Club/Chatter/main/src/main/resources/text.txt");
            lines = Arrays.asList(string.split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doChatter() {
        if (n >= lines.size()) {
            n = 0;
        }
        UChat.say(lines.get(n));
        n++;
    }
}
