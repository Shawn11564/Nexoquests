package xyz.mrshawn.nexoquests.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import xyz.mrshawn.nexoquests.utils.Common;

public abstract class PlayerCommand extends BukkitCommand {

	private Player player;

	protected PlayerCommand(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Common.tell(sender, "&cYou must be a player to run this command.");
			return false;
		}
		final Player player = (Player) sender;
		this.player = player;

		run(player, args);
		return false;
	}

	protected abstract void run(Player player, String[] args);

	protected void tell(String message) {
		Common.tell(player, message);
	}

}
