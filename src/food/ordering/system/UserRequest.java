package food.ordering.system;

/**
 *
 * @author LENOVO
 */
public class UserRequest {
    private int userRequestID;
    private int userID;
    private UserType userType;
    private RequestType requestType;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;
    
    public enum UserType{
        CUSTOMER,
        RUNNER,
        VENDOR
    }
    
    public enum RequestType{
        CHANGEPASSWORD,
        UPDATEPROFILE,
        NEWPROFILE,
        DELETEPROFILE
    }
    
    public UserRequest(int userRequestID, int userID, UserType userType, RequestType requestType, String name, String phoneNumber, String email, String password, String address) {
        this.userRequestID = userRequestID;
        this.userID = userID;
        this.userType = userType;
        this.requestType = requestType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    
    public int getUserRequestID() {
        return userRequestID;
    }

    public void setUserRequestID(int userRequestID) {
        this.userRequestID = userRequestID;
    }
    
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String toFormmatedString() {
        return toString();
    }
    
    @Override
    public String toString() {
        String delimiter = ";";
        return userRequestID + delimiter + userID + delimiter + 
                userType + delimiter + requestType + delimiter + 
                name + delimiter + phoneNumber + delimiter + 
                email + delimiter + password + delimiter + address;
    }
}
