package net.paweltl.pawelsweaponry.init;

import net.fabricmc.loader.api.FabricLoader;

public class CompatInit {

    public static final boolean isBetterCombatLoaded = FabricLoader.getInstance().isModLoaded("bettercombat");
    public static final Boolean isReachEntityAttributesLoaded = FabricLoader.getInstance().isModLoaded("reach-entity-attributes");
}
