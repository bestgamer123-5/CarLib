package com.carlib.api;

/**
 * Implemented by mods that provide vehicle movement behavior.
 */
public interface CarMovementController {
    /**
     * Identifier of the provider/mod.
     */
    String providerId();

    /**
     * Calculates the next speed in blocks/tick.
     *
     * @param currentSpeed current vehicle speed
     * @param throttle throttle input in range [0..1]
     * @param braking braking input in range [0..1]
     * @param deltaTicks frame delta in ticks
     * @return next speed in blocks/tick
     */
    float computeNextSpeed(float currentSpeed, float throttle, float braking, float deltaTicks);

    /**
     * Calculates steering delta in degrees for the tick.
     *
     * @param steeringInput steering input in range [-1..1]
     * @param currentSpeed current speed in blocks/tick
     * @param deltaTicks frame delta in ticks
     * @return yaw change in degrees for this update
     */
    float computeSteeringDelta(float steeringInput, float currentSpeed, float deltaTicks);
}
