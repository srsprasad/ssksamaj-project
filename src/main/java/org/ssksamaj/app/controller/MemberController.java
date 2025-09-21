package org.ssksamaj.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssksamaj.app.beans.MemberBean;
import org.ssksamaj.app.manager.MemberManager;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberManager memberManager;

    @PostMapping
    public ResponseEntity<MemberBean> create(@RequestBody MemberBean bean) {
        return ResponseEntity.ok(memberManager.save(bean));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberBean> getById(@PathVariable Long id) {
        return memberManager.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberBean>> getAll() {
        return ResponseEntity.ok(memberManager.findAll());
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<MemberBean> getByName(@PathVariable String name) {
        return ResponseEntity.ok(memberManager.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
