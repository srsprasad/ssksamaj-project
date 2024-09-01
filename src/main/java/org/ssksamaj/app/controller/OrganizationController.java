package org.ssksamaj.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.manager.OrganizationManager;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	private static final Logger LOG = LoggerFactory.getLogger(OrganizationController.class);

	@Autowired
	private OrganizationManager organizationManager;
	
	@GetMapping(value = "/all", produces = {"application/json"})
	public ResponseEntity<List<OrganizationBean>> getAll() {
		return ResponseEntity.ok(organizationManager.fetchAll());
	}
	
	@GetMapping(value = "/find/{id}", produces = {"application/json"})
	public ResponseEntity<OrganizationBean> find(@PathVariable Integer id) {
		return ResponseEntity.ok(organizationManager.find(id));
	}
	
	@PostMapping(value = "/create", consumes = {"application/json"}, produces = {"application/json"})
	public String create(@RequestBody OrganizationBean organization) {
		LOG.info("Received Object: " + organization);
		return "Successfully created with ID: " + organizationManager.create(organization);
	}
}
