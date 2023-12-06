package food.ordering.system;

import food.ordering.system.AdminGUI.Admin;
import food.ordering.system.Notification.NotifType;
import food.ordering.system.Notification.NotifUserType;
import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.CustomerGUI.CustomerRequest;
import food.ordering.system.RunnerGUI.Runner;
import food.ordering.system.RunnerGUI.RunnerRequest;
import food.ordering.system.RunnerGUI.Task;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import food.ordering.system.VendorGUI.VendorRequest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    String userRequestsTextFilePath = filePaths.getUserCRUDrequestTextFile();
    String vendorMenuFilePath = filePaths.getVendorMenuTextFile();
    String topUpRequestsTextFilePath = filePaths.getTopUpRequestsTextFile();
    String notificationsTextFilePath = filePaths.getNotificationsTextFile();
    String tasksTextFilePath = filePaths.getRunnerTasksTextFile();
    String reviewsTextFilePath = filePaths.getReviewsTextFile();

    //Read customers from file
    public List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(customerTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 8) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    String streetAddress = parts[5];
                    String city = parts[6];
                    double credit = Double.parseDouble(parts[7]);
                    
                    Customer customerItem = new Customer(id, name, phoneNumber, email, password, streetAddress, city, credit);
                    customers.add(customerItem);
                } else {
                    System.out.println("Customer: Skipping a line with an incorrect number of parts");
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
                    System.out.println("Vendor: Skipping a line with an incorrect number of parts");
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
                if (parts.length == 10) {
                    int id = Integer.parseInt(parts[0]);
                    boolean availability = Boolean.parseBoolean(parts[1]); 
                    String name = parts[2];
                    String phoneNumber = parts[3];
                    String email = parts[4];
                    String password = parts[5];
                    String address = parts[6];
                    String plateNo = parts[7];
                    String vehicleModel = parts[8];
                    double rating = Double.parseDouble(parts[9]);
                    
                    Runner runnerItem = new Runner(id, availability, name, phoneNumber, email, password, address, plateNo, vehicleModel, rating);
                    runners.add(runnerItem);
                } else {
                    System.out.println("Runner: Skipping a line with an incorrect number of parts");
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
                    System.out.println("Admin: Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return admins;
    } 
    
    // User request ID list
    public List<Integer> readUserRequestID() {
        List<Integer> userRequestIDs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(userRequestsTextFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 0) { 
                    int userRequestID = Integer.parseInt(parts[0]);
                    userRequestIDs.add(userRequestID);
                } else {
                    System.out.println("User Request ID: Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userRequestIDs;
    } 
    
    //Reading the user request file
    public void readUserRequests(List<CustomerRequest> customerRequests, 
            List<VendorRequest> vendorRequests, List<RunnerRequest> runnerRequests) {
        try (BufferedReader br = new BufferedReader(new FileReader(userRequestsTextFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 3) {
                    String userType = parts[2];
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
        String category = parts[9];
        String description = parts[10];
        String operationHours = parts[11];
        String operationDays = parts[12];
        return new VendorRequest(requestID, userID, userType, requestType, name, phoneNumber, email, password, address, category, description, operationHours, operationDays);
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
    
    // Read top up requests
    public LocalDateTime parseDateTime(String dateTimeString) {
        try {
            // Try parsing the date time with nanoseconds
            return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS"));
        } catch (DateTimeParseException e) {
            try {
                // If parsing with nanoseconds fails, try parsing without nanoseconds
                return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
            } catch (DateTimeParseException ex) {
                // If both attempts fail, try parsing with the format 'yyyy-MM-dd'
                return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        }
    }
    
    // Read top up requests for admin
    public List<TopUpRequests> readTopUpRequests() {
        List<TopUpRequests> requests = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(topUpRequestsTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 10) {
                    int requestID = Integer.parseInt(parts[0]);
                    int customerID = Integer.parseInt(parts[1]);
                    int amount = Integer.parseInt(parts[2]);
                    String bankType = parts[3];
                    long cardNumber = Long.parseLong(parts[4]);
                    YearMonth monthYear = YearMonth.parse(parts[5], java.time.format.DateTimeFormatter.ofPattern("MM/yy"));
                    int cvv = Integer.parseInt(parts[6]);
                    String remarks = parts[7];
                    LocalDateTime datetime = parseDateTime(parts[8]);
                    TopUpRequests.TransactionStatus status = TopUpRequests.TransactionStatus.valueOf(parts[9]);
                    
                    TopUpRequests requestItem = new TopUpRequests(requestID, customerID, amount, bankType, cardNumber, monthYear, cvv, remarks, datetime, status);
                    requests.add(requestItem);
                } else {
                    System.out.println("Top Up Request: Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return requests;
    }
    
    // Read notifications from text file
    public List<Notification> readNotifications() {
        List<Notification> notifications = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(notificationsTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    NotifType notifType = NotifType.valueOf(parts[0]);
                    int userID = Integer.parseInt(parts[1]);
                    NotifUserType userType = NotifUserType.valueOf(parts[2]);
                    int transactionID = Integer.parseInt(parts[3]);
                    String updateDesc = parts[4];
                    LocalDateTime dateTime = parseDateTime(parts[5]);
                    
                    Notification newNotification = new Notification(notifType, userID, userType, transactionID, updateDesc, dateTime);
                    notifications.add(newNotification);
                } else {
                    System.out.println("Notification: Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return notifications;
    }
    
    // Read runners' tasks from text file
    public List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(tasksTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    int taskID = Integer.parseInt(parts[0]);
                    int runnerID = Integer.parseInt(parts[1]);
                    int orderID = Integer.parseInt(parts[2]);
                    Task.TaskStatus status = Task.TaskStatus.valueOf(parts[3]);
                    double deliveryFee = Double.parseDouble(parts[4]);
                    LocalDateTime date = parseDateTime(parts[5]);
                    
                    Task newTask = new Task(taskID, runnerID, orderID, status, deliveryFee, date);
                    tasks.add(newTask);
                } else {
                    System.out.println("Task: Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return tasks;
    }
    
    // Read reviews
    public List<Review> readReviews() {
        List<Review> reviews = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(reviewsTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    Review.UserType userType = Review.UserType.valueOf(parts[1]);
                    int typeID = Integer.parseInt(parts[2]);
                    String content = parts[3];
                    int rating = Integer.parseInt(parts[4]);
                    
                    Review newReview = new Review(id, userType, typeID, content, rating);
                    reviews.add(newReview);
                } else {
                    System.out.println("Review: Skipping lines with incorrect parts.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
