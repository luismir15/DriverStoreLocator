package com.luismir.kafka.service;

import com.luismir.kafka.model.DriverDistance;
import com.luismir.kafka.model.Store;
import com.luismir.kafka.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StoreServiceImpl implements StoreService {

    private final StoreRepo storeRepo;

    @Autowired
    public StoreServiceImpl(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    @Override
    public void saveStore(Store store) {
        storeRepo.save(store);
    }

    @Override
    public Store getStoreById(String id) {
        return storeRepo.findStoreByStoreId(id);
    }


    @Override
    public List<Store> getAllStore() {
        return storeRepo.findAll();
    }

    @Override
    public List<DriverDistance> getDriversAroundStore(String id, int n) {
        return null;
    }
}
