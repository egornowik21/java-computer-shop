package com.github.egornowik21.javacomputershop.item.service.impl;

import com.github.egornowik21.javacomputershop.exception.NotFoundException;
import com.github.egornowik21.javacomputershop.item.dao.LaptopItemRepository;
import com.github.egornowik21.javacomputershop.item.model.ItemType;
import com.github.egornowik21.javacomputershop.item.model.LaptopItem;
import com.github.egornowik21.javacomputershop.item.service.LaptopService;
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
public class LaptotServiceImpl implements LaptopService {
    private final LaptopItemRepository laptopItemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public List<LaptopItem> findAll() {
        Collection<LaptopItem> laptopList = laptopItemRepository.findAll();
        return laptopList.stream().collect(Collectors.toList());
    }

    @Override
    public LaptopItem findById(Long laptopId) {
        return laptopItemRepository.findById(laptopId)
                .orElseThrow(() -> new NotFoundException("Ноутбук не найден"));
    }

    @Override
    public LaptopItem createLaptop(LaptopItem laptopItem, Long vendor_id) {
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Производитель не найден"));
        laptopItem.setVendor(vendor);
        laptopItem.setItemType(ItemType.LAPTOP);
        return laptopItemRepository.save(laptopItem);
    }

    @Override
    public LaptopItem updateLaptop(LaptopItem laptopItem, Long vendor_id) {
        LaptopItem laptopItemtoUpade = laptopItemRepository.findById(laptopItem.getId())
                .orElseThrow(() -> new NotFoundException("Ноутбук не найден"));
        Vendor vendor = vendorRepository.findById(vendor_id)
                .orElseThrow(() -> new NotFoundException("Производитель не найден"));
        if (laptopItem.getVendor() != null) {
            laptopItemtoUpade.setVendor(laptopItem.getVendor());
        }
        if (laptopItem.getSize() != null) {
            laptopItemtoUpade.setSize(laptopItem.getSize());
        }
        if (laptopItem.getCount() != null) {
            laptopItemtoUpade.setCount(laptopItem.getCount());
        }
        if (laptopItem.getPrice() != null) {
            laptopItemtoUpade.setPrice(laptopItem.getPrice());
        }
        if (laptopItem.getNumber() != null) {
            laptopItemtoUpade.setNumber(laptopItem.getNumber());
        }
        laptopItemtoUpade.setVendor(vendor);
        laptopItemRepository.save(laptopItemtoUpade);
        return laptopItemtoUpade;
    }

    @Override
    public void deleteLaptop(Long laptopId) {
        laptopItemRepository.deleteById(laptopId);
    }

}
