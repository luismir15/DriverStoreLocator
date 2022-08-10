package com.luismir.kafka.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store")
@Data
public class Store {

    @Id
    @Column(name = "store_id")
    String storeId;

    @Column(name = "store_latitude")
    double latitude;

    @Column(name = "store_longitude")
    double longitude;
}
