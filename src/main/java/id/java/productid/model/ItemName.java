package id.java.productid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class ItemName {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String Name;

    
}
