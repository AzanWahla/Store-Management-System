//FA22

package Store;

import Store.*;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class SalesOrder implements Serializable {
    static ArrayList<SalesOrder> ListSales= new ArrayList<>();

    private Customer customer;
    private ArrayList<Item> OrderItem=new ArrayList<Item>();
    private double totalAmount;
    LocalDateTime now = LocalDateTime.now();

    public SalesOrder(Customer customer, ArrayList<Item> item, double totalAmount, LocalDateTime now) {
        this.customer = customer;
        this.OrderItem = item;
        this.totalAmount = totalAmount;
        this.now = now;
    }

//    @Override
//    public String toString() {
//        return "SalesOrder{" +
//                "customer=" + customer +
//                ", item=" + Arrays.toString(item) +
//                ", totalAmount=" + totalAmount +
//                ", now=" + now +
//                '}';
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Item> getOrderItem() {
        return OrderItem;
    }

    public void setOrderItem(ArrayList<Item> orderItem) {
        OrderItem = orderItem;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}


