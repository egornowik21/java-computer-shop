package com.github.egornowik21.javacomputershop.item.service.impl;

import com.github.egornowik21.javacomputershop.exception.NotFoundException;
import com.github.egornowik21.javacomputershop.item.dao.PcItemRepository;
import com.github.egornowik21.javacomputershop.item.model.ItemType;
import com.github.egornowik21.javacomputershop.item.model.PcItem;
import com.github.egornowik21.javacomputershop.item.service.PcService;
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
public class PcServiceImpl implements PcService {
    private final PcItemRepository pcItemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public List<PcItem> findAll() {
        Collection<PcItem> pcList = pcItemRepository.findAll();
        return pcList.stream().collect(Collectors.toList());
    }

    @Override
    public PcItem findById(Long pcId) {
        return pcItemRepository.findById(pcId)
                .orElseThrow(() -> new NotFoundException("ПК не найден"));
    }

    @Override
    public PcItem createPc(PcItem pcItem, Long vendor_id) {
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("ПК не найден"));
        pcItem.setVendor(vendor);
        pcItem.setItemType(ItemType.MONITOR);
        return pcItemRepository.save(pcItem);
    }

    @Override
    public PcItem updatePc(PcItem pcItem, Long vendor_id) {
        PcItem pcItemToUpdate = pcItemRepository.findById(pcItem.getId())
                .orElseThrow(() -> new NotFoundException("ПК не найден"));
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Производитель не найден"));
        if (pcItem.getVendor() != null) {
            pcItemToUpdate.setVendor(pcItem.getVendor());
        }
        if (pcItem.getPcForms() != null) {
            pcItemToUpdate.setPcForms(pcItem.getPcForms());
        }
        if (pcItem.getCount() != null) {
            pcItemToUpdate.setCount(pcItem.getCount());
        }
        if (pcItem.getPrice() != null) {
            pcItemToUpdate.setPrice(pcItem.getPrice());
        }
        if (pcItem.getNumber() != null) {
            pcItemToUpdate.setNumber(pcItem.getNumber());
        }
        pcItemToUpdate.setVendor(vendor);
        pcItemRepository.save(pcItemToUpdate);
        return pcItemToUpdate;
    }

    @Override
    public void deletePc(Long pcId) {
        pcItemRepository.deleteById(pcId);
    }

}
