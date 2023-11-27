/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.RunnerGUI;

/**
 *
 * @author LENOVO
 */
public class Task {
    private int taskID;
    private int runnerID;
    private int orderID;
    private TaskStatus taskStatus;
    private double deliveryFee;
    
    public enum TaskStatus {
        PENDING,
        ACCEPTED,
        DECLINED,
        PICKED_UP,
        ON_THE_WAY,
        DELIVERED
    }
    
    public Task(int taskID, int runnerID, int orderID, TaskStatus taskStatus, double deliveryFee) {
        this.taskID = taskID;
        this.runnerID = runnerID;
        this.orderID = orderID;
        this.taskStatus = taskStatus;
        this.deliveryFee = deliveryFee;
    }
    
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getRunnerID() {
        return runnerID;
    }

    public void setRunnerID(int runnerID) {
        this.runnerID = runnerID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
