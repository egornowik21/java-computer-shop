package com.github.egornowik21.javacomputershop.item.dao;

import com.github.egornowik21.javacomputershop.item.model.PcItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcItemRepository extends JpaRepository<PcItem,Long> {
}
