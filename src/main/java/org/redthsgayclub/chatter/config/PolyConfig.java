package org.redthsgayclub.chatter.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import org.redthsgayclub.chatter.Chatter;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class PolyConfig extends Config {

    @Switch(
            name = "Chatter Switch"
    )
    public static boolean isChatting = false;

    @Text(
            name = "Messages source"
    )
    public static String messagesSource = "Default";

    @Slider(
            name = "Chatting Speed (sec)",
            min = 1, // Minimum value
            max = 60
    )
    public static int spammingSpeed = 5; // Default value


    public PolyConfig() {
        super(new Mod(Chatter.NAME, ModType.UTIL_QOL, "mod-icon.png"), Chatter.MODID + ".json");
        initialize();
    }

}

