package com.github.egornowik21.javacomputershop.item.service.impl;

import com.github.egornowik21.javacomputershop.exception.NotFoundException;
import com.github.egornowik21.javacomputershop.item.dao.HdItemRepository;
import com.github.egornowik21.javacomputershop.item.model.HdItem;
import com.github.egornowik21.javacomputershop.item.model.ItemType;
import com.github.egornowik21.javacomputershop.item.service.HdService;
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
public class HdServiceImpl implements HdService {
    private final HdItemRepository hdItemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public List<HdItem> findAll() {
        Collection<HdItem> hdList = hdItemRepository.findAll();
        return hdList.stream().collect(Collectors.toList());
    }

    @Override
    public HdItem findById(Long hdId) {
        return hdItemRepository.findById(hdId)
                .orElseThrow(() -> new NotFoundException("Диск не найден"));
    }

    @Override
    public HdItem createHd(HdItem hdItem, Long vendor_id) {
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Производитель не найден"));
        hdItem.setVendor(vendor);
        hdItem.setItemType(ItemType.HD);
        return hdItemRepository.save(hdItem);
    }

    @Override
    public HdItem updateItem(HdItem hdItem, Long vendor_id) {
        HdItem hditemToUpdate = hdItemRepository.findById(hdItem.getId())
                .orElseThrow(() -> new NotFoundException("Диск не найден"));
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Производитель не найден"));
        if (hdItem.getVendor() != null) {
            hditemToUpdate.setVendor(hdItem.getVendor());
        }
        if (hdItem.getSize() != null) {
            hditemToUpdate.setSize(hdItem.getSize());
        }
        if (hdItem.getCount() != null) {
            hditemToUpdate.setCount(hdItem.getCount());
        }
        if (hdItem.getPrice() != null) {
            hditemToUpdate.setPrice(hdItem.getPrice());
        }
        if (hdItem.getNumber() != null) {
            hditemToUpdate.setNumber(hdItem.getNumber());
        }
        hditemToUpdate.setVendor(vendor);
        hdItemRepository.save(hditemToUpdate);
        return hditemToUpdate;
    }

    @Override
    public void deleteHd(Long hdId) {
        hdItemRepository.deleteById(hdId);
    }

}
