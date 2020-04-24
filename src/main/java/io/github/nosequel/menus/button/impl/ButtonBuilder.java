package io.github.nosequel.menus.button.impl;

import io.github.nosequel.menus.button.Button;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;

import java.util.function.Consumer;

public class ButtonBuilder {

    private Material material;
    private Consumer<HumanEntity> action;
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
    public ButtonBuilder setAction(Consumer<HumanEntity> action) {
        this.action = action;

        return this;
    }

    public Button get() {
        return new Button() {
            @Override
            public int getIndex() {
                return index;
            }

            @Override
            public String getDisplayName() {
                return displayName;
            }

            @Override
            public Material getMaterial() {
                return material;
            }

            @Override
            public Consumer<HumanEntity> getAction() {
                return action;
            }
        };
    }

}
