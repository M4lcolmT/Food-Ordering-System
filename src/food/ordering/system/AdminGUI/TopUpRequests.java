/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.AdminGUI;

import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 *
 * @author LENOVO
 */
public class TopUpRequests {
    private int requestID;
    private int customerID;
    private int amount;
    private String bankType;
    private long cardNumber;
    private YearMonth cardExpiryDate;
    private int cvv;
    private String remarks;
    private LocalDateTime dateTime;

    
    public TopUpRequests(int requestID, int customerID, int amount, String bankType, long cardNumber, YearMonth cardExpiryDate, int cvv, String remarks, LocalDateTime dateTime) {
        this.requestID = requestID;
        this.customerID = customerID;
        this.amount = amount;
        this.bankType = bankType;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.remarks = remarks;
        this.dateTime = dateTime;
    }
    
    public int getRequestID() {
        return requestID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getAmount() {
        return amount;
    }
    
    public String getBankType() {
        return bankType;
    }
    
    public Long getCardNumber() {
        return cardNumber;
    }

    public YearMonth getCardExpiryDate() {
        return cardExpiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public String getRemarks() {
        return remarks;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    @Override
    public String toString(){
        String delimiter = ";";
        String formattedExpiryDate = cardExpiryDate.format(java.time.format.DateTimeFormatter.ofPattern("MM/yy"));
        
        return requestID + delimiter + customerID + delimiter + amount + delimiter + bankType + delimiter + cardNumber + delimiter + 
                formattedExpiryDate + delimiter + cvv + delimiter + remarks + delimiter + dateTime;
    }
    
    
}
