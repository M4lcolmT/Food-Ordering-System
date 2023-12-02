/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Review {
    private int userID;
    private UserType userType;
    private int typeID; // For order id and task id
    private String review;
    private int rating;

    TextFilePaths path = new TextFilePaths();
    String reviewTextFilePath = path.getReviewsTextFile();
    
    public enum UserType {
        RUNNER,
        VENDOR
    } 
    
    public Review(int userID, UserType userType, int typeID, String review, int rating) {
        this.userID = userID;
        this.userType = userType;
        this.typeID = typeID;
        this.review = review;
        this.rating = rating;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
    
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void saveReview(Review review) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(reviewTextFilePath, true))) {
            pw.println(review.toString());                    
        } catch (IOException ex) {
            System.out.println("Failed to save!");
        }
    }

    @Override
    public String toString() {
        String delimiter = ";";
        return userID + delimiter + userType + delimiter + typeID + delimiter + review + delimiter + rating;
    }
}
