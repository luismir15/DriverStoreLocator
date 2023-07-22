package com.luismir.kafka.controller;

import com.luismir.kafka.model.DriverDistance;
import com.luismir.kafka.model.Store;
import com.luismir.kafka.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/stores")
    public void saveStore(@RequestBody Store store) {
        storeService.saveStore(store);
    }

    @GetMapping("/stores/{id}")
    public Store getStoreById(@PathVariable String id) {
        return storeService.getStoreById(id);
    }

    @GetMapping("/stores")
    public List<Store> getAllStores() {
        return storeService.getAllStore();
    }

    @GetMapping("/stores/{id}/drivers")
    public List<DriverDistance> getDriversAroundStore(@PathVariable String id, @RequestParam int n) {
        return storeService.getDriversAroundStore(id, n);
    }
}
