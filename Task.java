/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.account;

/**
 *
 * @author lab_services_student
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = "In Progress";
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public void setDeveloperFirstName(String developerFirstName) {
        this.developerFirstName = developerFirstName;
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public void setDeveloperLastName(String developerLastName) {
        this.developerLastName = developerLastName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String generateTaskReport() {
        StringBuilder report = new StringBuilder();
        report.append("Task ID: ").append(generateTaskID()).append("\n");
        report.append("Task Name: ").append(taskName).append("\n");
        report.append("Task Number: ").append(taskNumber).append("\n");
        report.append("Task Description: ").append(taskDescription).append("\n");
        report.append("Developer Name: ").append(developerFirstName).append(" ").append(developerLastName).append("\n");
        report.append("Task Duration: ").append(taskDuration).append(" hours").append("\n");
        report.append("Task Status: ").append(taskStatus).append("\n");
        return report.toString();
    }

    public String generateTaskID() {
        String developerInitials = developerFirstName.substring(0, 2).toUpperCase();
        String taskID = developerInitials + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3);
        return taskID;
    }
}
