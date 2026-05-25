package com.carlib.api;

import java.util.Set;

/**
 * Implement this interface in your mod to expose integrations through CarLib.
 */
public interface CarIntegrationProvider {
    /**
     * Unique provider id, usually your mod id.
     */
    String providerId();

    /**
     * Returns feature keys supported by this provider.
     */
    Set<String> supportedFeatures();

    /**
     * Allows dynamic feature execution.
     */
    Object invoke(String featureKey, Object input);
}
