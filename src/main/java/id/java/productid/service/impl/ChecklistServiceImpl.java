package id.java.productid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import id.java.productid.config.AppProperties;
import id.java.productid.model.Checklist;
import id.java.productid.model.ChecklistData;
import id.java.productid.model.ItemName;
import id.java.productid.model.Itemdata;
import id.java.productid.repository.ChecklistRepository;
import id.java.productid.repository.ItemRepository;
import id.java.productid.service.ChecklistService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChecklistServiceImpl implements ChecklistService{

    @Autowired
    ChecklistRepository checklistRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AppProperties appProperties;
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
        try {
            Checklist caseSatu = checklistRepository.findById(id).get();
            ItemName item = new ItemName();
            item.setName(dataSatu.getName());
            itemRepository.save(item);
            caseSatu.setItemName(item);
            checklistRepository.save(caseSatu);    
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        
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

    @Override
    public ItemName findItembyId(int id) {
        return checklistRepository.findById(id).get().getItemName();
    }

    @Override
    public void deleteItem(int CHeckListid, int ItemId){
        Checklist check = checklistRepository.findById(CHeckListid).get();
        ItemName item = itemRepository.findById(check.getId()).get();
        itemRepository.deleteById(item.getId());
    }

    @Override
    public void updateStatus(int CHeckListid, int ItemId){
        try {
            Checklist check = checklistRepository.findById(CHeckListid).get();
            ItemName item = itemRepository.findById(check.getId()).get();
            item.setStatus(appProperties.getSuccess());
            itemRepository.save(item);    
        } catch (Exception e) {
            log.info(e.getMessage());
            
        }
        
    }

    @Override
    public void updateName(int CHeckListid, int ItemId, Itemdata data){
        try {
            Checklist check = checklistRepository.findById(CHeckListid).get();
            ItemName item = itemRepository.findById(check.getId()).get();
            item.setName(data.getName());
            itemRepository.save(item);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
    
}
