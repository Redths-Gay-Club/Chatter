package org.redthsgayclub.chatter.chat;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.utils.NetworkUtils;
import org.redthsgayclub.chatter.config.PolyConfig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Chatting {
    public static List<String> lines = Collections.emptyList();
    private static int n = 0;
    private static final Random random = new Random();

    public static void load() {
        try {
            String url = PolyConfig.messagesSource.equals("Default") ? "https://raw.githubusercontent.com/Redths-Gay-Club/Chatter/main/src/main/resources/text.txt" : PolyConfig.messagesSource;
            lines = Arrays.asList(NetworkUtils.getString(url).split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doChatter() {
        n = random.nextInt(lines.size() - 1);
        UChat.say(lines.get(n));
    }
}
