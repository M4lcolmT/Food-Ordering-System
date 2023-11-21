/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.CustomerGUI.CustomerRequest;
import food.ordering.system.RunnerGUI.Runner;
import food.ordering.system.RunnerGUI.RunnerRequest;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import food.ordering.system.VendorGUI.VendorRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class ReadFiles {
    TextFilePaths filePaths = new TextFilePaths();
    String customerTextFilePath = filePaths.getCustomerTextFile();
    String vendorTextFilePath = filePaths.getVendorTextFile();
    String runnerTextFilePath = filePaths.getRunnerTextFile();
    String adminTextFilePath = filePaths.getAdminTextFile();
    
    //Read customers from file
    public List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(customerTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    String streetAddress = parts[5];
                    String city = parts[6];
                    
                    Customer customerItem = new Customer(id, name, phoneNumber, email, password, streetAddress, city);
                    customers.add(customerItem);
                } else {
                    System.out.println("Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return customers;
    }
    
    //Read vendors from file
    public List<Vendor> readVendors() {
        List<Vendor> vendors = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(vendorTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 11) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    double rating = Double.parseDouble(parts[5]);
                    String category = parts[6];
                    String address = parts[7];
                    String description = parts[8];
                    String operationHours = parts[9];
                    String operationDays = parts[10];

                    Vendor vendorItem = new Vendor(id, name, phoneNumber, email, password, rating, category, address,
                    description, operationHours, operationDays);
                    vendors.add(vendorItem);
                } else {
                    System.out.println("Incomplete vendor data!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendors;
    }
    
    
    public List<Runner> readRunners() {
        List<Runner> runners = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(runnerTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 8) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    String address = parts[5];
                    String plateNo = parts[6];
                    String vehicleModel = parts[7];
                    
                    Runner runnerItem = new Runner(id, name, phoneNumber, email, password, address, plateNo, vehicleModel);
                    runners.add(runnerItem);
                } else {
                    System.out.println("Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return runners;
    }
    
    //Read admins from file
    public List<Admin> readAdmins() {
        List<Admin> admins = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(adminTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    
                    Admin adminItem = new Admin(id, name, phoneNumber, email, password);
                    admins.add(adminItem);
                } else {
                    System.out.println("Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return admins;
    }
    
    public List<Integer> readUserRequestID(String filePath) {
        List<Integer> userRequestIDs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 0) { // Check if there's at least one item in the line
                    int userRequestID = Integer.parseInt(parts[0]);
                    userRequestIDs.add(userRequestID);
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userRequestIDs;
    } 
    
    //Reading the user request file
    public void readUserRequests(String filePath, List<CustomerRequest> customerRequests, List<VendorRequest> vendorRequests, List<RunnerRequest> runnerRequests) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 1) {
                    String userType = parts[1];
                    switch (userType) {
                        case "CUSTOMER":
                            customerRequests.add(processCustomer(parts));
                            break;
                        case "VENDOR":
                            vendorRequests.add(processVendor(parts));
                            break;
                        case "RUNNER":
                            runnerRequests.add(processRunner(parts));
                            break;
                        default:
                            System.out.println("Unknown user type.");
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CustomerRequest processCustomer(String[] parts) {
        int requestID = Integer.parseInt(parts[0]);
        int userID = Integer.parseInt(parts[1]);
        UserRequest.UserType usertype = UserRequest.UserType.valueOf(parts[2].toUpperCase());
        UserRequest.RequestType requestType = UserRequest.RequestType.valueOf(parts[3].toUpperCase());
        String name = parts[4];
        String phoneNumber = parts[5];
        String email = parts[6];
        String password = parts[7];
        String address = parts[8];
        String city = parts[9];
        return new CustomerRequest(requestID, userID, usertype, requestType, name, phoneNumber, email, password, address, city);
    }


    private static VendorRequest processVendor(String[] parts) {
        int requestID = Integer.parseInt(parts[0]);
        int userID = Integer.parseInt(parts[1]);
        UserRequest.UserType userType = UserRequest.UserType.valueOf(parts[2].toUpperCase());
        UserRequest.RequestType requestType = UserRequest.RequestType.valueOf(parts[3].toUpperCase());
        String name = parts[4];
        String phoneNumber = parts[5];
        String email = parts[6];
        String password = parts[7];
        String address = parts[8];
        String description = parts[9];
        String operationHours = parts[10];
        String operationDays = parts[11];
        return new VendorRequest(requestID, userID, userType, requestType, name, phoneNumber, email, password, address, description, operationHours, operationDays);
    }

    private static RunnerRequest processRunner(String[] parts) {
        int requestID = Integer.parseInt(parts[0]);
        int userID = Integer.parseInt(parts[1]);
        UserRequest.UserType userType = UserRequest.UserType.valueOf(parts[2].toUpperCase());
        UserRequest.RequestType requestType = UserRequest.RequestType.valueOf(parts[3].toUpperCase());
        String name = parts[4];
        String phoneNumber = parts[5];
        String email = parts[6];
        String password = parts[7];
        String address = parts[8];
        String plateNumber = parts[9];
        String model = parts[10];
        return new RunnerRequest(requestID, userID, userType, requestType, name, phoneNumber, email, password, address, plateNumber, model);
    }
}
