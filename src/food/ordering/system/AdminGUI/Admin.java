/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.User;

/**
 *
 * @author LENOVO
 */
public class Admin extends User{
    private int adminID;
    
    public Admin(int adminID, String name, String phoneNumber, String email, String password) {
        super(name, phoneNumber, email, password);
        this.adminID = adminID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}
