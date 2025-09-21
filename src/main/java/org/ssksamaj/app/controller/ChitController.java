package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.ChitBean;
import org.ssksamaj.app.manager.ChitManager;

import java.util.List;

@RestController
@RequestMapping("/api/chit")
@RequiredArgsConstructor
public class ChitController {

    private final ChitManager chitManager;

    @PostMapping
    public ResponseEntity<ChitBean> create(@RequestBody ChitBean bean) {
        return ResponseEntity.ok(chitManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChitBean> getById(@PathVariable Long id) {
        return chitManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChitBean>> getAll() {
        return ResponseEntity.ok(chitManager.findAll());
    }

    @GetMapping("/byOrganization/{organizationId}")
    public ResponseEntity<List<ChitBean>> getByOrganizationId(@PathVariable Long organizationId) {
        return ResponseEntity.ok(chitManager.findByOrganizationId(organizationId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chitManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
