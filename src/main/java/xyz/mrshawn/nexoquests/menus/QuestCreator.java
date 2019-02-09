package xyz.mrshawn.nexoquests.menus;

import me.kangarko.ui.menu.Menu;
import me.kangarko.ui.menu.MenuButton;
import me.kangarko.ui.menu.menues.MenuStandard;
import me.kangarko.ui.model.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class QuestCreator extends MenuStandard {

	private final MenuButton killingQuest;
	//private final MenuButton miningQuest;
	//private final MenuButton craftingQuest;
	//private final MenuButton fishingQuest;
	//private final MenuButton npcInteractionQuest;
	//private final MenuButton farmingQuest;
	//private final MenuButton enchantingQuest;

	public QuestCreator() {
		super(null);

		setSize(4 * 9);
		setTitle("&3Select the Quest Type");

		this.killingQuest = new MenuButton.MenuButtonTrigger(new KillingMenu(), ItemCreator.of(
				Material.DIAMOND_SWORD,
				"&3Killing Quest",
				"&7Set the quest type to \"Killing\""));
	}

	@Override
	protected ItemStack getItemAt(int slot) {

		if (slot == 9 + 1)
			return killingQuest.getItem();
		//if (slot == 9 + 2)
		//	return miningQuest.getItem();
		//if (slot == 9 + 3)
		//	return craftingQuest.getItem();
		//if (slot == 9 + 4)
		//	return fishingQuest.getItem();
		//if (slot == 9 + 5)
		//	return npcInteractionQuest.getItem();
		//if (slot == 9 + 6)
		//	return farmingQuest.getItem();
		//if (slot == 9 + 7)
		//	return enchantingQuest.getItem();

		return null;
	}

	@Override
	protected String[] getInfo() {
		return new String[] {
				"&7Select the type of quest",
				"&7to determine requirements."
		};
	}

	class KillingMenu extends MenuStandard {

		private final MenuButton zombie;

		protected KillingMenu() {
			super(QuestCreator.this);

			QuestCreator.this.setSize(3 * 9);
			setTitle("&3Select the Quest Type");

			this.zombie = new MenuButton() {
				@Override
				public void onClickedInMenu(Player pl, Menu menu, ClickType click) {

				}

				@Override
				public ItemStack getItem() {
					return ItemCreator.of((Material.MONSTER_EGG, 1, (short) 54), "&3Mob Killing Requirements", "&7Set mob killing requirements.").build().make();
				}
			};
		}

		@Override
		protected  ItemStack getItemAt(int slot) {


			return null;
		}

		@Override
		protected String[] getInfo() {
			return new String[] {
					"&7Select what mob types",
					"&7and the quantity that must",
					"&7be killed to finish the quest."
			};
		}
	}

}
