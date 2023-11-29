/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.RunnerGUI;

import food.ordering.system.AdminGUI.UserRequest;

/**
 *
 * @author LENOVO
 */
public class RunnerRequest extends UserRequest{
    private String vehicleModel;
    private String plateNumber;
    
    public RunnerRequest(int userRequestID, int userID, UserType userType, RequestType requestType, String name, String phoneNumber, String email, String password, String address, String vehicleModel, String plateNumber) {
        super(userRequestID, userID, userType, requestType, name, phoneNumber, email, password, address);
        this.vehicleModel = vehicleModel;
        this.plateNumber = plateNumber;
    }
    
    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        String delimeter = ";";
        return super.toString() + delimeter + vehicleModel + delimeter + plateNumber;
    }
    
}
