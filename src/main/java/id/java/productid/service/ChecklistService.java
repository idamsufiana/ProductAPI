package id.java.productid.service;

import java.util.List;

import id.java.productid.model.Checklist;
import id.java.productid.model.ChecklistData;
import id.java.productid.model.ItemName;
import id.java.productid.model.Itemdata;

public interface ChecklistService {
    
    List<Checklist> findAll(int page, int size);
    void create(ChecklistData dataSatu);
    void delete(int id);
    void createItem(int id, Itemdata dataSatu);
    List<ItemName> findAllItem(int page, int size);
}
