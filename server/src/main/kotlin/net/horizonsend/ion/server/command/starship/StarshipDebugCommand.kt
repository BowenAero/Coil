package net.horizonsend.ion.server.command.starship

import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Subcommand
import net.horizonsend.ion.common.extensions.information
import net.horizonsend.ion.server.features.starship.movement.StarshipTeleportation
import net.horizonsend.ion.server.miscellaneous.utils.CARDINAL_BLOCK_FACES
import net.horizonsend.ion.server.miscellaneous.utils.helixAroundVector
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.Player

@CommandPermission("starlegacy.starshipdebug")
@CommandAlias("starshipdebug|sbug")
object StarshipDebugCommand : net.horizonsend.ion.server.command.SLCommand() {
	@Suppress("Unused")
	@Subcommand("teleport")
	fun onTeleport(sender: Player, x: Int, y: Int, z: Int) {
		val riding = getStarshipRiding(sender)
		StarshipTeleportation.teleportStarship(riding, Location(sender.world, x.toDouble(), y.toDouble(), z.toDouble()))
	}

	@Suppress("Unused")
	@Subcommand("thrusters")
	fun onThrusters(sender: Player) {
		val starship = getStarshipRiding(sender)
		for (dir in CARDINAL_BLOCK_FACES) {
			sender.sendRichMessage(starship.thrusterMap[dir].toString())
		}
	}

	@Suppress("Unused")
	@Subcommand("dumpSubsystems")
	fun onDumpSubsystems(sender: Player) {
		val starship = getStarshipRiding(sender)

		sender.information(starship.subsystems.joinToString { it.javaClass.simpleName })
	}

	@Subcommand("testVector")
	fun onTestVector(sender: Player, particle: Particle, radius: Double, points: Int, step: Double, length: Double, wavelength: Double, offset: Double) {
		val dir = sender.location.direction
		val origin = sender.eyeLocation.clone().add(dir)

		val direction = dir.clone().normalize().multiply(length)

		helixAroundVector(origin, direction, radius, points, step = step, wavelength = wavelength, offsetRadians = offset).forEach {
			sender.world.spawnParticle(particle, it, 1, 0.0, 0.0, 0.0, 0.0, null)
		}
	}
}
