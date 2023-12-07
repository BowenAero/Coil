package net.horizonsend.ion.server.features.multiblock.farming.harvester

import org.bukkit.Material

object HarvesterMultiblockTier2 : HarvesterMultiblock("&eTier 2", Material.GOLD_BLOCK) {
	override val regionDepth: Int = 15
	override val maxPower: Int = 100_000
}
