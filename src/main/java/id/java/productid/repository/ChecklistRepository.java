package id.java.productid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.java.productid.model.Checklist;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer>{
    
}
