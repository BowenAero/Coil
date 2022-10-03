package net.horizonsend.ion.proxy.commands.bungee

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.Default
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.ClickEvent.Action
import net.md_5.bungee.api.chat.ComponentBuilder
import net.md_5.bungee.api.connection.ProxiedPlayer

@CommandAlias("info|map|wiki")
class BungeeInfoCommand : BaseCommand() {
	@Default
	@Suppress("Unused")
	fun onInfoCommand(sender: ProxiedPlayer) {
		sender.sendMessage(
			*ComponentBuilder()
				.append(
					ComponentBuilder("Here are a few links of potential use:\n")
						.color(ChatColor.of("#8888ff"))
						.create()
				)
				.append(
					ComponentBuilder("Survival Web Map ")
						.event(ClickEvent(Action.OPEN_URL, "https://survival.horizonsend.net"))
						.color(ChatColor.WHITE)
						.underlined(true)
						.create()
				)
				.append(
					ComponentBuilder("Creative Web Map ")
						.event(ClickEvent(Action.OPEN_URL, "https://creative.horizonsend.net"))
						.color(ChatColor.WHITE)
						.underlined(true)
						.create()
				)
				.append(
					ComponentBuilder("Discord Server ")
						.event(ClickEvent(Action.OPEN_URL, "https://discord.gg/RPvgQsGzKM"))
						.color(ChatColor.WHITE)
						.underlined(true)
						.create()
				)
				.append(
					ComponentBuilder("Resource Pack ")
						.event(ClickEvent(Action.OPEN_URL, "https://github.com/HorizonsEndMC/ResourcePack"))
						.color(ChatColor.WHITE)
						.underlined(true)
						.create()
				)
				.append(
					ComponentBuilder("Wiki ")
						.event(ClickEvent(Action.OPEN_URL, "https://wiki.horizonsend.net"))
						.color(ChatColor.WHITE)
						.underlined(true)
						.create()
				)
				.create()
		)
	}
}