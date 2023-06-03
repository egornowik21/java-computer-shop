package com.github.egornowik21.javacomputershop.item.service.impl;

import com.github.egornowik21.javacomputershop.exception.NotFoundException;
import com.github.egornowik21.javacomputershop.item.dao.MonitorItemRepository;
import com.github.egornowik21.javacomputershop.item.model.ItemType;
import com.github.egornowik21.javacomputershop.item.model.MonitorItem;
import com.github.egornowik21.javacomputershop.item.service.MonitorService;
import com.github.egornowik21.javacomputershop.vendor.dao.VendorRepository;
import com.github.egornowik21.javacomputershop.vendor.model.Vendor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {
    private final MonitorItemRepository monitorItemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public List<MonitorItem> findAll() {
        Collection<MonitorItem> monitorList = monitorItemRepository.findAll();
        return monitorList.stream().collect(Collectors.toList());
    }

    @Override
    public MonitorItem findById(Long monitorId) {
        return monitorItemRepository.findById(monitorId)
                .orElseThrow(() -> new NotFoundException("Монитор не найден"));
    }

    @Override
    public MonitorItem createMonitor(MonitorItem monitorItem, Long vendor_id) {
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Монитор не найден"));
        monitorItem.setVendor(vendor);
        monitorItem.setItemType(ItemType.MONITOR);
        return monitorItemRepository.save(monitorItem);
    }

    @Override
    public MonitorItem updateMonitor(MonitorItem monitorItem, Long vendor_id) {
        MonitorItem monitorItemToUpdate = monitorItemRepository.findById(monitorItem.getId())
                .orElseThrow(() -> new NotFoundException("Монитор не найден"));
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Производитель не найден"));
        if (monitorItem.getVendor() != null) {
            monitorItemToUpdate.setVendor(monitorItem.getVendor());
        }
        if (monitorItem.getSize() != null) {
            monitorItemToUpdate.setSize(monitorItem.getSize());
        }
        if (monitorItem.getCount() != null) {
            monitorItemToUpdate.setCount(monitorItem.getCount());
        }
        if (monitorItem.getPrice() != null) {
            monitorItemToUpdate.setPrice(monitorItem.getPrice());
        }
        if (monitorItem.getNumber() != null) {
            monitorItemToUpdate.setNumber(monitorItem.getNumber());
        }
        monitorItemToUpdate.setVendor(vendor);
        monitorItemRepository.save(monitorItemToUpdate);
        return monitorItemToUpdate;
    }

    @Override
    public void deleteMonitor(Long monitorId) {
        monitorItemRepository.deleteById(monitorId);
    }
}
