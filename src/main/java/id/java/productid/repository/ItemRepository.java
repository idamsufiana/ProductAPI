package id.java.productid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.java.productid.model.ItemName;

public interface ItemRepository extends JpaRepository<ItemName, Integer>{
    
}
