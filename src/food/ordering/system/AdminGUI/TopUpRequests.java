/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.AdminGUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import textFiles.TextFilePaths;

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
    private TransactionStatus transactionStatus;
    
    TextFilePaths path = new TextFilePaths();
    String topUpRequestTextFilePath = path.getTopUpRequestsTextFile();

    public enum TransactionStatus {
        PENDING,
        APPROVED
    }
    
    public TopUpRequests(int requestID, int customerID, int amount, String bankType, long cardNumber, YearMonth cardExpiryDate, int cvv, String remarks, LocalDateTime dateTime, TransactionStatus transactionStatus) {
        this.requestID = requestID;
        this.customerID = customerID;
        this.amount = amount;
        this.bankType = bankType;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.remarks = remarks;
        this.dateTime = dateTime;
        this.transactionStatus = transactionStatus;
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
    
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus; 
    }
    
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }
    
    public void updateTransactionStatus(TopUpRequests request, List<TopUpRequests> requests) {
        int requestId = request.getRequestID();

        for (TopUpRequests item : requests) {
            if (requestId == item.getRequestID()) {
                // Update the transaction status 
                item.setTransactionStatus(TopUpRequests.TransactionStatus.APPROVED);
            }
        }

        // Filter and sort the data
        List<TopUpRequests> filteredItems = requests.stream()
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(TopUpRequests::getRequestID));

        // Update the file with the new runner status
        try (PrintWriter writer = new PrintWriter(new FileWriter(topUpRequestTextFilePath))) {
            // Write each runner item to the file
            for (TopUpRequests i : filteredItems) {
                writer.println(i.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        String delimiter = ";";
        String formattedExpiryDate = cardExpiryDate.format(java.time.format.DateTimeFormatter.ofPattern("MM/yy"));
        
        return requestID + delimiter + customerID + delimiter + amount + delimiter + bankType + delimiter + cardNumber + delimiter + 
                formattedExpiryDate + delimiter + cvv + delimiter + remarks + delimiter + dateTime + delimiter + transactionStatus;
    }
    
    
}
