package com.example.lv5;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<MenuItem> mainmenu = new ArrayList<>();
    private MenuItem menuItem = new MenuItem();

    public MainMenu() {
        mainmenu.add(new MenuItem("Burgers"));
        mainmenu.add(new MenuItem("Drinks"));
        mainmenu.add(new MenuItem("Desserts"));
    }

    public MainMenu(List<MenuItem> menuItems) {
        this.mainmenu = menuItems;
    }

    public List<MenuItem> getMenuItems () {
        return mainmenu;
    }

    public void setMenuItems (List <MenuItem> menuItems) {
        this.mainmenu = menuItems;
    }
}
