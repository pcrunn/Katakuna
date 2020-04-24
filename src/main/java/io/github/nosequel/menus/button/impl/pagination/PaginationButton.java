package io.github.nosequel.menus.button.impl.pagination;

import io.github.nosequel.menus.button.Button;
import io.github.nosequel.menus.menu.paginated.PaginatedMenu;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;

import java.util.function.Consumer;

@Getter
public class PaginationButton implements Button {

    private int index;
    private String displayName;
    private Material material;
    private Consumer<HumanEntity> action;

    /**
     * Constructor for creating a new PaginationButton
     *
     * @param index the index
     * @param type the type of pagination
     * @param menu the menu
     */
    public PaginationButton(int index, PaginationType type, PaginatedMenu menu) {
        this.index = index;
        this.displayName = type.equals(PaginationType.NEXT) ? ChatColor.GRAY + "Next Page" : ChatColor.GRAY + "Previous Page";
        this.material = Material.CARPET;

        this.action = humanEntity -> {
            if (type.equals(PaginationType.NEXT)) {
                menu.setPage(menu.getPage() + 1);
            } else {
                menu.setPage(menu.getPage() - 1);
            }

            menu.updateMenu();
        };
    }
}
