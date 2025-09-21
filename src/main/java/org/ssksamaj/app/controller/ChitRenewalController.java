package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.ChitRenewalBean;
import org.ssksamaj.app.manager.ChitRenewalManager;

import java.util.List;

@RestController
@RequestMapping("/api/chitRenewal")
@RequiredArgsConstructor
public class ChitRenewalController {

    private final ChitRenewalManager chitRenewalManager;

    @PostMapping
    public ResponseEntity<ChitRenewalBean> create(@RequestBody ChitRenewalBean bean) {
        return ResponseEntity.ok(chitRenewalManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChitRenewalBean> getById(@PathVariable Long id) {
        return chitRenewalManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChitRenewalBean>> getAll() {
        return ResponseEntity.ok(chitRenewalManager.findAll());
    }

    @GetMapping("/byChit/{chitId}")
    public ResponseEntity<List<ChitRenewalBean>> getByChitId(@PathVariable Long chitId) {
        return ResponseEntity.ok(chitRenewalManager.findByChitId(chitId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chitRenewalManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
