package com.joseph.myfinalproject.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries(@NamedQuery(name="Teacher.getAll", query="SELECT e FROM Teacher e"))
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String teacher_id;
    
 //   @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
   // @JoinColumn(name = "teacher_id")
   // private List<Inventory> inventories;
    
    @Embedded
    private Details details;
    
    @Embedded
    private Address address;

    public Teacher() {
    }
    
    private Teacher(Builder builder) {
        id = builder.id;
       teacher_id = builder.teacher_id;
 //       inventories = builder.inventories;
        details = builder.details;
        address = builder.address;
    }

    public static class Builder {
        private Long id;
       private String teacher_id;
     //   private List<Inventory> inventories;
        private Details details;
        private Address address;
    
       public Builder id(Long value) {
           this.id = value;
           return this;
       }

      
       public Builder Teacher_id(String value) {
           this.teacher_id = value;
          return this;
       }
       
  //      public Builder inventories(List<Inventory> value) {
   //        this.inventories = value;
    //       return this;
    //    }
        
        public Builder details(Details value) {
           this.details = value;
           return this;
        }
        
        public Builder address(Address value) {
           this.address = value;
           return this;
        }

       public Builder Teacher(Teacher teacher){
           id = teacher.getId();
           teacher_id = teacher.getTeacher_id();
  //         inventories = students.getInventories();
           details = teacher.getDetails();
           address = teacher.getAddress();
           
           return this;   
       }
        
        public Teacher build(){
            return new Teacher(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

 //   public List<Inventory> getInventories() {
 //       return inventories;
 //   }

    public Details getDetails() {
        return details;
    }

    public Address getAddress() {
        return address;
    }



    @Override
    public String toString() {
        return "com.gift.registry.domain.Teacher[ id=" + id + " ]";
    }
    
}
