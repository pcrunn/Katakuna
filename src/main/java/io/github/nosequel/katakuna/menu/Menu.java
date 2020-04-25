package io.github.nosequel.katakuna.menu;

import io.github.nosequel.katakuna.MenuHandler;
import io.github.nosequel.katakuna.button.Button;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Menu {

    private final Player player;
    private final String title;
    private final int size;

    private final List<Button> buttons = new ArrayList<>();

    private Inventory inventory;

    /**
     * Constructor for creating a new Menu
     *
     * @param title the title
     * @param size  the size
     */
    public Menu(Player player, String title, int size) {
        this.player = player;
        this.title = title;
        this.size = size;

        MenuHandler.get().getMenus().add(this);
    }

    /**
     * Get the actual size of the menu
     *
     * @return the size
     */
    public int getSize() {
        return Math.min(this.size, 45);
    }

    /**
     * Update the menu
     */
    public void updateMenu() {
        this.updateMenu(this.getButtons());
    }

    /**
     * Update the menu with a certain list of buttons
     *
     * @param buttons the list of buttons
     */
    public void updateMenu(List<Button> buttons) {
        final Inventory inventory = this.inventory == null ? Bukkit.createInventory(null, this.getSize(), this.getTitle()) : this.inventory;

        this.clearMenu(inventory);
        buttons.forEach(button -> inventory.setItem(button.getIndex(), button.toItemStack()));

        if (inventory != this.inventory) {
            this.inventory = inventory;
            player.closeInventory();
            player.openInventory(inventory);
        } else {
            player.updateInventory();
        }
    }

    /**
     * Clear the contents of the menu
     */
    public void clearMenu(Inventory inventory) {
        if (inventory == null) {
            return; // menu doesn't exist yet.
        }

        for (int i = 0; i < this.size; i++) {
            inventory.setItem(i, new ItemStack(Material.AIR));
        }
    }

    /**
     * This method gets called whenever the player closes the inventory
     *
     * @param event the close event
     */
    public void onClose(InventoryCloseEvent event) { }

}