//FA22

package Store;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Store.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Customer extends Person implements Serializable {
    static Scanner sc=new Scanner(System.in);
    static public ArrayList<Customer> ListCustomer = new ArrayList<>();
    private int id;
    private String name;
    private String address;
    private String phone;

    public Customer(int id, String customerName, String address, String phone)
    {
        this.id=id;
        this.name =customerName;
        this.address=address;
        this.phone=phone;

    }

    @Override
    public String toString() {
        return "Customer{"  +
                " id='" + id + '\'' +
                ", customerName='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    static int customerMenu()
    {
        System.out.println("1-Add Customer");
        System.out.println("2-Remove Customer");
        System.out.println("3-Display Customer");
        System.out.println("4-Update Customer");
        System.out.println("0-Back");

        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        return choice;
    }

    public static int search(int id) throws IOException, ClassNotFoundException {
        Customer.ListCustomer.clear();
        if (new File("store_customer.dat").exists())
            readFromCustomer();
        int flag=0;
        for (int i = 0; i < ListCustomer.size(); i++) {
            if (ListCustomer.get(i).getId() == id) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To Add Customer");
                alert.setTitle("Confirmation Before Adding");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    ListCustomer.remove(i);
                    flag = 1;
                    break;
                }
            }
        }

        writeIntoCustomer();
        Customer.ListCustomer.clear();
        return flag;
    }


    public static ArrayList<Customer> display() throws IOException, ClassNotFoundException {
        readFromCustomer();

        return ListCustomer;
    }
    public static void add(Customer customer) throws IOException, ClassNotFoundException {
        Customer.ListCustomer.clear();
        if (new File("store_customer.dat").exists())
            readFromCustomer();

        ListCustomer.add(customer);

        writeIntoCustomer();
        Customer.ListCustomer.clear();
    }




    static public int remove(int id) throws IOException, ClassNotFoundException {

        Customer.ListCustomer.clear();
        if (new File("store_customer.dat").exists())
            readFromCustomer();

        int flag=0;
        for (int i = 0; i < ListCustomer.size(); i++) {
            if(ListCustomer.get(i).getId()==id) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To delete Customer");
                alert.setTitle("Confirmation Before Deletion");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    ListCustomer.remove(i);
                    flag = 1;
                    break;
                }
            }

        }

        writeIntoCustomer();
        Customer.ListCustomer.clear();

        return flag;

    }

    static public int update(int id, Customer customer) throws IOException, ClassNotFoundException {
        Customer.ListCustomer.clear();
        if (new File("store_customer.dat").exists())
            readFromCustomer();

        int index=0;
        int flag=0;

        for (int i = 0; i < ListCustomer.size(); i++) {

            if (Customer.ListCustomer.get(i).getId()==id)
            {
                flag=1;
                index=i;
                break;
            }

        }
        if(flag==1){
            ListCustomer.set(index,customer);
        }

        writeIntoCustomer();
        Customer.ListCustomer.clear();
        return flag;

    }
    public static void readFromCustomer() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis=new FileInputStream("store_customer.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available()>0)
                Customer.ListCustomer.add((Customer) ois.readObject());

            ois.close();
        }catch (EOFException q){
            q.printStackTrace();
        }
    }    static void writeIntoCustomer() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store_customer.dat"));
        for (Customer customer : Customer.ListCustomer) {
            oos.writeObject(customer);
        }
        oos.close();
    }


    static String display(int id)
    {
        return ListCustomer.get(id).toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }






}
