/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseph.myfinalproject.test.repository;

import com.joseph.myfinalproject.app.conf.ConnectionConfig;
import com.joseph.myfinalproject.domain.Address;
import com.joseph.myfinalproject.domain.Details;
import com.joseph.myfinalproject.domain.Teacher;
import com.joseph.myfinalproject.domain.Teacher;
import com.joseph.myfinalproject.repository.TeacherRepository;
import com.joseph.myfinalproject.repository.TeacherRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author theresa
 */
public class TeacherRepositoryTest {
     public static ApplicationContext ctx;
    private Long id;
    private TeacherRepository teacherRepository;
    public TeacherRepositoryTest() {
    }

    @Test(enabled = false)
    public void createDelivery() {
        teacherRepository = ctx.getBean(TeacherRepository.class);

        Address dAddress = new Address();
        dAddress.setHouse_number(27);
        dAddress.setStreet_address("Main Road");
        dAddress.setSuburb("Cape Town");
        
        Details sDetails = new Details();
        sDetails.setFirstname("Batman");
        sDetails.setLastname("The Joker");
        sDetails.setContactnumber("021 568 7337");
        
        Teacher teacher = new Teacher.Builder().address(dAddress).details(sDetails).build();
        
        teacherRepository.save(teacher);
        
        id = teacher.getId();
        Assert.assertNotNull(teacher);
    }
    
    @Test(dependsOnMethods = "createDelivery", enabled = false)
    public void readDelivery() {
        teacherRepository = ctx.getBean(TeacherRepository.class);
        Teacher teacher = teacherRepository.findOne(id);
        
        Assert.assertEquals(teacher.getDetails().getLastname(), "Pan");         //Finds a customer's last name of Pan
        System.out.println("Teacher's Lastname: " + teacher.getDetails()
                .getLastname());                                                        //Testing output
    }
    
    @Test(dependsOnMethods = "readDelivery", enabled = false)
    public void updateDelivery(){
        teacherRepository = ctx.getBean(TeacherRepository.class);
        Teacher student = teacherRepository.findOne(id);
        
        
        Address sAddress = new Address();
        sAddress.setHouse_number(5);
        sAddress.setStreet_address("Main Road");
        sAddress.setSuburb("Cape Town");
        
        Details cDetails = new Details();
        cDetails.setFirstname("Peter");
        cDetails.setLastname("Smith");
        cDetails.setContactnumber("021 568 7325");
        
        Teacher updatedTeacher = new Teacher.Builder().Teacher_id("210016299").address(sAddress).details(cDetails).build();
        teacherRepository.save(updatedTeacher);
        
        Teacher newTeacher = teacherRepository.findOne(id);
        
        Assert.assertEquals(newTeacher.getDetails().getLastname(), "Pan");
     } 
    
    @Test(priority = 4, dependsOnMethods = "updateDelivery", enabled = false)
    public void deleteDelivery(){
        teacherRepository = ctx.getBean(TeacherRepository.class);
        Teacher students = teacherRepository.findOne(id);
        
        teacherRepository.delete(students);
        Teacher deletedTeacher = teacherRepository.findOne(id);

        Assert.assertNull(deletedTeacher);
        System.out.println("Deleted Teacher: " + deletedTeacher);
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
