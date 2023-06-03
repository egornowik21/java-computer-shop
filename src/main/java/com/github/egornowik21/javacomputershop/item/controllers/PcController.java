package com.github.egornowik21.javacomputershop.item.controllers;

import com.github.egornowik21.javacomputershop.item.model.PcItem;
import com.github.egornowik21.javacomputershop.item.service.PcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/computers/pc")
@RequiredArgsConstructor
@Slf4j
public class PcController {
    private final PcService pcService;
    public List<PcItem> findAll() {
        log.info("GET/pc - получен список всех ПК.");
        return pcService.findAll();
    }

    @GetMapping("/{pcId}")
    public PcItem getPcById(@RequestHeader("X-Sharer-User-Id") Long userId, @PathVariable long pcId) {
        log.info("GET/pc - получен ПК по Id - {}.", pcId);
        return pcService.findById(pcId);
    }

    @PostMapping
    public PcItem saveNewPc(@RequestHeader("X-Sharer-User-Id") Long userId, @RequestBody PcItem pcItem) {
        log.info("POST/pc - добавлен текущий ПК.");
        return pcService.createPc(pcItem, userId);
    }

    @DeleteMapping("/{monitorId}")
    public void deleteMonitor(@RequestHeader("X-Sharer-User-Id") Long userId, @PathVariable long pcId) {
        log.info("DELETE/pc - удален текущий ПК.");
        pcService.deletePc(pcId);
    }

    @PatchMapping
    public void patchMonitor(@RequestHeader("X-Sharer-User-Id") Long userId, @RequestBody PcItem pcItem) {
        log.info("PATCH/pc - обновлен текущий ПК.");
        pcService.updatePc(pcItem, userId);
    }
}
