package com.luismir.kafka.service;

import com.luismir.kafka.model.DriverDistance;
import com.luismir.kafka.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    void saveStore(Store store);

    Store getStoreById(String id);

    List<Store> getAllStore();

    List<DriverDistance> getDriversAroundStore(String id, int n);
}
