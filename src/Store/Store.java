//FA22

package Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.System.exit;
import static java.lang.System.in;
import Store.*;

public class Store  {

    private String storeName;
    private double revenue;

    static public void main(String args[]) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(in);

//        ArrayList<Item> ListItem = new ArrayList<>();
//        ArrayList<Employee> ListEmployee = new ArrayList<>();
//        ArrayList<Customer> ListCustomer = new ArrayList<>();
//        ArrayList<SalesOrder> ListSales= new ArrayList<>();


//        while(login()!=true)
//        {
//            System.out.println("You have Entered Wrong UserName or Password !!!");
//            login();
//        }
//        System.out.println("You have login Successfully");

        menu();
        System.out.println("Enter your Choice :");
        int choice = sc.nextInt();

        if (choice == 0) {
            exit(1);
        }
        do {


            switch (choice) {
                case 1:

                    itemMenu();
                    System.out.println("Enter your choice");
                    int option = sc.nextInt();

                    do {

                        switch (option) {
                            case 1:
                                Item.ListItem.clear();
                                if (new File("store_item.dat").exists())
                                     readFromItem();


//                                 for (int i = 0; i <Item.ListItem.size() ; i++) {
//                                     System.out.println(Item.ListItem.get(i));
//                                 }

                                 System.out.println("Enter No. of Items you wants to add:");
                                int no = sc.nextInt();
                                Item[] itemObj = new Item[no];
                                for (int i = 0; i < no; i++) {
                                    sc.nextLine();
                                    System.out.println("Enter Item ID:");

                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter Item Name:");
                                    String name = sc.nextLine();
                                    System.out.println("Enter Item Price:");
                                    double price = sc.nextDouble();
                                    System.out.println("Enter Item Quantity:");
                                    int quantity = sc.nextInt();

                                    int flag = 0;
                                    do {
                                        System.out.println("Enter Item Type(0 for Grocery and 1 for Household) :");
                                        int type = sc.nextInt();

                                        flag = 0;

                                        if (type == 0)
                                            itemObj[i] = new GroceryItems(id, name, price, quantity, "Grocery");
                                        else if (type == 1)
                                            itemObj[i] = new HouseholdItems(id, name, price, quantity, "Household");
                                        else {
                                            System.out.println("Invalid Type (Enter type again)");
                                            flag = 1;
                                        }
                                    } while (flag == 1);
//                                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("stor_item.dat"));
                                    Item.add(itemObj[i]);


                                }
//                                System.out.println("In 1 Before Writting");
//                                for (Item item : Item.ListItem) {
//                                    System.out.println(Item.ListItem);
//                                }
//                                System.out.println("In 1 Before Writting 2");
                                writeIntoItem();
                                Item.ListItem.clear();

//                                System.out.println("In 1 After Writting");


                                break;
                            case 2:
                                Item.ListItem.clear();
                                if (new File("store_item.dat").exists())
                                    readFromItem();
                                System.out.println("Enter No. of Item to Remove:");
                                int n = sc.nextInt();

                                for (int i = 0; i < n; i++) {
                                    System.out.println("Enter Item ID in Item List:");
                                    int id = sc.nextInt();
                                    Item.remove((id));
                                }

                                writeIntoItem();
                                Item.ListItem.clear();
                                break;
                            case 3:
                                Item.ListItem.clear();
                                if (new File("store_item.dat").exists())
                                   readFromItem();


                                for (int i = 0; i < Item.ListItem.size(); i++) {
                                    System.out.println(Item.ListItem.get(i).toString());
                                }

                                writeIntoItem();
                                Item.ListItem.clear();
                                break;

                            case 4:
                                Item.ListItem.clear();
                                if (new File("store_item.dat").exists())
                                 readFromItem();

                                System.out.println("Enter Item ID in Item List to Update:");
                                int ID = sc.nextInt();
                                sc.nextLine();
                                int inIf = 0;

                                for (int i = 0; i < Item.ListItem.size(); i++) {


                                    if (ID == Item.ListItem.get(i).getItemID()) {
                                        inIf = 1;
                                        System.out.println("Enter Item ID:");
                                        int id = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Enter Item Name:");
                                        String name = sc.nextLine();
                                        System.out.println("Enter Item Price:");
                                        double price = sc.nextDouble();
                                        System.out.println("Enter Item Quantity:");
                                        int quantity = sc.nextInt();

                                        int flag = 0;

                                        do {
                                            flag = 0;
                                            System.out.println("Enter Item Type(0 for Grocery and 1 for Household) :");
                                            int type = sc.nextInt();

                                            if (type == 0)
                                                Item.update(ID, new GroceryItems(id, name, price, quantity, "Grocery"));
                                            else if (type == 1)
                                                Item.update(ID, new HouseholdItems(id, name, price, quantity, "Household"));
                                            else {
                                                System.out.println("Invalid Type (Enter type again)");
                                                flag = 1;
                                            }
                                        } while (flag == 1);
                                        break;
                                    }

                                }
                                if (inIf == 0)
                                    System.out.println("Item not Found...");

                                writeIntoItem();
                                Item.ListItem.clear();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Entered Wrong Choice !!!");

                        }
                        if (option != 0) {
                            itemMenu();
                            System.out.println("Enter your choice");
                            option = sc.nextInt();
                        }

                    } while (option != 0);

                    break;
                case 2:

                    option = Employee.employeeMenu();

                    do {

                        switch (option) {
                            case 1:

                                Employee.ListEmployee.clear();
                                if (new File("store_employee.dat").exists())
                                  readFromEmployee();

                                System.out.println("Enter No. of Employees you wants to add:");
                                int no = sc.nextInt();
                                Employee []empObj= new Employee[no];
                                for (int i = 0; i < no; i++) {
                                    sc.nextLine();
                                    System.out.println("Enter Employee ID:");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter Employee Name:");
                                    String name = sc.nextLine();
                                    System.out.println("Enter Employee Address:");
                                    String address = sc.nextLine();
                                    System.out.println("Enter Employee Phone:");
                                    String phone = sc.nextLine();


                                    int flag = 0;
                                    do {
                                        System.out.println("Enter Employee Type(0 for Manager and 1 for Worker) :");
                                        int type = sc.nextInt();

                                        flag = 0;

                                        if (type == 0)
                                            empObj[i] = new Managers(id, name, address,phone, "Manager");
                                        else if (type == 1)
                                            empObj[i] = new Workers(id, name, address,phone, "Worker");
                                        else {
                                            System.out.println("Invalid Type (Enter type again)");
                                            flag = 1;
                                        }
                                    } while (flag == 1);


                                    Employee.add(empObj[i]);
                                }

                                writeIntoEmployee();
                                Employee.ListEmployee.clear();

                                break;
                            case 2:

                                Employee.ListEmployee.clear();
                                if (new File("store_employee.dat").exists())
                                    readFromEmployee();

                                System.out.println("Enter No. of Employees to Remove:");
                                no = sc.nextInt();
                                for (int i = 0; i < no; i++) {
                                    System.out.println("Enter Employee ID in Employees List:");
                                    int id = sc.nextInt();
                                    Employee.remove(id);
                                }

                                writeIntoEmployee();
                                Employee.ListEmployee.clear();

                                break;
                            case 3:

                                Employee.ListEmployee.clear();
                                if (new File("store_employee.dat").exists())
                                    readFromEmployee();

                                for (int i = 0; i < Employee.ListEmployee.size(); i++) {
                                    //System.out.println(Employee.display(i));
                                }

                                writeIntoEmployee();
                                Employee.ListEmployee.clear();

                                break;

                            case 4:

                                Employee.ListEmployee.clear();
                                if (new File("store_employee.dat").exists())
                                    readFromEmployee();

                                System.out.println("Enter Employees ID in Employee List to Update:");
                                int ID = sc.nextInt();
                                sc.nextLine();
                                int inIf = 0;

                                for (int i = 0; i < Employee.ListEmployee.size(); i++) {

                                    if (ID == Employee.ListEmployee.get(i).getId()) {
                                        inIf = 1;
                                        System.out.println("Enter Employee ID:");
                                        int id = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Enter Employee Name:");
                                        String name = sc.nextLine();
                                        System.out.println("Enter Employee Address:");
                                        String address= sc.nextLine();
                                        System.out.println("Enter Employee Phone:");
                                        String phone= sc.nextLine();

                                        int flag = 0;

                                        do {
                                            flag = 0;
                                            System.out.println("Enter Item Type(0 for Manager and 1 for Worker) :");
                                            int type = sc.nextInt();

                                            if (type == 0)
                                                Employee.update(ID,new Managers(id, name, address,phone, "Manager"));
                                            else if (type == 1)
                                                Employee.update(ID,new Workers(id, name, address,phone, "Worker"));
                                            else {
                                                System.out.println("Invalid Type (Enter type again)");
                                                flag = 1;
                                            }
                                        } while (flag == 1);
                                        break;
                                    }

                                }

                                writeIntoEmployee();
                                Employee.ListEmployee.clear();

                            case 0:
                                break;
                            default:
                                System.out.println("Entered Wrong Choice !!!");

                        }
                        if (option != 0)
                            option = Employee.employeeMenu();
                    } while (option != 0);
                    break;
                case 3:

                    option = Customer.customerMenu();


                    do {

                        switch (option) {
                            case 1:

                                Customer.ListCustomer.clear();
                                if(new File("store_customer.dat").exists())
                                    readFromCustomer();

                                System.out.println("Enter No. of Customer you wants to add:");
                                int no = sc.nextInt();
                                Customer custObj[] = new Customer[no];
                                sc.nextLine();
                                for (int i = 0; i < no; i++) {

                                    System.out.println("Enter Customer ID:");

                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter Customer Name:");
                                    String name = sc.nextLine();

                                    System.out.println("Enter Customer Adress:");
                                    String address = sc.nextLine();
                                    System.out.println("Enter Customer Phone:");
                                    String phone = sc.nextLine();
                                    custObj[i] = new Customer(id, name, address, phone);
                                    Customer.add(custObj[i]);
                                }

                                writeIntoCustomer();
                                Customer.ListCustomer.clear();

                                break;
                            case 2:

                                Customer.ListCustomer.clear();
                                if(new File("store_customer.dat").exists())
                                    readFromCustomer();

                                System.out.println("Enter No. of Customer to Remove:");
                                no = sc.nextInt();
                                for (int i = 0; i < no; i++) {
                                    System.out.println("Enter Customer ID in Customer List:");
                                    Customer.remove(sc.nextInt());
                                }

                                writeIntoCustomer();
                                Customer.ListCustomer.clear();

                                break;
                            case 3:

                                Customer.ListCustomer.clear();
                                if(new File("store_customer.dat").exists())
                                    readFromCustomer();

                                for (int i = 0; i < Customer.ListCustomer.size(); i++) {
                                    System.out.println(Customer.display(i));
                                }

                                writeIntoCustomer();
                                Customer.ListCustomer.clear();

                                break;

                            case 4:

                                Customer.ListCustomer.clear();
                                if(new File("store_customer.dat").exists())
                                    readFromCustomer();

                                System.out.println("Enter Customer ID in Customer List to Update:");
                                int ID = sc.nextInt();
                                sc.nextLine();
                                int inIf = 0;

                                for (int i = 0; i < Customer.ListCustomer.size(); i++) {

                                    if (ID == Customer.ListCustomer.get(i).getId()) {
                                        inIf = 1;
                                        System.out.println("Enter Customer ID:");
                                        int id = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Enter Customer Name:");
                                        String name = sc.nextLine();
                                        System.out.println("Enter Customer Address:");
                                        String address = sc.nextLine();
                                        System.out.println("Enter Customer Phone:");
                                        String phone = sc.nextLine();

                                        Customer customer = new Customer(id, name, address, phone);

                                        Customer.update(ID, customer);
                                        System.out.println("Customer Updated Successfully...");
                                        break;
                                    }
                                }
                                if (inIf == 0)
                                    System.out.println("Customer not available !!!");


                                writeIntoCustomer();
                                Customer.ListCustomer.clear();

                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Entered Wrong Choice !!!");

                        }
                        if (option != 0)
                            option = Customer.customerMenu();
                    } while (option != 0);
                    break;
                case 4:

                    SalesOrder.ListSales.clear();
                    readFromOrder();

                    for (int i = 0; i < SalesOrder.ListSales.size(); i++) {
                        System.out.println(SalesOrder.ListSales.get(i));
                    }

                    writeIntoOrder();
                    SalesOrder.ListSales.clear();

                    break;
                case 5:

                    Customer.ListCustomer.clear();
                    if(new File("store_customer.dat").exists())
                        readFromCustomer();

                    int check = 0;
                    Customer customer = new Customer(0, " ", " ", " ");
                    do {
                        System.out.println("Enter 0 for New Customer and 1 for Old Customer:");
                        int o = sc.nextInt();

                        switch (o) {
                            case 1:
                                System.out.println("Enter Customer ID:");
                                int id = sc.nextInt();
                                int flag = 0;

                                for (int i = 0; i < Customer.ListCustomer.size(); i++) {
                                    if (id == Customer.ListCustomer.get(i).getId()) {
                                        customer = Customer.ListCustomer.get(i);
                                        flag = 1;
                                        break;
                                    }
                                }

                                if (flag == 0) {
                                    System.out.println("Customer not found...");
                                    break;
                                }
                                check = 1;
                                break;
                            case 0:
                                System.out.println("Enter Customer ID:");
                                int ID = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter Customer Name:");
                                String name = sc.nextLine();
                                System.out.println("Enter Customer Address:");
                                String address = sc.nextLine();
                                System.out.println("Enter Customer Phone:");
                                String phone = sc.nextLine();

                                customer = new Customer(ID, name, address, phone);

                                Customer.ListCustomer.add(customer);
                                check = 1;
                                break;
                            default:
                                System.out.println("Invalid Choice...");
                        }
                    } while (check != 1);

                    writeIntoCustomer();
                    Customer.ListCustomer.clear();


                    System.out.println("Enter number of Item you wants to add in order:");
                    int n = sc.nextInt();
                    Item TempArr[] = new Item[n];
                    int[] Quantity = new int[n];
                    sc.nextLine();

                    Item.ListItem.clear();
                    if(new File("store_item.dat").exists())
                        readFromItem();

                    for (int i = 0; i < n; i++) {

                        System.out.println("Enter Item ID to Add in Bill:");
                        int itemID = sc.nextInt();

                        int flag = 0;

                        for (int j = 0; j < Item.ListItem.size(); j++) {

                            if (Item.ListItem.get(j).getItemID() == itemID) {
                                TempArr[i] = Item.ListItem.get(j);
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Item not found...");
                            i--;
                        }

                        if (flag == 1) {
                            System.out.println("Enter Quantity:");
                            Quantity[i] = sc.nextInt();

                            TempArr[i].setItemQuantity(TempArr[i].getItemQuantity() - Quantity[i]);
                            Item.ListItem.get(i).setItemQuantity(Item.ListItem.get(i).getItemQuantity() - Quantity[i]);
                        }
                    }

                    writeIntoItem();
                    Item.ListItem.clear();

                    double amount = 0;
                    for (int i = 0; i < TempArr.length; i++) {
                        amount += TempArr[i].getItemPrice();
                    }

                    SalesOrder.ListSales.clear();
                    if(new File("store_order.dat").exists())
                        readFromOrder();

//                    SalesOrder.ListSales.add(new SalesOrder(customer, TempArr, amount, LocalDateTime.now()));
//
                    writeIntoOrder();
                    SalesOrder.ListSales.clear();

                    // System.out.println(SalesOrder.ListSales.get(SalesOrder.ListSales.size()-1).toString());

                    System.out.println("*********************");
                    System.out.println("      SALES SLIP      ");
                    System.out.println("*********************");


                    System.out.println("Customer Name: " + customer.getName());
                    System.out.println("Customer ID: " + customer.getId());
                    System.out.println("Customer Address:" + customer.getAddress());
                    System.out.println();


                    System.out.println("ID    Name         Price     Quantity");
                    for (int i = 0; i < TempArr.length; i++) {
                        String id = String.format("%-6d", TempArr[i].getItemID());
                        String name = String.format("%-14s", TempArr[i].getItemName());
                        String price = String.format("%.2f", TempArr[i].getItemPrice());
                        String quantity = String.format("%6d", Quantity[i]);
                        System.out.println(id + name + price + " " + quantity);
                    }
                    System.out.println("------------------------------------");


                    double totalAmount = 0;
                    for (int i = 0; i < TempArr.length; i++) {
                        totalAmount += TempArr[i].getItemPrice() * Quantity[i];
                    }
                    System.out.println("Total Amount: " + totalAmount);

                    System.out.println("*********************");
                    System.out.println("   THANK YOU FOR SHOPPING");
                    System.out.println("*********************");

                    break;
                case 0:
                    exit(0);
            }
            menu();
            System.out.println("Enter your Choice :");
            choice = sc.nextInt();

        } while (choice != 0);

    }

