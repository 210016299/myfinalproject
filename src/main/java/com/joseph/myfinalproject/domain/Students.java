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
@NamedQueries(@NamedQuery(name="Students.getAll", query="SELECT e FROM Students e"))
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String students_id;
    
 //   @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
   // @JoinColumn(name = "students_id")
   // private List<Inventory> inventories;
    
    @Embedded
    private Details details;
    
    @Embedded
    private Address address;

    public Students() {
    }
    
    private Students(Builder builder) {
        id = builder.id;
       students_id = builder.students_id;
 //       inventories = builder.inventories;
        details = builder.details;
        address = builder.address;
    }

    public static class Builder {
        private Long id;
       private String students_id;
     //   private List<Inventory> inventories;
        private Details details;
        private Address address;
    
       public Builder id(Long value) {
           this.id = value;
           return this;
       }

      
       public Builder Students_id(String value) {
           this.students_id = value;
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

       public Builder Students(Students students){
           id = students.getId();
           students_id = students.getStudents_id();
  //         inventories = students.getInventories();
           details = students.getDetails();
           address = students.getAddress();
           
           return this;   
       }
        
        public Students build(){
            return new Students(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getStudents_id() {
        return students_id;
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
        return "com.gift.registry.domain.Students[ id=" + id + " ]";
    }
    
}
