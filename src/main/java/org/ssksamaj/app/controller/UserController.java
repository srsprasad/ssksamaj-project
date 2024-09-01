package org.ssksamaj.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssksamaj.app.beans.UserBean;
import org.ssksamaj.app.manager.UserManager;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserManager userManager;
	
	@GetMapping(value = "/all", produces = {"application/json"})
	public ResponseEntity<List<UserBean>> getAll() {
		return ResponseEntity.ok(userManager.fetchAll());
	}
	
	@GetMapping(value = "/find/{id}", produces = {"application/json"})
	public ResponseEntity<UserBean> find(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(userManager.find(id));
	}
	
	@PostMapping(value = "/create", consumes = {"application/json"})
	public ResponseEntity<Integer> create(@RequestBody UserBean userBean) {
		return ResponseEntity.ofNullable(userManager.create(userBean));
	}
}
