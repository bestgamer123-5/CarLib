package com.carlib.api.ui;

/**
 * Shared render-time context data.
 */
public record UiRenderContext(int screenWidth, int screenHeight, float tickDelta) {
}
