//FA22

package Store;

import java.io.Serializable;
import Store.*;

public class Workers extends Employee implements Serializable {

    public Workers(int employeeId, String Name, String address,String phone, String position) {
        super(employeeId, Name, address,phone, position);
    }
}

