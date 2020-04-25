package io.github.nosequel.katukana.button;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

public interface Button {

    /**
     * Get the index of the button in the menu
     *
     * @return the index
     */
    int getIndex();

    /**
     * Get the display name of the button
     *
     * @return the display name
     */
    String getDisplayName();

    /**
     * Get the material of the button
     *
     * @return the material
     */
    Material getMaterial();

    /**
     * Get the action which will be executed upon click
     *
     * @return the action
     */
    Consumer<HumanEntity> getAction();

    /**
     * Change a Button into an ItemStack
     *
     * @return the item stack
     */
    default ItemStack toItemStack() {
        final ItemStack itemStack = new ItemStack(this.getMaterial());
        final ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(this.getDisplayName());

        return itemStack;
    }
}