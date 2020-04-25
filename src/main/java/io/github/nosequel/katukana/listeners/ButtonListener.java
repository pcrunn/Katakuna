package io.github.nosequel.katukana.listeners;

import io.github.nosequel.katukana.MenuHandler;
import io.github.nosequel.katukana.button.Button;
import io.github.nosequel.katukana.menu.Menu;
import io.github.nosequel.katukana.menu.paginated.PaginatedMenu;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.List;

public class ButtonListener implements Listener {

    private final MenuHandler menuHandler = MenuHandler.get();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        final Menu menu = menuHandler.findMenu(player);

        if (menu != null && event.getCurrentItem() != null) {
            final List<Button> buttons = menu instanceof PaginatedMenu ? ((PaginatedMenu) menu).getButtonsInRange() : menu.getButtons();

            buttons.stream()
                    .filter(button -> button.getIndex() == event.getSlot())
                    .forEach(button -> button.getAction().accept(player));
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        final Player player = (Player) event.getPlayer();
        final Menu menu = menuHandler.findMenu(player);

        if (menu != null) {
            menuHandler.getMenus().remove(menu);
        }
    }
}