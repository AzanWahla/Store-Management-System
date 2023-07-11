//FA22

package Store;

import Store.*;

import java.io.Serializable;

public class GroceryItems extends Item implements Serializable {

    private String itemType;

    public GroceryItems(int itemID, String itemName, double itemPrice, int itemQuantity, String itemType) {
        super(itemID, itemName, itemPrice, itemQuantity);
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return super.toString()+" " +
                "itemType='" + itemType + '\'' +
                '}';
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
