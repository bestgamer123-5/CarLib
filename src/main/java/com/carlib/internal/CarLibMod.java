package com.carlib.internal;

import com.carlib.api.CarCombatApi;
import com.carlib.api.CarLib;
import com.carlib.api.CarLibApi;
import com.carlib.api.animation.AnimationApi;
import com.carlib.api.config.ConfigFormat;
import com.carlib.api.config.ConfigManager;
import com.carlib.api.config.JsonLikeCodec;
import com.carlib.api.ui.UiApi;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CarLibMod implements ModInitializer {
    public static final String MOD_ID = CarLib.MOD_ID;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ConfigManager.registerCodec(new JsonLikeCodec(ConfigFormat.JSON));
        ConfigManager.registerCodec(new JsonLikeCodec(ConfigFormat.TOML));
        ConfigManager.registerCodec(new JsonLikeCodec(ConfigFormat.YAML));

        LOGGER.info("Initializing {} by {} ({}). Providers: {}, movement: {}, weapons: {}, ui overlays: {}, menus: {}",
                CarLib.MOD_NAME,
                CarLib.AUTHOR,
                CarLib.AUTHOR_PLATFORMS,
                CarLibApi.providers().size(),
                CarCombatApi.movementControllers().size(),
                CarCombatApi.weaponControllers().size(),
                UiApi.hudOverlays().size(),
                UiApi.menus().size());

        LOGGER.info("Animation controller present for {} => entity: {}, item: {}",
                CarLib.MOD_ID,
                AnimationApi.entityController(CarLib.MOD_ID).isPresent(),
                AnimationApi.itemController(CarLib.MOD_ID).isPresent());
    }
}
