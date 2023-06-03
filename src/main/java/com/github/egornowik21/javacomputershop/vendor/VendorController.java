package com.github.egornowik21.javacomputershop.vendor;

import com.github.egornowik21.javacomputershop.vendor.dto.VendorDto;
import com.github.egornowik21.javacomputershop.vendor.service.VendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/vendors")
@RequiredArgsConstructor
@Slf4j
public class VendorController {
    private final VendorService vendorService;

    @GetMapping
    public List<VendorDto> getAllVendors() {
        log.info("GET/vendors- получен список всех производителей.");
        return vendorService.findAll();
    }

    @GetMapping("/{vendorId}")
    public VendorDto getVendorById(@PathVariable long userId) {
        log.info("GET/vendors - получен текущий производитель.");
        return vendorService.getVendorById(userId);
    }

    @PostMapping
    public VendorDto saveNewVendor(@Valid @RequestBody VendorDto vendorDto) {
        log.info("POST/vendors - добавлен текущий производитель.");
        return vendorService.create(vendorDto);
    }

    @DeleteMapping("/{vendorId}")
    public void deleteVendor(@PathVariable long userId) {
        log.info("DELETE/vendors - удален текущий производитель.");
        vendorService.deleteUserById(userId);
    }

    @PatchMapping("/{vendorId}")
    public VendorDto updteVendor(@RequestBody VendorDto vendorDto, @PathVariable("userId") Long userId) {
        log.info("PATCH/vendors - обновлен текущий производитель.");
        return vendorService.patch(userId, vendorDto);
    }

}
