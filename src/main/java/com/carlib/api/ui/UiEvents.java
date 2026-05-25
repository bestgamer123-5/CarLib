package com.carlib.api.ui;

import com.carlib.api.event.CarLibEventBus;

/**
 * UI event channels for click/open/close/overlay render cycles.
 */
public final class UiEvents {
    public static final CarLibEventBus<String> SCREEN_OPENED = new CarLibEventBus<>();
    public static final CarLibEventBus<String> SCREEN_CLOSED = new CarLibEventBus<>();
    public static final CarLibEventBus<String> BUTTON_CLICKED = new CarLibEventBus<>();

    private UiEvents() {
    }
}
