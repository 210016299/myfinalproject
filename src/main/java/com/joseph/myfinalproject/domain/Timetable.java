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
@NamedQueries(@NamedQuery(name="Timetable.getAll", query="SELECT e FROM Timetable e"))
public class Timetable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String timetable_id;
    
 //   @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
   // @JoinColumn(name = "timetable_id")
   // private List<Inventory> inventories;
    
    @Embedded
    private Details timetable_details;
    
    @Embedded
    private Address classroom_address;

    public Timetable() {
    }
    
    private Timetable(Builder builder) {
        id = builder.id;
       timetable_id = builder.timetable_id;
 //       inventories = builder.inventories;
        timetable_details = builder.timetable_details;
        classroom_address = builder.classroom_address;
    }

    public static class Builder {
        private Long id;
       private String timetable_id;
     //   private List<Inventory> inventories;
        private Details timetable_details;
        private Address classroom_address;
    
       public Builder id(Long value) {
           this.id = value;
           return this;
       }

      
       public Builder Timetable_id(String value) {
           this.timetable_id = value;
          return this;
       }
       
  //      public Builder inventories(List<Inventory> value) {
   //        this.inventories = value;
    //       return this;
    //    }
        
        public Builder timetable_details(Details value) {
           this.timetable_details = value;
           return this;
        }
        
        public Builder Classroom_address(Address value) {
           this.classroom_address = value;
           return this;
        }

       public Builder Timetable(Timetable timetable){
           id = timetable.getId();
           timetable_id = timetable.getTimetable_id();
  //         inventories = timetable.getInventories();
           timetable_details = timetable.getTimetableDetails();
           classroom_address = timetable.getClassroomAddress();
           
           return this;   
       }
        
        public Timetable build(){
            return new Timetable(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getTimetable_id() {
        return timetable_id;
    }

 //   public List<Inventory> getInventories() {
 //       return inventories;
 //   }

    public Details getTimetableDetails() {
        return timetable_details;
    }

    public Address getClassroomAddress() {
        return classroom_address;
    }



    @Override
    public String toString() {
        return "com.gift.registry.domain.Timetable[ id=" + id + " ]";
    }
    
}
