package com.github.egornowik21.javacomputershop.item.service;

import com.github.egornowik21.javacomputershop.item.model.MonitorItem;

import java.util.List;

public interface MonitorService {
    List<MonitorItem> findAll();

    MonitorItem findById(Long monitorId);

    MonitorItem createMonitor(MonitorItem monitorItem, Long vendor_id);

    MonitorItem updateMonitor(MonitorItem monitorItem, Long vendor_id);

    void deleteMonitor(Long monitorId);
}
