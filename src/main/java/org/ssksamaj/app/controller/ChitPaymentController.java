package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.ChitPaymentBean;
import org.ssksamaj.app.manager.ChitPaymentManager;

import java.util.List;

@RestController
@RequestMapping("/api/chitPayment")
@RequiredArgsConstructor
public class ChitPaymentController {

    private final ChitPaymentManager chitPaymentManager;

    @PostMapping
    public ResponseEntity<ChitPaymentBean> create(@RequestBody ChitPaymentBean bean) {
        return ResponseEntity.ok(chitPaymentManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChitPaymentBean> getById(@PathVariable Long id) {
        return chitPaymentManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChitPaymentBean>> getAll() {
        return ResponseEntity.ok(chitPaymentManager.findAll());
    }

    @GetMapping("/byAuction/{chitAuctionId}")
    public ResponseEntity<List<ChitPaymentBean>> getByChitAuctionId(@PathVariable Long chitAuctionId) {
        return ResponseEntity.ok(chitPaymentManager.findByChitAuctionId(chitAuctionId));
    }

    @GetMapping("/byRenewalMember/{chitRenewalMembersId}")
    public ResponseEntity<List<ChitPaymentBean>> getByChitRenewalMembersId(@PathVariable Long chitRenewalMembersId) {
        return ResponseEntity.ok(chitPaymentManager.findByChitRenewalMembersId(chitRenewalMembersId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chitPaymentManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
