package com.github.egornowik21.javacomputershop.vendor.mapper;

import com.github.egornowik21.javacomputershop.vendor.dto.VendorDto;
import com.github.egornowik21.javacomputershop.vendor.model.Vendor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VendorMapper {

    public static VendorDto toVendorDto(Vendor vendor) {
        return VendorDto.builder()
                .id(vendor.getId())
                .name(vendor.getName())
                .build();
    }

    public static Vendor inVendorDto(VendorDto vendorDto) {
        return Vendor.builder()
                .id(vendorDto.getId())
                .name(vendorDto.getName())
                .build();
    }
}
