package com.github.egornowik21.javacomputershop.item.dao;

import com.github.egornowik21.javacomputershop.item.model.LaptopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopItemRepository extends JpaRepository<LaptopItem, Long> {
}
