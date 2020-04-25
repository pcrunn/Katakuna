package io.github.nosequel.katakuna.button.impl;

import io.github.nosequel.katakuna.button.Button;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

@Getter
public class ButtonBuilder implements Button {

    private Material material;
    private Consumer<Player> action;
    private String displayName;

    private int index;

    /**
     * Constructor for creating a new ButtonBuilder with default values
     *
     * @param material the material
     */
    public ButtonBuilder(Material material) {
        this.material = material;
        this.displayName = "";
        this.index = 0;
        this.action = humanEntity -> {
        };
    }

    /**
     * Constructor for creating a new ButtonBuilder with the values pre set from a {@link Button}
     *
     * @param button the button
     */
    public ButtonBuilder(Button button) {
        this.material = button.getMaterial();
        this.action = button.getAction();
        this.displayName = button.getDisplayName();
        this.index = button.getIndex();
    }

    /**
     * Set the index of the Button
     *
     * @param index the new index
     * @return the current ButtonBuilder instance
     */
    public ButtonBuilder setIndex(int index) {
        this.index = index;

        return this;
    }

    /**
     * Set the display name of the Button
     *
     * @param displayName the new index
     * @return the current ButtonBuilder instance
     */
    public ButtonBuilder setDisplayName(String displayName) {
        this.displayName = displayName;

        return this;
    }

    /**
     * Set the material of the Button
     *
     * @param material the new index
     * @return the current ButtonBuilder instance
     */
    public ButtonBuilder setMaterial(Material material) {
        this.material = material;

        return this;
    }

    /**
     * Set the action of the Button
     *
     * @param action the new index
     * @return the current ButtonBuilder instance
     */
    public ButtonBuilder setAction(Consumer<Player> action) {
        this.action = action;

        return this;
    }
}
