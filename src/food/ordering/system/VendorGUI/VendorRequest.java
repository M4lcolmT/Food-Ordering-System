
package food.ordering.system.VendorGUI;

import food.ordering.system.AdminGUI.UserRequest;

/**
 *
 * @author LENOVO
 */
public class VendorRequest extends UserRequest{
    private String description;
    private String operationHours;
    private String operationDays;
    
    public VendorRequest(int userRequestID, int userID, UserType userType, RequestType requestType, String name, String phoneNumber, String email, String password, String address, String description, String operationHours, String operationDays) {
        super(userRequestID, userID, userType, requestType, name, phoneNumber, email, password, address);
        this.description = description;
        this.operationHours = operationHours;
        this.operationDays = operationDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationHours() {
        return operationHours;
    }

    public void setOperationHours(String operationHours) {
        this.operationHours = operationHours;
    }

    public String getOperationDays() {
        return operationDays;
    }

    public void setOperationDays(String operationDays) {
        this.operationDays = operationDays;
    }

    @Override
    public String toString() {
        String delimiter = ";";
        return super.toString() + delimiter + description + delimiter + operationHours + delimiter + operationDays;
    }
}
