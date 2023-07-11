//FA22

package Store;

import java.io.Serializable;
import Store.*;

public class Managers extends Employee implements Serializable {
    public Managers(int employeeId, String Name, String address,String phone, String position) {
        super(employeeId, Name, address,phone, position);
    }
}
