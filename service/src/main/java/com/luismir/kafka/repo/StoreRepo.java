package com.luismir.kafka.repo;

import com.luismir.kafka.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Store, String> {

    Store findStoreByStoreId(String id);
}
