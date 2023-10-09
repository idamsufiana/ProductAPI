package id.java.productid.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.java.productid.model.ItemName;
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

    @GetMapping(value = "/checklist")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ItemName> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return checklistService.findAllItem(page, size); 
    }


    @GetMapping(value = "/checklist/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ItemName findItembyID(@PathVariable int id) {
        return checklistService.findItembyId(id); 
    }
    
}
