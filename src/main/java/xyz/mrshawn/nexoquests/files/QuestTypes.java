package xyz.mrshawn.nexoquests.files;

public enum QuestTypes {

	MINING("Mining"),
	KILLING("Killing"),
	CRAFTING("Crafting"),
	FISHING("Fishing"),
	INTERACTION("Interaction"),
	FARMING("Farming"),
	ENCHANTING("Enchanting");

	public String type;

	private QuestTypes(String type) {
		this.type = type;
	}

}
