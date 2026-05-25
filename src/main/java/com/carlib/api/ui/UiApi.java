package com.carlib.api.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class UiApi {
    private static final Map<String, HudOverlay> HUD_OVERLAYS = new ConcurrentHashMap<>();
    private static final Map<String, MenuScreenDefinition> MENUS = new ConcurrentHashMap<>();
    private static final Map<String, GuiScreen> SCREENS = new ConcurrentHashMap<>();
    private static final Map<String, UiTheme> THEMES = new ConcurrentHashMap<>();

    private static volatile UiTheme activeTheme;

    private UiApi() {
    }

    public static void registerHudOverlay(HudOverlay overlay) {
        HUD_OVERLAYS.put(overlay.id(), overlay);
    }

    public static void registerMenu(MenuScreenDefinition menu) {
        MENUS.put(menu.id(), menu);
    }

    public static void registerScreen(GuiScreen screen) {
        SCREENS.put(screen.id(), screen);
    }

    public static void registerTheme(UiTheme theme) {
        THEMES.put(theme.id(), theme);
        if (activeTheme == null) {
            activeTheme = theme;
        }
    }

    public static void setActiveTheme(String themeId) {
        UiTheme theme = THEMES.get(themeId);
        if (theme == null) {
            throw new IllegalArgumentException("Unknown theme: " + themeId);
        }
        activeTheme = theme;
    }

    public static Optional<UiTheme> activeTheme() {
        return Optional.ofNullable(activeTheme);
    }

    public static Collection<HudOverlay> hudOverlays() {
        return Collections.unmodifiableCollection(HUD_OVERLAYS.values());
    }

    public static Collection<MenuScreenDefinition> menus() {
        return Collections.unmodifiableCollection(MENUS.values());
    }

    public static Collection<GuiScreen> screens() {
        return Collections.unmodifiableCollection(SCREENS.values());
    }
}
