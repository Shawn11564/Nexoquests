package xyz.mrshawn.nexoquests.files;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.mrshawn.nexoquests.Nexoquests;

import java.io.File;
import java.io.IOException;

import static xyz.mrshawn.nexoquests.Nexoquests.getPlayersFile;

public class PlayerFile implements Listener {

	private Nexoquests instance = Nexoquests.getInstance();

	private File file = getPlayersFile();
	private YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if (yaml.getString(player.getUniqueId().toString()) == null) {
			yaml.createSection(player.getUniqueId().toString());
			yaml.createSection(player.getUniqueId().toString() + ".activequests");
			yaml.createSection(player.getUniqueId().toString() + ".completedquests");
			try {
				yaml.save(file);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

}
