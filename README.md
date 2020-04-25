# Katukana
Light-weight and extensive Menu API made with the Spigot API

# Example Usage
``Creating a Menu``
```java
public class ExampleMenu implements Menu {
    
    public ExampleMenu(Player player) {
        super(player, "title", 9);
    }
 
    public List<Button> getButtons() {        
        return Arrays.asList(
            new ButtonBuilder(Material.COMPASS)
                .setDisplayName("Example Item")
                .setLore("Example Lore")
                .setAction(player -> player.sendMessage("You clicked on an example item"))
        );
    } 
}
```

# Notes
* You must register an instance of the  MenuHandler before you try to open/create any menu. 
* This is still a work-in-progress project, bugs may occur. 