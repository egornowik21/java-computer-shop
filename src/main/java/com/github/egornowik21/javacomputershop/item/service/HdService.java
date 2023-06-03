package com.github.egornowik21.javacomputershop.item.service;

import com.github.egornowik21.javacomputershop.item.model.HdItem;

import java.util.List;

public interface HdService {
    List<HdItem> findAll();

    HdItem findById(Long hdId);

    HdItem createHd(HdItem hdItem, Long vendor_id);

    HdItem updateItem(HdItem hdItem, Long vendor_id);

    void deleteHd(Long hdId);
}
