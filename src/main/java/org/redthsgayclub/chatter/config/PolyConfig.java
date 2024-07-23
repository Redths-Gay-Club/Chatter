package org.redthsgayclub.chatter.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import org.redthsgayclub.chatter.Chatter;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import org.redthsgayclub.chatter.chat.Chatting;

public class PolyConfig extends Config {

    @Switch(
            name = "Chatter Switch",
            size = 2
    )
    public static boolean isChatting = false;

    @Text(
            name = "Messages source"
    )
    public static String messagesSource = "Default";
    @Button(
            name = "",
            text = "Reload"
    )
    public Runnable reload = Chatting::load;

    @Slider(
            name = "Chatting Speed (sec)",
            min = 1,
            max = 60
    )
    public static int spammingSpeed = 5;

    public PolyConfig() {
        super(new Mod(Chatter.NAME, ModType.UTIL_QOL, "mod-icon.png"), Chatter.MODID + ".json");
        initialize();
    }

}

