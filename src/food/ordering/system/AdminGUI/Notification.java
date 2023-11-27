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
    private int typeID; // For orderID, userRequestID, and topUpRequestID
    private int userID;
    private NotifUserType userType;
    
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
    
    public Notification(int notificationID, NotifType notifType, int typeID, int userID, NotifUserType userType) {
        this.notificationID = notificationID;
        this.notifType = notifType;
        this.typeID = typeID;
        this.userID = userID;
        this.userType = userType;
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

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
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
    
    @Override
    public String toString() {
        String delimeter = ";";
        return notificationID + delimeter + notifType + delimeter + typeID + delimeter + userID + delimeter + userType;
    }
}
