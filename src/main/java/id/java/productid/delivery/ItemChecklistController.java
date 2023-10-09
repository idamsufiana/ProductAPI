package id.java.productid.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.java.productid.model.Itemdata;
import id.java.productid.service.ChecklistService;

@RestController
public class ItemChecklistController {

    @Autowired
    ChecklistService checklistService;


    @PostMapping(value = "/checklist/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void create(@RequestBody Itemdata dataSatu, @PathVariable int id) {
        checklistService.createItem(id, dataSatu);
         
    }
    
}
