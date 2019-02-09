package xyz.mrshawn.nexoquests.commands;

import org.bukkit.entity.Player;
import xyz.mrshawn.nexoquests.utils.Common;

public class BaseCommand extends PlayerCommand {

	public BaseCommand() {
		super("quest");
		setDescription("Base command for all quest related commands.");
	}

	@Override
	protected void run(Player player, String[] args) {
		if (player.hasPermission("nexoquests.admin")) {
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("npc") || args[0].equalsIgnoreCase("manager") || args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("editnpc")) {
					switch (args[0]) {
						case "create":
							CreateCommand.createCommand(player);
						case "delete":
						default:
							Common.tell(player, "&cInvalid usage! /quest <create / delete / npc / manager / reset / editnpc> ");
							return;
					}
				} else {
					Common.tell(player, "&cInvalid usage! /quest <create / delete / npc / manager / reset / editnpc> ");
					return;
				}
			} else {
				Common.tell(player, "&cInvalid usage! /quest <create / delete / npc / manager / reset / editnpc> ");
				return;
			}
		} else {
			Common.tell(player, "&cYou do not have permission to use this command!");
			return;
		}
	}

}
