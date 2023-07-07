/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private LOgin log1;

    @BeforeEach
    public void setUp() {
        log1 = new LOgin();
      
        Task task1 = new Task("Create Login", 1, "Test Data Task 1", "Mike", "Smith", 5);
        task1.setTaskStatus("To Do");
        Task task2 = new Task("Create Add Features", 2, "Test Data Task 2", "Edward", "Harrison", 8);
        task2.setTaskStatus("Doing");
        Task task3 = new Task("Create Reports", 3, "Test Data Task 3", "Samantha", "Paulson", 2);
        task3.setTaskStatus("Done");
        Task task4 = new Task("Add Arrays", 4, "Test Data Task 4", "Glenda", "Oberholzer", 11);
        task4.setTaskStatus("To Do");

        log1.addTask(task1);
        log1.addTask(task2);
        log1.addTask(task3);
        log1.addTask(task4);
    }

    @Test
    public void testDeveloperArrayPopulated() {
       
        assertEquals(4, log1.getTasks().size());
    }

    @Test
    public void testLongestTaskDuration() {
        
        Task longestTask = log1.getLongestTask();
        assertNotNull(longestTask);
        assertEquals("Add Arrays", longestTask.getTaskName());
        assertEquals(11, longestTask.getTaskDuration());
    }

    @Test
    public void testSearchTask() {
        
        Task foundTask = log1.searchTaskByName("Create Login");
        assertNotNull(foundTask);
        assertEquals("Mike", foundTask.getDeveloperFirstName());
        assertEquals("Smith", foundTask.getDeveloperLastName());
    }

    @Test
public void testSearchTasksByDeveloper() {
    String developerName = "Samantha Paulson";
    String expectedTasksByDeveloper = "Task Name: Create Reports, Task Status: Done\n";
    String tasksByDeveloper = log1.searchTasksByDeveloper(developerName);
    assertEquals(expectedTasksByDeveloper, tasksByDeveloper);
}


   @Test
public void testDeleteTask() {
    
    String taskName = "Create Reports";
    assertTrue(log1.deleteTask(taskName));
    assertNull(log1.searchTaskByName(taskName));
}


   @Test
public void testGenerateTaskReport() {
    String expectedReport = "Task ID: MI:1:Smith\n" +
            "Task Name: Create Login\n" +
            "Task Number: 1\n" +
            "Task Description: Test Data Task 1\n" +
            "Developer Name: Mike Smith\n" +
            "Task Duration: 5 hours\n" +
            "Task Status: To Do\n" +
            "Task ID: ED:2:Harrison\n" +
            "Task Name: Create Add Features\n" +
            "Task Number: 2\n" +
            "Task Description: Test Data Task 2\n" +
            "Developer Name: Edward Harrison\n" +
            "Task Duration: 8 hours\n" +
            "Task Status: Doing\n" +
            "Task ID: SA:3:Paulson\n" +
            "Task Name: Create Reports\n" +
            "Task Number: 3\n" +
            "Task Description: Test Data Task 3\n" +
            "Developer Name: Samantha Paulson\n" +
            "Task Duration: 2 hours\n" +
            "Task Status: Done\n" +
            "Task ID: GL:4:Oberholzer\n" +
            "Task Name: Add Arrays\n" +
            "Task Number: 4\n" +
            "Task Description: Test Data Task 4\n" +
            "Developer Name: Glenda Oberholzer\n" +
            "Task Duration: 11 hours\n" +
            "Task Status: To Do\n";

    String taskReport = log1.generateTaskReport();
    assertEquals(expectedReport, taskReport);
}

}