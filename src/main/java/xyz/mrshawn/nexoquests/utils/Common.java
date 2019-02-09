package xyz.mrshawn.nexoquests.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import xyz.mrshawn.nexoquests.Nexoquests;

import java.lang.reflect.Field;

public class Common {

	public static void registerCommand(BukkitCommand command) {
		try {
			final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
			commandMapField.setAccessible(true);

			final CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
			commandMap.register(command.getLabel(), command);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void log(String... messages) {
		for (final String message : messages)
			log(message);
	}

	public static void log(String messages) {
		tell(Bukkit.getConsoleSender(), "[" + Nexoquests.getInstance().getName() + "] " + messages);
	}

	public static void tell(CommandSender toWhom, String... messages) {
		for (final String message : messages)
			tell(toWhom, message);
	}

	public static void tell(CommandSender toWhom, String message) {
		toWhom.sendMessage(colorize(message));
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
