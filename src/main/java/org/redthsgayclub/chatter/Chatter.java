package org.redthsgayclub.chatter;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.RenderEvent;
import cc.polyfrost.oneconfig.events.event.Stage;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import org.redthsgayclub.chatter.config.PolyConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Chatter.MODID, name = Chatter.NAME, version = Chatter.VERSION)
public class Chatter {

    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static Chatter INSTANCE;
    public static PolyConfig config;

    private static long targetTime;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new PolyConfig();

        org.redthsgayclub.chatter.chat.Chatter.load();
        EventManager.INSTANCE.register(this);
        PolyConfig.isChatting = false;
    }

    @Subscribe
    public void onTick(RenderEvent event) {
        if(event.stage != Stage.START) return;
        if(System.currentTimeMillis() >= targetTime) {
            targetTime = System.currentTimeMillis() + PolyConfig.spammingSpeed;
            if(PolyConfig.isChatting) {
                org.redthsgayclub.chatter.chat.Chatter.doChatter();
            }
        }
    }



}
