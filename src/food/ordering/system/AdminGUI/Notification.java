/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.AdminGUI;

/**
 *
 * @author LENOVO
 */
public class Notification {
    private int notificationID;
    private NotifType notifType;
    private int userID;
    private UserType userType;
    private String description;
    
    public enum UserType{
        CUSTOMER,
        RUNNER,
        VENDOR
    }
    
    public enum NotifType {
        ORDER,
        USERPROFILE,
        TOPUP
    }
    
    public Notification(int notificationID, NotifType notifType, int userID, UserType userType, String description) {
        this.notificationID = notificationID;
        this.notifType = notifType;
        this.userID = userID;
        this.userType = userType;
        this.description = description;
    }
    
    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotifType getNotifType() {
        return notifType;
    }

    public void setNotifType(NotifType notifType) {
        this.notifType = notifType;
    }
    
    @Override
    public String toString() {
        String delimeter = ";";
        return notificationID + delimeter + notifType + delimeter + userID + delimeter + userType + delimeter + description;
    }
}
