package com.carlib.api.ui;

import java.util.List;

/**
 * Generic GUI screen contract for mods integrating with CarLib.
 */
public interface GuiScreen extends UiElement {
    String title();

    List<UiElement> elements();

    default boolean pauseGame() {
        return false;
    }
}
