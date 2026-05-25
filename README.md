# CarLib (Fabric)

CarLib is a **general-purpose Fabric library** (not only car-related) for mod interoperability.

Creator: **aguyintheroad** (Modrinth + CurseForge).

## Included APIs

- Integration/provider registry API
- Movement + shooting controller API
- Config API (JSON/TOML/YAML) with load/save support
- Event bus for config change notifications
- Animation API (keyframe, bone, entity, item)
- HUD/UI API (overlays, menus, buttons, progress bars, RPG interfaces)

## Config API

Use `ConfigManager` to register codecs, auto-create configs, load, and save:

- `ConfigFormat.JSON`
- `ConfigFormat.TOML`
- `ConfigFormat.YAML`

`ConfigManager.CONFIG_CHANGED` is an event bus you can listen to when config files are saved.

## Animation API

- `KeyframeAnimation` + `Keyframe`
- `BoneAnimation`
- `EntityAnimationController`
- `ItemAnimationController`
- `AnimationApi`

## HUD/UI API

- `HudOverlay` for custom HUD overlays
- `MenuScreenDefinition` for custom menus
- `ButtonElement`
- `ProgressBarElement`
- `RpgInterfaceDefinition`
- `UiApi` for registering overlays/menus

## Movement and Shooting

- `CarMovementController` and `CarWeaponController`
- `CarCombatApi` for controller registration/discovery

## Quick registration example

```java
@Override
public void onInitialize() {
    CarLibApi.registerProvider(new ExampleProvider());
    CarCombatApi.registerMovementController(new ExampleMovementController());
    CarCombatApi.registerWeaponController(new ExampleWeaponController());
    UiApi.registerHudOverlay(new ExampleHudOverlay());
}
```


## More HUD/UI/GUI API

Additional GUI primitives now included:

- `GuiScreen` generic screen contract
- `PanelElement`, `LabelElement`, `TextFieldElement`, `ToggleElement`
- `UiLayout` layout hints (absolute/vertical/horizontal/grid)
- `UiTheme` + active theme management in `UiApi`
- `UiEvents` event buses for opened/closed/clicked events
- `UiRenderContext` render-time context

Example GUI registration:

```java
UiApi.registerTheme(new UiTheme("dark", 0x222222, 0x5e81ac, 0xffffff));
UiApi.setActiveTheme("dark");
UiApi.registerScreen(new GuiScreen() {
    @Override
    public String id() { return "example:garage"; }

    @Override
    public String title() { return "Garage"; }

    @Override
    public List<UiElement> elements() {
        return List.of(
            new LabelElement("title", "Garage"),
            new ButtonElement("spawn", "Spawn Car", () -> UiEvents.BUTTON_CLICKED.post("spawn")),
            new ProgressBarElement("fuel", 0.7f)
        );
    }
});
```
