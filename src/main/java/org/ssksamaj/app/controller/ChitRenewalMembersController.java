package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.ChitRenewalMembersBean;
import org.ssksamaj.app.manager.ChitRenewalMembersManager;

import java.util.List;

@RestController
@RequestMapping("/api/chitRenewalMembers")
@RequiredArgsConstructor
public class ChitRenewalMembersController {

    private final ChitRenewalMembersManager chitRenewalMembersManager;

    @PostMapping
    public ResponseEntity<ChitRenewalMembersBean> create(@RequestBody ChitRenewalMembersBean bean) {
        return ResponseEntity.ok(chitRenewalMembersManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChitRenewalMembersBean> getById(@PathVariable Long id) {
        return chitRenewalMembersManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChitRenewalMembersBean>> getAll() {
        return ResponseEntity.ok(chitRenewalMembersManager.findAll());
    }

    @GetMapping("/byRenewal/{chitRenewalId}")
    public ResponseEntity<List<ChitRenewalMembersBean>> getByChitRenewalId(@PathVariable Long chitRenewalId) {
        return ResponseEntity.ok(chitRenewalMembersManager.findByChitRenewalId(chitRenewalId));
    }

    @GetMapping("/byMember/{memberId}")
    public ResponseEntity<List<ChitRenewalMembersBean>> getByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(chitRenewalMembersManager.findByMemberId(memberId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chitRenewalMembersManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
