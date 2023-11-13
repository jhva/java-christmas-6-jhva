package christmas.model;

public class Menu {

    private String menuName;

    private int menuPrice;

    private String menuType;

    private int menuQuantity;

    public Menu(String menuName, int menuPrice, String menuType, int menuQuantity) {
        this.menuType = menuType;
        this.menuPrice = menuPrice;
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
    }

    public int getMenuQuantity() {
        return menuQuantity;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }
}
