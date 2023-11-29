/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.AdminGUI;

import java.time.LocalDateTime;

/**
 *
 * @author LENOVO
 */
public class Notification {
    private int notificationID;
    private NotifType notifType;
    private int userID;
    private NotifUserType userType;
    private int transactionID;
    private String updateDescription;
    private LocalDateTime dateTime;

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
    
    public Notification(int notificationID, NotifType notifType, int userID, NotifUserType userType, int transactionID, String updateDescription, LocalDateTime dateTime) {
        this.notificationID = notificationID;
        this.notifType = notifType;
        this.userID = userID;
        this.userType = userType;
        this.transactionID = transactionID;
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
    
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    @Override
    public String toString() {
        String delimeter = ";";
        return notificationID + delimeter + notifType + delimeter + userID + delimeter + userType + delimeter + transactionID + delimeter + updateDescription + delimeter + dateTime;
    }
}
