package io.github.nosequel.menus;


import org.bukkit.plugin.java.JavaPlugin;

public class MenuHandler {

    private static MenuHandler instance;

    public MenuHandler(JavaPlugin plugin) {
        instance = this;
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
