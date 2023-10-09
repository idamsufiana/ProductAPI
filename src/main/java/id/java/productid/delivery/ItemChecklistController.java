package id.java.productid.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //update status
    @PutMapping(value = "/checklist/{Checklistid}/Item/{Itemid}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateStatus(@PathVariable int Checklistid, @PathVariable int Itemid) {
        checklistService.updateStatus(Checklistid, Itemid); 
    } 

    //delete
    @GetMapping(value = "/checklist/{Checklistid}/Item/{Itemid}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByID(@PathVariable int Checklistid, @PathVariable int Itemid) {
        checklistService.deleteItem(Checklistid, Itemid); 
    }
    //rename

    @PutMapping(value = "/checklist/{Checklistid}/Item/{Itemid}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateName(@PathVariable int Checklistid, @PathVariable int Itemid, @RequestBody Itemdata data) {
        checklistService.updateName(Checklistid, Itemid, data); 
    }
    
}
