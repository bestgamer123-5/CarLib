package com.carlib.api.ui;

import java.util.List;

/**
 * Container element for grouping widgets.
 */
public record PanelElement(String id, List<UiElement> children) implements UiElement {
}
