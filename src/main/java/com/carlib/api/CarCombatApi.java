package com.carlib.api;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Registry for movement + shooting controllers so mods can interoperate on common behavior.
 */
public final class CarCombatApi {
    private static final Map<String, CarMovementController> MOVEMENT_CONTROLLERS = new ConcurrentHashMap<>();
    private static final Map<String, CarWeaponController> WEAPON_CONTROLLERS = new ConcurrentHashMap<>();

    private CarCombatApi() {
    }

    public static void registerMovementController(CarMovementController controller) {
        MOVEMENT_CONTROLLERS.put(controller.providerId(), controller);
    }

    public static void registerWeaponController(CarWeaponController controller) {
        WEAPON_CONTROLLERS.put(controller.providerId(), controller);
    }

    public static Optional<CarMovementController> movementController(String providerId) {
        return Optional.ofNullable(MOVEMENT_CONTROLLERS.get(providerId));
    }

    public static Optional<CarWeaponController> weaponController(String providerId) {
        return Optional.ofNullable(WEAPON_CONTROLLERS.get(providerId));
    }

    public static Collection<CarMovementController> movementControllers() {
        return Collections.unmodifiableCollection(MOVEMENT_CONTROLLERS.values());
    }

    public static Collection<CarWeaponController> weaponControllers() {
        return Collections.unmodifiableCollection(WEAPON_CONTROLLERS.values());
    }
}
