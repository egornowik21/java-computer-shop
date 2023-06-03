package com.github.egornowik21.javacomputershop.item.service;

import com.github.egornowik21.javacomputershop.item.model.PcItem;

import java.util.List;

public interface PcService {
    List<PcItem> findAll();

    PcItem findById(Long pcId);

    PcItem createPc(PcItem pcItem, Long vendor_id);

    PcItem updatePc(PcItem pcItem, Long vendor_id);

    void deletePc(Long pcId);
}
