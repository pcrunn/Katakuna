package io.github.nosequel.menus.menu;

import io.github.nosequel.menus.button.Button;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Menu {

    private final String title;
    private final int size;

    private final List<Button> buttons = new ArrayList<>();

    /**
     * Constructor for creating a new Menu
     *
     * @param title the title
     * @param size  the size
     */
    public Menu(String title, int size) {
        this.title = title;
        this.size = size;
    }
}