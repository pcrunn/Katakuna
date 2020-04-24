package io.github.nosequel.menus.menu.paginated;

import io.github.nosequel.menus.button.Button;
import io.github.nosequel.menus.menu.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class PaginatedMenu extends Menu {

    private int page;

    /**
     * Constructor for creating a new PaginatedMenu {@link Menu}
     *
     * @param title the title
     * @param size  the size
     */
    public PaginatedMenu(String title, int size) {
        super(title, size + 9);
    }

    /**
     * Get all the buttons in the current range
     *
     * @return the buttons
     */
    public List<Button> getButtonsInRange() {
        return this.getButtons().stream()
                .filter(button -> button.getIndex() >= getSize() && button.getIndex() <= getSize() * page)
                .collect(Collectors.toList());
    }
}