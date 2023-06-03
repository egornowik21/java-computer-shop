package com.github.egornowik21.javacomputershop.item.service;

import com.github.egornowik21.javacomputershop.item.model.LaptopItem;

import java.util.List;

public interface LaptopService {
    List<LaptopItem> findAll();

    LaptopItem findById(Long laptopId);

    LaptopItem createLaptop(LaptopItem laptopItem, Long vendor_id);

    void deleteLaptop(Long laptopId);

    LaptopItem updateLaptop(LaptopItem laptopItem, Long vendor_id);
}
