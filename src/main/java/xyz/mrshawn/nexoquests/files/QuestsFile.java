package xyz.mrshawn.nexoquests.files;

import org.bukkit.configuration.file.YamlConfiguration;
import xyz.mrshawn.nexoquests.Nexoquests;

import java.io.File;

import static xyz.mrshawn.nexoquests.Nexoquests.getQuestFile;

public class QuestsFile {

	private Nexoquests instance = Nexoquests.getInstance();
	private File questFile = getQuestFile();
	private YamlConfiguration questConfig = YamlConfiguration.loadConfiguration(questFile);

	public void createQuest() {

	}

}
