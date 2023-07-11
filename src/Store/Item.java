//FA22

package Store;

import java.awt.List;
import java.io.*;
import java.util.*;

import Store.*;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;

public class Item implements Serializable {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Item> ListItem = new ArrayList<>();


    private int itemID;
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
   // private IntegerProperty itemQuantity2 = new SimpleIntegerProperty();



    public Item(int itemID, String itemName, double itemPrice, int itemQuantity) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public Item() {

    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                ',';
    }

    public static ArrayList<Item> display() throws IOException, ClassNotFoundException {
        readFromItem();

        return ListItem;
    }

    static void itemMain() {

    }

    public static void add(Item item) throws IOException, ClassNotFoundException {
        Item.ListItem.clear();
        if (new File("store_item.dat").exists())
            readFromItem();

        ListItem.add(item);

        writeIntoItem();
        Item.ListItem.clear();
    }

    static public int remove(int id) throws IOException, ClassNotFoundException {
        ListItem.clear();
        if (new File("store_item.dat").exists())
            readFromItem();


        for (int i = 0; i < ListItem.size(); i++) {
            if (ListItem.get(i).getItemID() == id) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To delete Item");
                alert.setTitle("Confirmation Before Deletion");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    ListItem.remove(i);
                    writeIntoItem();
                    Item.ListItem.clear();
                    return 1;
                }
            }
        }
            return 0;
        /*  Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To delete Item");
                alert.setTitle("Confirmation Before Deletion");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    ListItem.remove(i);
                    writeIntoItem();
                    Item.ListItem.clear();
                    break;
                }*/
    }

    public static int update(int ID, Item item) throws IOException, ClassNotFoundException {
        Item.ListItem.clear();
        if (new File("store_item.dat").exists())
            readFromItem();

        int index = 0;
        int flag = 0;

        for (int i = 0; i < ListItem.size(); i++) {

            if (Item.ListItem.get(i).getItemID() == ID) {
                flag = 1;
                index = i;
                break;
            }

        }
        if (flag == 1) {
            ListItem.set(index, item);
        }

        writeIntoItem();
        Item.ListItem.clear();
        return flag;

    }

    public static void readFromItem() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("store_item.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {

                Item.ListItem.add((Item) ois.readObject());
            }

            ois.close();
        } catch (EOFException q) {
            q.printStackTrace();
        }
    }

    public static void writeIntoItem() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store_item.dat"));
        for (Item item : Item.ListItem) {
            oos.writeObject(item);
        }
        oos.close();
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice() {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

//    public int getItemQuantity2() {
//        return itemQuantity2.get();
//    }
//    public void setItemQuantity2(int quantity) {
//        itemQuantity2.set(quantity);
//    }
//    public IntegerProperty itemQuantity2Property() {
//        return itemQuantity2;
//    }

}
