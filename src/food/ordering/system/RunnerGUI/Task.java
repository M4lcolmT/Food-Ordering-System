/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.RunnerGUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import textFiles.TextFilePaths;

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
    private LocalDateTime date;
    
    TextFilePaths path = new TextFilePaths();
    String taskTextFilePath = path.getRunnerTasksTextFile();
    
    public enum TaskStatus {
        PENDING,
        ACCEPTED,
        DECLINED,
        PICKED_UP,
        ON_THE_WAY,
        DELIVERED
    }
    
    public Task(int taskID, int runnerID, int orderID, TaskStatus taskStatus, double deliveryFee, LocalDateTime date) {
        this.taskID = taskID;
        this.runnerID = runnerID;
        this.orderID = orderID;
        this.taskStatus = taskStatus;
        this.deliveryFee = deliveryFee;
        this.date = date;
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

    public double getDeliveryFee() {
        return deliveryFee;
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

    public LocalDateTime getDate() {
        return date;
    }
    
    // Add individual task
    public void createTask(Task newTask) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(taskTextFilePath, true))) {
            pw.println(newTask.toString());
        } catch (IOException ex) {
            System.out.println("Failed to save!");
        }
    }
    
    public void updateTaskStatus(Task selectedTask, List<Task> tasks, Task.TaskStatus status) {
        int taskId = selectedTask.getTaskID();

        for (Task i : tasks) {
            if (taskId == i.getTaskID()) {
                i.setTaskStatus(status);
            }
        }

        // Filter and sort the data
        List<Task> filteredItems = tasks.stream()
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(Task::getTaskID));

        // Update the file with the new runner status
        try (PrintWriter writer = new PrintWriter(new FileWriter(taskTextFilePath))) {
            // Write each runner item to the file
            for (Task taskItem : filteredItems) {
                writer.println(taskItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        String delimiter = ";";
        return taskID + delimiter + runnerID + delimiter + orderID + delimiter + taskStatus + delimiter + deliveryFee + delimiter + date;
    }
}
