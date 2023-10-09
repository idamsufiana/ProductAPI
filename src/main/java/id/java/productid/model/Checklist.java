package id.java.productid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class Checklist {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String Name;

    @ManyToOne
    @JoinColumn
    private ItemName itemName;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public ItemName getItemName() {
        return itemName;
    }
    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }
    

    
}
