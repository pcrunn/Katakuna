package io.github.nosequel.menus.menu.paginated;

import io.github.nosequel.menus.button.Button;
import io.github.nosequel.menus.button.impl.ButtonBuilder;
import io.github.nosequel.menus.menu.Menu;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

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
    public PaginatedMenu(Player player, String title, int size) {
        super(player, title, size + 9);
    }

    @Override
    public void updateMenu() {
        this.updateMenu(this.getButtonsInRange());
    }

    /**
     * Get all the buttons in the current range
     *
     * @return the buttons
     */
    public List<Button> getButtonsInRange() {
        return this.getButtons().stream()
                .filter(button -> button.getIndex() >= getSize() && button.getIndex() <= getSize() * page)
                .map(button -> new ButtonBuilder(button).setIndex(button.getIndex() + 9).get())
                .collect(Collectors.toList());
    }
}