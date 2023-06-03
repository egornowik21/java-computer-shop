package com.github.egornowik21.javacomputershop.item.controllers;

import com.github.egornowik21.javacomputershop.item.model.HdItem;
import com.github.egornowik21.javacomputershop.item.service.HdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/computers/hd")
@RequiredArgsConstructor
@Slf4j
public class HdController {
    private final HdService hdService;
    public List<HdItem> findAll() {
        log.info("GET/hd - получен список всех жестких дисков.");
        return hdService.findAll();
    }

    @GetMapping("/{hdId}")
    public HdItem getHdById(@RequestHeader("X-Sharer-User-Id") Long userId, @PathVariable long hdId) {
        log.info("GET/hd - получен жестких диск по Id - {}.", hdId);
        return hdService.findById(hdId);
    }

    @PostMapping
    public HdItem saveNewHd(@RequestHeader("X-Sharer-User-Id") Long userId,@RequestBody HdItem hdItem) {
        log.info("POST/hd - добавлен текущий жесткий диск.");
        return hdService.createHd(hdItem,userId);
    }

    @DeleteMapping("/{hdId}")
    public void deleteLaptop(@RequestHeader("X-Sharer-User-Id") Long userId,@PathVariable long hdId) {
        log.info("DELETE/hd - удален текущий жесткий диск.");
        hdService.deleteHd(hdId);
    }

    @PatchMapping
    public void patchLaptop(@RequestHeader("X-Sharer-User-Id") Long userId,@RequestBody HdItem hdItem) {
        log.info("PATCH/hd - обновлен текущий жесткий диск.");
        hdService.updateItem(hdItem,userId);
    }

}
