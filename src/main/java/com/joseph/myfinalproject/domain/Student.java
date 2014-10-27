/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseph.myfinalproject.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author theresa
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name="Student.getAll", query="SELECT e FROM Student e"))
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private int students_Id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int yearLevel;
      

    public int getStudentId() {
        return students_Id;
    }

    public Student(int studentId, String firstName, String lastName, int yearLevel) {
        this.students_Id = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearLevel = yearLevel;
    }
    
    public Student() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public void setId(int id) {
        this.students_Id = id;
    }

    @Override
    public String toString() {
        return "com.joseph.myfinalproject.Student[ id=" + students_Id + " ]";
    }
    
}
