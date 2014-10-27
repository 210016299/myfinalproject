/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseph.myfinalproject.test.repository;

import com.joseph.myfinalproject.app.conf.ConnectionConfig;
import com.joseph.myfinalproject.domain.Address;
import com.joseph.myfinalproject.domain.Details;
import com.joseph.myfinalproject.domain.Students;
import com.joseph.myfinalproject.repository.StudentsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author theresa
 */
public class StudentRepositoryTest {
     public static ApplicationContext ctx;
    private Long id;
    private StudentsRepository studentsRepository;
    public StudentRepositoryTest() {
    }

    @Test(enabled = false)
    public void createDelivery() {
        studentsRepository = ctx.getBean(StudentsRepository.class);

        Address dAddress = new Address();
        dAddress.setHouse_number(5);
        dAddress.setStreet_address("Main Road");
        dAddress.setSuburb("Cape Town");
        
        Details sDetails = new Details();
        sDetails.setFirstname("Peter");
        sDetails.setLastname("Pan");
        sDetails.setContactnumber("021 568 7325");
        
        Students student = new Students.Builder().address(dAddress).details(sDetails).build();
        
        studentsRepository.save(student);
        
        id = student.getId();
        Assert.assertNotNull(student);
    }
    
    @Test(dependsOnMethods = "createDelivery", enabled = true)
    public void readDelivery() {
        studentsRepository = ctx.getBean(StudentsRepository.class);
        Students student = studentsRepository.findOne(id);
        
        Assert.assertEquals(student.getDetails().getLastname(), "Pan");         //Finds a customer's last name of Pan
        System.out.println("Customer's Lastname: " + student.getDetails()
                .getLastname());                                                        //Testing output
    }
    
    @Test(dependsOnMethods = "readDelivery", enabled = true)
    public void updateDelivery(){
        studentsRepository = ctx.getBean(StudentsRepository.class);
        Students student = studentsRepository.findOne(id);
        
        
        Address sAddress = new Address();
        sAddress.setHouse_number(5);
        sAddress.setStreet_address("Main Road");
        sAddress.setSuburb("Cape Town");
        
        Details cDetails = new Details();
        cDetails.setFirstname("Peter");
        cDetails.setLastname("Smith");
        cDetails.setContactnumber("021 568 7325");
        
        Students updatedStudent = new Students.Builder().Students_id("210016299").address(sAddress).details(cDetails).build();
        studentsRepository.save(updatedStudent);
        
        Students newStudent = studentsRepository.findOne(id);
        
        Assert.assertEquals(newStudent.getDetails().getLastname(), "Pan");
     } 
    
    @Test(priority = 4, dependsOnMethods = "updateDelivery", enabled = false)
    public void deleteDelivery(){
        studentsRepository = ctx.getBean(StudentsRepository.class);
        Students students = studentsRepository.findOne(id);
        
        studentsRepository.delete(students);
        Students deletedStudent = studentsRepository.findOne(id);

        Assert.assertNull(deletedStudent);
        System.out.println("Deleted Student: " + deletedStudent);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
