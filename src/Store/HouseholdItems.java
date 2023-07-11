//FA22

package Store;

import java.io.Serializable;
import Store.*;

public class HouseholdItems extends Item implements Serializable {
    private String itemType;

    public HouseholdItems(int itemID, String itemName, double itemPrice, int itemQuantity, String itemType) {
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
