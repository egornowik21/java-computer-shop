package com.github.egornowik21.javacomputershop.item.controllers;

import com.github.egornowik21.javacomputershop.item.model.LaptopItem;
import com.github.egornowik21.javacomputershop.item.service.LaptopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/computers/laptop")
@RequiredArgsConstructor
@Slf4j
public class LaptopController {
    private final LaptopService laptopService;

    public List<LaptopItem> findAll() {
        log.info("GET/laptops - получен список всех ноутбуков.");
        return laptopService.findAll();
    }

    @GetMapping("/{laptopId}")
    public LaptopItem getLaptopById(@RequestHeader("X-Sharer-User-Id") Long userId,@PathVariable long laptopId) {
        log.info("GET/laptops - получен ноутбук по Id - {}.", laptopId);
        return laptopService.findById(laptopId);
    }

    @PostMapping
    public LaptopItem saveNewLaptop(@RequestHeader("X-Sharer-User-Id") Long userId,@RequestBody LaptopItem laptopItem) {
        log.info("POST/laptops - добавлен текущий ноутбук.");
        return laptopService.createLaptop(laptopItem,userId);
    }

    @DeleteMapping("/{laptopId}")
    public void deleteLaptop(@RequestHeader("X-Sharer-User-Id") Long userId,@PathVariable long laptopId) {
        log.info("DELETE/laptops - удален текущий ноутбук.");
        laptopService.deleteLaptop(laptopId);
    }

    @PatchMapping
    public void patchLaptop(@RequestHeader("X-Sharer-User-Id") Long userId,@RequestBody LaptopItem laptopItem) {
        log.info("PATCH/laptops - обновлен текущий ноутбук.");
        laptopService.updateLaptop(laptopItem,userId);
    }

}
