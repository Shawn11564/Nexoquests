package xyz.mrshawn.nexoquests;

import me.kangarko.ui.UIDesignerAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.mrshawn.nexoquests.commands.BaseCommand;
import xyz.mrshawn.nexoquests.files.PlayerFile;
import xyz.mrshawn.nexoquests.utils.Common;

import java.io.File;
import java.io.IOException;

public final class Nexoquests extends JavaPlugin {

	private static Nexoquests instance;
	private static File playersFile;
	private static File questFile;

	@Override
	public void onEnable() {
		instance = this;
		UIDesignerAPI.setPlugin(this);
		playersFile = new File(instance.getDataFolder().getPath() + File.separator + "players.yml");
		if (!playersFile.exists()) { try { playersFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
		questFile = new File(instance.getDataFolder().getPath() + File.separator + "quests.yml");
		if (!questFile.exists()) { try { questFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }

		Bukkit.getServer().getPluginManager().registerEvents(new PlayerFile(), this);

		getConfig().options().copyDefaults();
		saveDefaultConfig();

		Common.registerCommand(new BaseCommand());

		Common.log("&aNexoquests has enabled successfully!");
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static Nexoquests getInstance() {
		return instance;
	}

	public static File getPlayersFile() {
		return playersFile;
	}

	public static File getQuestFile() {
		return questFile;
	}

}
