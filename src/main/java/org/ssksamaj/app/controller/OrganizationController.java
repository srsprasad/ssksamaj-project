package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.manager.OrganizationManager;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationManager organizationManager;

    @PostMapping
    public ResponseEntity<OrganizationBean> create(@RequestBody OrganizationBean bean) {
        return ResponseEntity.ok(organizationManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationBean> getById(@PathVariable Long id) {
        return organizationManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrganizationBean>> getAll() {
        return ResponseEntity.ok(organizationManager.findAll());
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<OrganizationBean> getByName(@PathVariable String name) {
        return ResponseEntity.ok(organizationManager.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
