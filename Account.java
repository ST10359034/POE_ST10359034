/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.account;

/**
 *
 * @author lab_services_student
 */




import javax.swing.JOptionPane;

public class Account {
    public static void main(String[] args) {
        LOgin log1 = new LOgin();

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        while (true) {
            String[] options = {"Login", "Register", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Account System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                String enteredUsername = JOptionPane.showInputDialog("Please enter your username:");
                String enteredPassword = JOptionPane.showInputDialog("Please enter your password:");
                boolean loginSuccess = log1.verifyCredentials(enteredUsername, enteredPassword);
                JOptionPane.showMessageDialog(null, log1.returnLoginStatus(loginSuccess));

                if (loginSuccess) {
                    JOptionPane.showMessageDialog(null, "Login successful!");

                    while (true) {
                        String[] menuOptions = {"Add Task", "Show Report", "Display Done Tasks", "Display Longest Task", "Search Task", "Search Tasks by Developer", "Delete Task", "Quit"};
                        int menuChoice = JOptionPane.showOptionDialog(null, "Choose an option:", "Menu",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuOptions, menuOptions[0]);

                        if (menuChoice == 0) {
                            log1.addTask();
                        } else if (menuChoice == 1) {
                            log1.showReport();
                        } else if (menuChoice == 2) {
                            log1.displayDoneTasks();
                        } else if (menuChoice == 3) {
                            log1.displayLongestTask();
                        } else if (menuChoice == 4) {
                            log1.searchTask();
                        } else if (menuChoice == 5) {
                            log1.searchTasksByDeveloper();
                        } else if (menuChoice == 6) {
                        String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete:");
                        boolean taskDeleted = log1.deleteTask(deleteTaskName);
                        if (taskDeleted) {
                        JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                        } else {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                        }


                        } else {
                            int totalTaskDuration = log1.getTotalTaskDuration();
                            JOptionPane.showMessageDialog(null, "Total task duration: " + totalTaskDuration + " hours");
                            System.exit(0);
                        }
                    }
                }
            } else if (choice == 1) {
                String fName = JOptionPane.showInputDialog("Please enter your first name:");
                String lName = JOptionPane.showInputDialog("Please enter your last name:");
                String username = JOptionPane.showInputDialog("Please enter a username with an underscore and not more than 5 characters:");
                String password = JOptionPane.showInputDialog("Please enter a password that is at least 8 characters long, contains a capital letter, a number, and a special character:");

                String registrationStatus = log1.registerUser(fName, lName, username, password);
                JOptionPane.showMessageDialog(null, registrationStatus);
            } else {
                System.exit(0);
            }
        }
    }
}
