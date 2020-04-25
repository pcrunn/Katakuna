package io.github.nosequel.katukana;


import io.github.nosequel.katukana.listeners.ButtonListener;
import io.github.nosequel.katukana.menu.Menu;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
public class MenuHandler {

    private static MenuHandler instance;

    private final List<Menu> menus = new ArrayList<>();

    /**
     * Constructor for creating a new MenuHandler instance
     *
     * @param plugin the plugin the listener gets registered to
     */
    public MenuHandler(JavaPlugin plugin) {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new ButtonListener(), plugin);
    }

    /**
     * Find a menu by a player
     *
     * @param player the player
     * @return the found menu
     */
    public Menu findMenu(Player player) {
        final Stream<Menu> menus = this.menus.stream()
                .filter(menu -> menu.getPlayer().equals(player));

        if (menus.count() > 1) {
            throw new IllegalStateException("player has more than 1 menu (" + menus.count() + ")");
        }

        return menus
                .findFirst()
                .orElse(null);
    }

    /**
     * Get the current instance of the MenuHandler
     *
     * @return the instance
     */
    public static MenuHandler get() {
        return instance;
    }

}
