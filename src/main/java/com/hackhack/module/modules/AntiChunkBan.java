package com.hackhack.module.modules;

import java.util.Collections;
import java.util.List;

import com.hackhack.module.Category;
import com.hackhack.module.Module;
import com.hackhack.settings.SettingBase;
import com.hackhack.settings.SettingMode;

public class AntiChunkBan extends Module
{
    private static final List<SettingBase> settings = Collections.singletonList(new SettingMode("Mode: ", "AntiKick", "1 chunk"));
    private int dis = 0;

    public AntiChunkBan()
    {
        super("AntiChunkBan", 0, Category.EXPLOITS, "Bypasses chunk bans", settings);
    }

    public void onEnable()
    {
        this.dis = this.mc.gameSettings.renderDistanceChunks;
    }

    public void onDisable()
    {
        this.mc.gameSettings.renderDistanceChunks = this.dis;
    }

    public void onUpdate()
    {
        if (this.getSettings().get(0).toMode().mode == 1)
        {
            this.mc.gameSettings.renderDistanceChunks = 1;
        }
    }
}