    static boolean login() {
        Scanner sc = new Scanner(in);
        String user;
        System.out.println("Enter Yours Username:");
        user = sc.nextLine();

        System.out.println("Enter Your Password:");
        String pass = sc.nextLine();

        if (user.equals("Azan") & pass.equals("Waqar"))
            return true;
        else
            return false;
    }

    static void menu() {
        Scanner sc = new Scanner(in);

        System.out.println("1- Item");
        System.out.println("2- Employee");
        System.out.println("3- Customer");
        System.out.println("4- Today Sales");
        System.out.println("5- Order");
        System.out.println("0- Exit");


    }

    static void itemMenu() {
      /*  File file = new File("stor_item.dat");
        if(file.exists())
            ReadFile();*/
        System.out.println("1-Add Item");
        System.out.println("2-Remove Item");
        System.out.println("3-Display Item");
        System.out.println("4-Update Item");
        System.out.println("0-Back");

    }
    static void readFromItem() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis=new FileInputStream("store_item.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available()>0)
                Item.ListItem.add((Item)ois.readObject());

            ois.close();
        }catch (EOFException q){
            q.printStackTrace();
        }
    }
    static void writeIntoItem() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store_item.dat"));
        for (Item item : Item.ListItem) {
            oos.writeObject(item);
        }
        oos.close();
    }
    static void readFromEmployee() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis=new FileInputStream("store_employee.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available()>0)
                Employee.ListEmployee.add((Employee) ois.readObject());

            ois.close();
        }catch (EOFException q){
            q.printStackTrace();
        }
    }    static void writeIntoEmployee() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store_employee.dat"));
        for (Employee employee : Employee.ListEmployee) {
            oos.writeObject(employee);
        }
        oos.close();
    }

    static void readFromCustomer() throws IOException, ClassNotFoundException {
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

    static void readFromOrder() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis=new FileInputStream("store_order.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available()>0)
                SalesOrder.ListSales.add((SalesOrder) ois.readObject());

            ois.close();
        }catch (EOFException q){
            q.printStackTrace();
        }
    }    static void writeIntoOrder() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store_order.dat"));
        for (SalesOrder salesOrder : SalesOrder.ListSales) {
            oos.writeObject(salesOrder);
        }
        oos.close();
    }

    static public void AddItem() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Item.ListItem.clear();
        if (new File("store_item.dat").exists())
            readFromItem();


