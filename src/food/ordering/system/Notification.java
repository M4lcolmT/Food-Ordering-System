/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Notification {
    private int notificationID;
    private NotifType notifType;
    private int userID;
    private NotifUserType userType;
    private int typeID; // For order ID and top up request ID
    private String updateDescription;
    private LocalDateTime dateTime;
    
    TextFilePaths path = new TextFilePaths();
    String notificationTextFilePath = path.getNotificationsTextFile();
    
    public enum NotifUserType{
        CUSTOMER,
        RUNNER,
        VENDOR
    }
    
    public enum NotifType {
        ORDER,
        USERPROFILE,
        TOPUP
    }
    
    public Notification(int notificationID, NotifType notifType, int userID, NotifUserType userType, int typeID, String updateDescription, LocalDateTime dateTime) {
        this.notificationID = notificationID;
        this.notifType = notifType;
        this.userID = userID;
        this.userType = userType;
        this.typeID = typeID;
        this.updateDescription = updateDescription;
        this.dateTime = dateTime;
    }
    
    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }
    
    public NotifUserType getUserType() {
        return userType;
    }

    public void setUserType(NotifUserType userType) {
        this.userType = userType;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public NotifType getNotifType() {
        return notifType;
    }

    public void setNotifType(NotifType notifType) {
        this.notifType = notifType;
    }
    
    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }
    
    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void saveNotification(Notification newNotification) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(notificationTextFilePath, true))) {
            pw.println(newNotification.toString());                    
        } catch (IOException ex) {
            System.out.println("Failed to save!");
        }
    }
    
    @Override
    public String toString() {
        String delimeter = ";";
        return notificationID + delimeter + notifType + delimeter + userID + delimeter + userType + delimeter + typeID + delimeter + updateDescription + delimeter + dateTime;
    }
}
