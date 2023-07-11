//FA22

package Store;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Store.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Employee extends Person implements Serializable {

    static  Scanner sc=new Scanner(System.in);
    static public ArrayList<Employee> ListEmployee = new ArrayList<>();
    private int id;
    private String name;
    private String address;
    private String phone;
    private String position;

    Employee(int employeeId,String name,String address,String phone,String position)
    {
        this.id=employeeId;
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.position=position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    static int employeeMenu()
    {
        System.out.println("1-Add Employee");
        System.out.println("2-Remove Employee");
        System.out.println("3-Display Employee");
        System.out.println("4-Update Employee");
        System.out.println("0-Back");

        System.out.println("Enter your choice");
        int choice=sc.nextInt();

        return choice;
    }

    static public void add(Employee employee) throws IOException, ClassNotFoundException {
        Employee.ListEmployee.clear();
        if (new File("store_employee.dat").exists())
            readFromEmployee();

        ListEmployee.add(employee);

        writeIntoEmployee();
        Employee.ListEmployee.clear();
    }

    static public int remove(int id) throws IOException, ClassNotFoundException {
        Employee.ListEmployee.clear();
        if (new File("store_employee.dat").exists())
            readFromEmployee();

        int flag=0;
        for (int i = 0; i < ListEmployee.size(); i++) {
            if(ListEmployee.get(i).getId()==id)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To delete Item");
                alert.setTitle("Confirmation Before Deletion");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    ListEmployee.remove(i);
                    flag = 1;
                    break;
                }
            }
        }

        writeIntoEmployee();
        Employee.ListEmployee.clear();

        return flag;
    }

    static public void update(int id , Employee employee) throws IOException, ClassNotFoundException {
        Employee.ListEmployee.clear();
        if (new File("store_employee.dat").exists())
            readFromEmployee();

        int index=0;
        for (int i = 0; i < ListEmployee.size(); i++) {
            System.out.println("Id"+id);

            if (Employee.ListEmployee.get(i).getId()==id)
            {
                System.out.println("In If");
                index=i;
                break;
            }

        }
        ListEmployee.set(index,employee);

        writeIntoEmployee();
        Employee.ListEmployee.clear();
    }

    public static ArrayList<Employee> display() throws IOException, ClassNotFoundException {
        readFromEmployee();

        return ListEmployee;
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
    }    static public void writeIntoEmployee() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store_employee.dat"));
        for (Employee employee : Employee.ListEmployee) {
            oos.writeObject(employee);
        }
        oos.close();
    }


    public int getId() {
        return id;
    }

    public void setId(int employeeId) {
        this.id = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String lastName) {
        this.address = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
