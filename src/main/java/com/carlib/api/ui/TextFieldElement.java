package com.carlib.api.ui;

/**
 * Text input model element.
 */
public record TextFieldElement(String id, String value, int maxLength) implements UiElement {
}
