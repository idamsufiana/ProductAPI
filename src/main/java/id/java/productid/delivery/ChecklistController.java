package id.java.productid.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.java.productid.model.Checklist;
import id.java.productid.model.ChecklistData;
import id.java.productid.service.ChecklistService;


@RequestMapping("checklist")
@RestController
public class ChecklistController {

    @Autowired
    ChecklistService checklistService;

    @GetMapping(value = "/checklist")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Checklist> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return checklistService.findAll(page, size); 
    }


    @PostMapping(value = "/checklist")
    @PreAuthorize("hasRole('ADMIN')")
    public void create(@RequestBody ChecklistData dataSatu) {
        checklistService.create(dataSatu);
         
    }
    

    @DeleteMapping(value = "/checklist/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void create(@PathVariable int id) {
        
        checklistService.delete(id);
         
    }
    
}
