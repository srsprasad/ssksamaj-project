package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.ChitAuctionBean;
import org.ssksamaj.app.manager.ChitAuctionManager;

import java.util.List;

@RestController
@RequestMapping("/api/chitAuction")
@RequiredArgsConstructor
public class ChitAuctionController {

    private final ChitAuctionManager chitAuctionManager;

    @PostMapping
    public ResponseEntity<ChitAuctionBean> create(@RequestBody ChitAuctionBean bean) {
        return ResponseEntity.ok(chitAuctionManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChitAuctionBean> getById(@PathVariable Long id) {
        return chitAuctionManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChitAuctionBean>> getAll() {
        return ResponseEntity.ok(chitAuctionManager.findAll());
    }

    @GetMapping("/byRenewal/{chitRenewalId}")
    public ResponseEntity<List<ChitAuctionBean>> getByChitRenewalId(@PathVariable Long chitRenewalId) {
        return ResponseEntity.ok(chitAuctionManager.findByChitRenewalId(chitRenewalId));
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chitAuctionManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
