package com.luismir.kafka.service;

import com.luismir.kafka.consumer.listener.KafkaListeners;
import com.luismir.kafka.consumer.model.Driver;
import com.luismir.kafka.model.DriverDistance;
import com.luismir.kafka.model.Store;
import com.luismir.kafka.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepo storeRepo;
    private final KafkaListeners kafkaListeners;

    @Autowired
    public StoreServiceImpl(StoreRepo storeRepo, KafkaListeners kafkaListeners) {
        this.storeRepo = storeRepo;
        this.kafkaListeners = kafkaListeners;
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
        Store store = getStoreById(id);
        List<Driver> drivers = kafkaListeners.fetchEvents(n);

        List<DriverDistance> driverDistances = new ArrayList<>();
        for (Driver driver: drivers) {
            double a = store.getLatitude() - driver.getLatitude();
            double b = store.getLongitude() - driver.getLongitude();
            double distance = Math.sqrt(a * a + b * b);

            driverDistances.add(new DriverDistance(driver.getDriverID(), distance));
        }

        driverDistances.sort(Comparator.comparingDouble(DriverDistance::getDistance));

        return driverDistances;
    }
}
