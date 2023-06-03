package com.github.egornowik21.javacomputershop.item.controllers;

import com.github.egornowik21.javacomputershop.item.model.MonitorItem;
import com.github.egornowik21.javacomputershop.item.service.MonitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/computers/monitor")
@RequiredArgsConstructor
@Slf4j
public class MonitorController {

    private final MonitorService monitorService;

    public List<MonitorItem> findAll() {
        log.info("GET/monitors - получен список всех мониторов.");
        return monitorService.findAll();
    }

    @GetMapping("/{monitorId}")
    public MonitorItem getMonitorById(@RequestHeader("X-Sharer-User-Id") Long userId, @PathVariable long monitorId) {
        log.info("GET/monitors - получен монитор по Id - {}.", monitorId);
        return monitorService.findById(monitorId);
    }

    @PostMapping
    public MonitorItem saveNewMonitor(@RequestHeader("X-Sharer-User-Id") Long userId, @RequestBody MonitorItem monitorItem) {
        log.info("POST/monitors - добавлен текущий монитор.");
        return monitorService.createMonitor(monitorItem, userId);
    }

    @DeleteMapping("/{monitorId}")
    public void deleteMonitor(@RequestHeader("X-Sharer-User-Id") Long userId, @PathVariable long monitorId) {
        log.info("DELETE/monitors - удален текущий монитор.");
        monitorService.deleteMonitor(monitorId);
    }

    @PatchMapping
    public void patchMonitor(@RequestHeader("X-Sharer-User-Id") Long userId, @RequestBody MonitorItem monitorItem) {
        log.info("PATCH/monitors - обновлен текущий мониторв.");
        monitorService.updateMonitor(monitorItem, userId);
    }

}
