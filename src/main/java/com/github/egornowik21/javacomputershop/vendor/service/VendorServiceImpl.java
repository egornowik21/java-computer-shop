package com.github.egornowik21.javacomputershop.vendor.service;

import com.github.egornowik21.javacomputershop.exception.NotFoundException;
import com.github.egornowik21.javacomputershop.vendor.dao.VendorRepository;
import com.github.egornowik21.javacomputershop.vendor.dto.VendorDto;
import com.github.egornowik21.javacomputershop.vendor.mapper.VendorMapper;
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
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    @Override
    public List<VendorDto> findAll() {
        Collection<Vendor> userDtoList = repository.findAll();
        return userDtoList
                .stream()
                .map(VendorMapper::toVendorDto)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDto getVendorById(Long userId) {
        Vendor vendor = repository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        if (repository.findById(userId).isEmpty()) {
            log.error("Пользователь с id - {} не существует", userId);
        }
        return VendorMapper.toVendorDto(vendor);
    }


    @Override
    public VendorDto create(VendorDto vendorDto) {
        Vendor newVendor = repository.save(VendorMapper.inVendorDto(vendorDto));
        return VendorMapper.toVendorDto(newVendor);
    }

    @Override
    public VendorDto patch(Long id, VendorDto vendorDto) {
        Vendor vendor = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        if (vendorDto.getName().isBlank()) {
            vendor.setName(vendor.getName());
        }
        else {
            vendor.setName(vendorDto.getName());
        }
        repository.save(vendor);
        return VendorMapper.toVendorDto(vendor);
    }

    @Override
    public void deleteUserById(Long userId) {
        if (repository.findById(userId).isEmpty()) {
            log.error("Пользователь с id - {} не существует", userId);
            throw new NotFoundException("Пользователь не найден");
        }
        repository.deleteById(userId);
    }
}
