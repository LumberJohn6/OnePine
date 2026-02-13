package com.grandlineapex.world.fruit;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class DevilFruitWorldAccess {
    private DevilFruitWorldAccess() {}

    public static Optional<DevilFruitWorldRegistry> get(ServerLevel level) {
        return level.getCapability(DevilFruitWorldCapability.DEVIL_FRUIT_WORLD).resolve();
    }

    public static Optional<DevilFruitWorldRegistry> get(MinecraftServer server) {
        ServerLevel overworld = server.getLevel(Level.OVERWORLD);
        if (overworld == null) return Optional.empty();
        return get(overworld);
    }
}