//                                 for (int i = 0; i <Item.ListItem.size() ; i++) {
//                                     System.out.println(Item.ListItem.get(i));
//                                 }

        System.out.println("Enter No. of Items you wants to add:");
        int no = sc.nextInt();
        Item[] itemObj = new Item[no];
        for (int i = 0; i < no; i++) {
            sc.nextLine();
            System.out.println("Enter Item ID:");

            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Item Name:");
            String name = sc.nextLine();
            System.out.println("Enter Item Price:");
            double price = sc.nextDouble();
            System.out.println("Enter Item Quantity:");
            int quantity = sc.nextInt();

            int flag = 0;
            do {
                System.out.println("Enter Item Type(0 for Grocery and 1 for Household) :");
                int type = sc.nextInt();

                flag = 0;

                if (type == 0)
                    itemObj[i] = new GroceryItems(id, name, price, quantity, "Grocery");
                else if (type == 1)
                    itemObj[i] = new HouseholdItems(id, name, price, quantity, "Household");
                else {
                    System.out.println("Invalid Type (Enter type again)");
                    flag = 1;
                }
            } while (flag == 1);
//                                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("stor_item.dat"));
            Item.add(itemObj[i]);


        }
//                                System.out.println("In 1 Before Writting");
//                                for (Item item : Item.ListItem) {
//                                    System.out.println(Item.ListItem);
//                                }
//                                System.out.println("In 1 Before Writting 2");
        writeIntoItem();
        Item.ListItem.clear();

//                                System.out.println("In 1 After Writting");
    }

}
