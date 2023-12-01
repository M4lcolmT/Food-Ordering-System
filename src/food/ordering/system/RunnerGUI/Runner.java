/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.RunnerGUI;

import food.ordering.system.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Runner extends User{
    private int runnerID;
    private boolean runnerAvailability;
    private String city;
    private String plateNumber;
    private String vehicleModel;
    private double ratings;
    
    TextFilePaths path = new TextFilePaths();
    String runnerTextFilePath = path.getRunnerTextFile();

    public Runner(int runnerID, boolean runnerAvailability, String name, String phoneNumber, String email, String password, String city, String plateNumber, String vehicleModel, double ratings) {
        super(name, phoneNumber, email, password);
        this.runnerID = runnerID;
        this.runnerAvailability = runnerAvailability;
        this.city = city;
        this.plateNumber = plateNumber;
        this.vehicleModel = vehicleModel;
        this.ratings = ratings;
    }
    
    public int getRunnerID() {
        return runnerID;
    }

    public void setRunnerID(int runnerID) {
        this.runnerID = runnerID;
    }

    public boolean isRunnerAvailability() {
        return runnerAvailability;
    }

    public void setRunnerAvailability(boolean runnerAvailability) {
        this.runnerAvailability = runnerAvailability;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
    
    public void updateRunnerStatus(Runner availableRunner, List<Runner> runners, boolean availability) {
        int runnerId = availableRunner.getRunnerID();

        for (Runner runner : runners) {
            if (runnerId == runner.getRunnerID()) {
                // Update the runner availability directly
                runner.setRunnerAvailability(availability);
            }
        }

        // Filter and sort the data
        List<Runner> filteredItems = runners.stream()
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(Runner::getRunnerID));

        // Update the file with the new runner status
        try (PrintWriter writer = new PrintWriter(new FileWriter(runnerTextFilePath))) {
            // Write each runner item to the file
            for (Runner runnerItem : filteredItems) {
                writer.println(runnerItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public String toString() {
        String delimiter = ";";
        return runnerID + delimiter + runnerAvailability + delimiter + super.toString() + delimiter + city + delimiter + plateNumber + delimiter + vehicleModel;
    }
}
