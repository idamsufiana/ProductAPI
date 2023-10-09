package id.java.productid.service;

import java.util.List;

import id.java.productid.model.Checklist;
import id.java.productid.model.DataSatu;

public interface ChecklistService {
    
    List<Checklist> findAll(int page, int size);
    void create(DataSatu dataSatu);
    void delete(int id);
}
