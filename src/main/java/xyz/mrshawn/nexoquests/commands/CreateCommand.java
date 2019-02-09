package xyz.mrshawn.nexoquests.commands;

import org.bukkit.entity.Player;
import xyz.mrshawn.nexoquests.menus.QuestCreator;

public class CreateCommand {

	public static void createCommand(Player player) {

		new QuestCreator().displayTo(player);

	}

}
