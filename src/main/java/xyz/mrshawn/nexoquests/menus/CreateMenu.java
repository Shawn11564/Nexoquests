package xyz.mrshawn.nexoquests.menus;

import me.kangarko.ui.menu.Menu;
import me.kangarko.ui.menu.MenuButton;
import me.kangarko.ui.menu.menues.MenuStandard;
import me.kangarko.ui.model.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class CreateMenu extends MenuStandard {

	private final MenuButton objectivesButton;
	private final MenuButton nameButton;
	private final MenuButton flagsButton;
	private final MenuButton rewardsButton;

	public CreateMenu() {
		super(null);

		setSize(4 * 9);
		setTitle("&3Quest Creation GUI");

		this.objectivesButton = new MenuButton.MenuButtonTrigger(new ObjectivesMenu(), ItemCreator.of(
				Material.BOOK_AND_QUILL,
				"&3Quest Type",
				"&7Set the type of the quest."));

		this.nameButton = new MenuButton() {
			@Override
			public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of(Material.NAME_TAG, "&3Quest Name", "&7Name your quest.").build().make();
			}
		};

		this.flagsButton = new MenuButton() {
			@Override
			public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of(Material.WOOL, "&3Quest Flags", "&7Set quest flags.").build().make();
			}
		};

		this.rewardsButton = new MenuButton() {
			@Override
			public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of(Material.BEACON, "&3Quest Rewards", "&7Set quest rewards.").build().make();
			}
		};
	}

	@Override
	protected ItemStack getItemAt(int slot) {

		if (slot == 9 + 1)
			return objectivesButton.getItem();
		if (slot == 9 + 3)
			return nameButton.getItem();
		if (slot == 9 + 5)
			return flagsButton.getItem();
		if (slot == 9 + 7)
			return rewardsButton.getItem();

		return null;
	}

	@Override
	protected String[] getInfo() {
		return null;
	}

	class ObjectivesMenu extends MenuStandard {

		private final MenuButton killingQuest;
		private final MenuButton miningQuest;
		private final MenuButton craftingQuest;
		private final MenuButton fishingQuest;
		private final MenuButton npcInteractionQuest;
		private final MenuButton farmingQuest;
		private final MenuButton enchantingQuest;

		protected ObjectivesMenu() {
			super(CreateMenu.this);

			CreateMenu.this.setSize(2 * 9);
			setTitle("&3Select Requirement Type");

			this.killingQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.DIAMOND_SWORD, "&3Mob Killing Requirements", "&7Set mob killing requirements.").build().make();
				}
			};

			this.miningQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.DIAMOND_PICKAXE, "&3Mining Requirements", "&7Set mining requirements.").build().make();
				}
			};

			this.craftingQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.WORKBENCH, "&3Crafting Requirements", "&7Set crafting requirements.").build().make();
				}
			};

			this.fishingQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.FISHING_ROD, "&3Fishing Requirements", "&7Set fishing requirements.").build().make();
				}
			};

			this.npcInteractionQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.EMERALD, "&3NPC Interaction Requirements", "&7Set npc interaction requirements.").build().make();
				}
			};

			this.farmingQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.DIAMOND_HOE, "&3Farming Requirements", "&7Set farming requirements.").build().make();
				}
			};

			this.enchantingQuest = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of(Material.ENCHANTMENT_TABLE, "&3Enchanting Requirements", "&7Set enchanting requirements.").build().make();
				}
			};
		}

		@Override
		protected  ItemStack getItemAt(int slot) {
			if (slot == 9 + 1)
				return killingQuest.getItem();
			if (slot == 9 + 2)
				return miningQuest.getItem();
			if (slot == 9 + 3)
				return craftingQuest.getItem();
			if (slot == 9 + 4)
				return fishingQuest.getItem();
			if (slot == 9 + 5)
				return npcInteractionQuest.getItem();
			if (slot == 9 + 6)
				return farmingQuest.getItem();
			if (slot == 9 + 7)
				return enchantingQuest.getItem();

			return null;
		}

		@Override
		protected String[] getInfo() {
			return new String[] {
					"&7Set the objectives",
					"&7for a quest to be completed."
			};
		}

	}
}
