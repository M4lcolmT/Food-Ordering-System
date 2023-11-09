/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.RunnerGUI;

import food.ordering.system.User;

/**
 *
 * @author LENOVO
 */
public class Runner extends User{

    private int runnerID;
    private String address;
    private String plateNumber;
    private String vehicleModel;

    public Runner(int runnerID, String name, String phoneNumber, String email, String password, String address, String plateNumber, String vehicleModel) {
        super(name, phoneNumber, email, password);
        this.runnerID = runnerID;
        this.address = address;
        this.plateNumber = plateNumber;
        this.vehicleModel = vehicleModel;
    }
    
    public int getRunnerID() {
        return runnerID;
    }

    public void setRunnerID(int runnerID) {
        this.runnerID = runnerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
