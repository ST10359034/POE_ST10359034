/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.account;

/**
 *
 * @author lab_services_student
 */
// LOgin.java

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class LOgin {
    private String username;
    private String password;
    private String fName;
    private String lName;
    private List<Task> tasks;

    public LOgin() {
        tasks = new ArrayList<>();
    }

    public void setCredentials(String username, String password, String fName, String lName) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }

    public boolean verifyCredentials(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return password.length() >= 8 && hasUpperCase && hasNumber && hasSpecialChar;
    }

    public String registerUser(String fName, String lName, String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correct, please ensure that your username contains an underscore and is not more than 5 characters long.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correct, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            setCredentials(username, password, fName, lName);
            return "Registration successful! Welcome " + fName + " " + lName + ".";
        }
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + fName + ", " + lName + ". It's great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addTask() {
        String developerFirstName = JOptionPane.showInputDialog("Enter the developer's first name:");
        String developerLastName = JOptionPane.showInputDialog("Enter the developer's last name:");
        String taskName = JOptionPane.showInputDialog("Enter the task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter the task description:");
        String taskNumberString = JOptionPane.showInputDialog("Enter the task number:");
        int taskNumber = Integer.parseInt(taskNumberString);
        String taskDurationString = JOptionPane.showInputDialog("Enter the task duration in hours:");
        int taskDuration = Integer.parseInt(taskDurationString);

        Task task = new Task(taskName, taskNumber, taskDescription, developerFirstName, developerLastName, taskDuration);
        addTask(task);
    }

    public void showReport() {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            report.append(task.generateTaskReport()).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public void displayDoneTasks() {
        StringBuilder doneTasks = new StringBuilder();
        for (Task task : tasks) {
            if (task.getTaskStatus().equals("Done")) {
                doneTasks.append("Developer: ")
                        .append(task.getDeveloperFirstName())
                        .append(" ")
                        .append(task.getDeveloperLastName())
                        .append(", Task Name: ")
                        .append(task.getTaskName())
                        .append(", Task Duration: ")
                        .append(task.getTaskDuration())
                        .append(" hours\n");
            }
        }
        if (doneTasks.length() == 0) {
            JOptionPane.showMessageDialog(null, "No tasks with 'Done' status found.");
        } else {
            JOptionPane.showMessageDialog(null, "Tasks with 'Done' status:\n\n" + doneTasks.toString());
        }
    }

    public void displayLongestTask() {
        int longestDuration = 0;
        Task longestTask = null;
        for (Task task : tasks) {
            if (task.getTaskDuration() > longestDuration) {
                longestDuration = task.getTaskDuration();
                longestTask = task;
            }
        }
        if (longestTask != null) {
            JOptionPane.showMessageDialog(null, "Longest task:\n\nDeveloper: " + longestTask.getDeveloperFirstName()
                    + " " + longestTask.getDeveloperLastName() + "\nDuration: " + longestTask.getTaskDuration() + " hours");
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found.");
        }
    }

    public void searchTask() {
        String searchTaskName = JOptionPane.showInputDialog("Enter the task name to search:");
        boolean taskFound = false;
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(searchTaskName)) {
                JOptionPane.showMessageDialog(null, "Task Found:\n\nTask Name: " + task.getTaskName() +
                        "\nDeveloper: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() +
                        "\nTask Status: " + task.getTaskStatus());
                taskFound = true;
                break;
            }
        }
        if (!taskFound) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    public void searchTasksByDeveloper() {
        String searchDeveloper = JOptionPane.showInputDialog("Enter the developer name to search tasks:");
        boolean tasksFound = false;
        StringBuilder tasksByDeveloper = new StringBuilder();
        for (Task task : tasks) {
            if (task.getDeveloperFirstName().equalsIgnoreCase(searchDeveloper) || task.getDeveloperLastName().equalsIgnoreCase(searchDeveloper)) {
                tasksByDeveloper.append("Task Name: ")
                        .append(task.getTaskName())
                        .append(", Task Status: ")
                        .append(task.getTaskStatus())
                        .append("\n");
                tasksFound = true;
            }
        }
        if (tasksFound) {
            JOptionPane.showMessageDialog(null, "Tasks assigned to " + searchDeveloper + ":\n\n" + tasksByDeveloper.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for the given developer.");
        }
    

   
        
        
    }

    public int getTotalTaskDuration() {
        int totalDuration = 0;
        for (Task task : tasks) {
            totalDuration += task.getTaskDuration();
        }
        return totalDuration;
    }
public List<Task> getTasks() {
    return tasks;
}

public Task getLongestTask() {
    int longestDuration = 0;
    Task longestTask = null;
    for (Task task : tasks) {
        if (task.getTaskDuration() > longestDuration) {
            longestDuration = task.getTaskDuration();
            longestTask = task;
        }
    }
    return longestTask;
}

public Task searchTaskByName(String taskName) {
    for (Task task : tasks) {
        if (task.getTaskName().equalsIgnoreCase(taskName)) {
            return task;
        }
    }
    return null;
}

public String searchTasksByDeveloper(String developerName) {
    StringBuilder tasksByDeveloper = new StringBuilder();
    for (Task task : tasks) {
        if (task.getDeveloperFirstName().equalsIgnoreCase(developerName) || task.getDeveloperLastName().equalsIgnoreCase(developerName)) {
            tasksByDeveloper.append("Task Name: ")
                    .append(task.getTaskName())
                    .append(", Task Status: ")
                    .append(task.getTaskStatus())
                    .append("\n");
        }
    }
    return tasksByDeveloper.toString();
}

public boolean deleteTask(String taskName) {
    boolean value= false;
    for (int i = 0; i < tasks.size(); i++) {
        Task task = tasks.get(i);
        if (task.getTaskName().equalsIgnoreCase(taskName)) {
            tasks.remove(i);
            value= true;
        }else 
        {
             value = false;
        }
        
    }
   return value;
    
}






public String generateTaskReport() {
    StringBuilder report = new StringBuilder();
    for (Task task : tasks) {
        report.append("Task ID: ").append(task.generateTaskID()).append("\n");
        report.append("Task Name: ").append(task.getTaskName()).append("\n");
        report.append("Task Number: ").append(task.getTaskNumber()).append("\n");
        report.append("Task Description: ").append(task.getTaskDescription()).append("\n");
        report.append("Developer Name: ").append(task.getDeveloperFirstName()).append(" ").append(task.getDeveloperLastName()).append("\n");
        report.append("Task Duration: ").append(task.getTaskDuration()).append(" hours").append("\n");
        report.append("Task Status: ").append(task.getTaskStatus()).append("\n\n");
    }
    return report.toString();
}

  

   
}
