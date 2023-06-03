package com.github.egornowik21.javacomputershop.item.dao;

import com.github.egornowik21.javacomputershop.item.model.HdItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HdItemRepository extends JpaRepository<HdItem,Long> {
}
