package com.carlib.api;

/**
 * Implemented by mods that provide shooting/weapon behavior for cars.
 */
public interface CarWeaponController {
    /**
     * Identifier of the provider/mod.
     */
    String providerId();

    /**
     * Returns whether the weapon can currently fire.
     *
     * @param ammo current ammo count
     * @param isCoolingDown true if weapon is cooling down
     */
    boolean canFire(int ammo, boolean isCoolingDown);

    /**
     * Applies a fire action and returns updated ammo.
     *
     * @param ammo current ammo count
     * @return updated ammo count after firing
     */
    int fire(int ammo);

    /**
     * Returns cooldown ticks after a successful fire.
     */
    int cooldownTicks();
}
