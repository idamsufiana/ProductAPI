package id.java.productid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import id.java.productid.model.Checklist;
import id.java.productid.model.DataSatu;
import id.java.productid.repository.ChecklistRepository;
import id.java.productid.service.ChecklistService;

@Service
public class ChecklistServiceImpl implements ChecklistService{

    @Autowired
    ChecklistRepository checklistRepository;

    @Override
    public List<Checklist> findAll(int page, int size) {
        // page -> 0, can't minus
        // size -> 0, can't minus
        PageRequest pageRequest = PageRequest.of(page, size);
        return checklistRepository.findAll(pageRequest)
                .getContent();
    }

    @Override
    public void create(DataSatu dataSatu){
        Checklist caseSatu = new Checklist();
        caseSatu.setName(dataSatu.getName());
        checklistRepository.save(caseSatu);
    }


    @Override
    public void delete(int id){
        checklistRepository.findById(id);
        checklistRepository.deleteById(id);
    }
    
}
