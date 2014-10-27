/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joseph.myfinalproject.test.services;

import com.joseph.myfinalproject.app.conf.ConnectionConfig;
import com.joseph.myfinalproject.domain.Address;
import com.joseph.myfinalproject.domain.Details;
import com.joseph.myfinalproject.domain.Students;
import com.joseph.myfinalproject.repository.StudentsRepository;
import com.joseph.myfinalproject.services.StudentsService;
import com.joseph.myfinalproject.services.impl.StudentsServiceImpl;
import static com.joseph.myfinalproject.test.repository.StudentRepositoryTest.ctx;
import java.util.Date;
import java.util.List;
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
 * @author cnyaba
 */

public class FindAllStudentsTest {
    private static ApplicationContext ctx;
    private StudentsService serv;
    private StudentsRepository repo;
    private Long id;
    
    public FindAllStudentsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = false)
    public void FindAllStudents() {
        serv = ctx.getBean(StudentsService.class);
        repo = ctx.getBean(StudentsRepository.class);
        
        StudentsServiceImpl servImp = new StudentsServiceImpl();
   
        servImp = ctx.getBean(StudentsServiceImpl.class);
        Address sAddress = new Address();
        sAddress.setHouse_number(5);
        sAddress.setStreet_address("Main Road");
        sAddress.setSuburb("Cape Town");
        
        Details cDetails = new Details();
        cDetails.setFirstname("Peter");
        cDetails.setLastname("Smith");
        cDetails.setContactnumber("021 568 7325");
        Students updatedStudent = new Students.Builder().Students_id("210016299").address(sAddress).details(cDetails).build();
                    
        repo.save(updatedStudent);
        id = updatedStudent.getId();
        Assert.assertNotNull(updatedStudent);
        
        List<Students> invoices = servImp.findAll();
        Assert.assertTrue(invoices.size()>0);
    }
    @Test(enabled = false)
    public void findStudentsByID(){
        StudentsServiceImpl servImp = new StudentsServiceImpl();
        servImp = (StudentsServiceImpl) ctx.getBean(StudentsService.class);
        repo = ctx.getBean(StudentsRepository.class);
        Students invo  = repo.findOne(id);
        id = invo.getId();
        Students invoice = servImp.find(id);
        
        Assert.assertNotNull(invoice);
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
