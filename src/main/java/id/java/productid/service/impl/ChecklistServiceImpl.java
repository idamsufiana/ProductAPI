package id.java.productid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import id.java.productid.model.Checklist;
import id.java.productid.model.ChecklistData;
import id.java.productid.model.ItemName;
import id.java.productid.model.Itemdata;
import id.java.productid.repository.ChecklistRepository;
import id.java.productid.repository.ItemRepository;
import id.java.productid.service.ChecklistService;

@Service
public class ChecklistServiceImpl implements ChecklistService{

    @Autowired
    ChecklistRepository checklistRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Checklist> findAll(int page, int size) {
        // page -> 0, can't minus
        // size -> 0, can't minus
        PageRequest pageRequest = PageRequest.of(page, size);
        return checklistRepository.findAll(pageRequest)
                .getContent();
    }

    @Override
    public void create(ChecklistData dataSatu){
        Checklist caseSatu = new Checklist();
        caseSatu.setName(dataSatu.getName());
        checklistRepository.save(caseSatu);
    }

    @Override
    public void createItem(int id, Itemdata dataSatu){
        Checklist caseSatu = checklistRepository.findById(id).get();
        ItemName item = new ItemName();
        item.setName(dataSatu.getName());
        itemRepository.save(item);
        caseSatu.setItemName(item);
        checklistRepository.save(caseSatu);
    }

    @Override
    public void delete(int id){
        checklistRepository.findById(id);
        checklistRepository.deleteById(id);
    }

    @Override
    public List<ItemName> findAllItem(int page, int size) {
        // page -> 0, can't minus
        // size -> 0, can't minus
        PageRequest pageRequest = PageRequest.of(page, size);
        return itemRepository.findAll(pageRequest)
                .getContent();
    }
    
}
