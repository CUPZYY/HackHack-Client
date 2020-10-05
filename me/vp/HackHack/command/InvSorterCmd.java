package me.vp.HackHack.command;

import me.vp.HackHack.utils.FileMang;
import me.vp.HackHack.utils.HackHackLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.IClientCommand;

import java.util.Objects;

public class InvSorterCmd extends CommandBase implements IClientCommand
{
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message)
    {
        return false;
    }

    public String getName()
    {
        return "invsorter";
    }

    public String getUsage(ICommandSender sender)
    {
        return null;
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args)
    {
        String s = "";

        for (int i = 0; i <= 9; ++i)
        {
            s = s + Objects.requireNonNull(Minecraft.getMinecraft().player.inventory.getStackInSlot(i).getItem().getRegistryName()).toString() + "\n";
        }

        FileMang.createEmptyFile("invsorter.txt");
        FileMang.appendFile(s, "invsorter.txt");

        HackHackLogger.log("Saved Inventory");
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
}
