package com.github.egornowik21.javacomputershop.vendor.service;


import com.github.egornowik21.javacomputershop.vendor.dto.VendorDto;

import javax.validation.Valid;
import java.util.List;

public interface VendorService {
     List<VendorDto> findAll();

     VendorDto getVendorById(Long userId);

    VendorDto create(@Valid VendorDto vendorDto);

    VendorDto patch(Long id, VendorDto vendorDto);

    void deleteUserById(Long userId);
}
