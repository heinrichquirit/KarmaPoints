package io.github.heinrichquirit.karmapoints;

public enum KarmaPermission {

	KARMA("/karma <player>", "Displays the players karma points","karmapoints.use"),
	KARMA_ADD("/karma add <player>", "Adds one point to the player","karmapoints.use"),
	KARMA_REMOVE("/karma remove <player>", "Removes one point to the player", "karmapoints.use"),
	KARMA_VIEW("/karma view", "Displays points in ascending order", "karmapoints.admin"),
	KARMA_BAN("/karma ban", "Bans the player with the lowest karma", "karmapoints.admin");
	
	private String syntax;
	private String description;
	private String permission;
	
	KarmaPermission(String syntax, String description, String permission) {
		this.syntax = syntax;
		this.description = description;
		this.permission = permission;
	}
	
	public String getSyntax() {
		return syntax;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return permission;
	}
	
}
