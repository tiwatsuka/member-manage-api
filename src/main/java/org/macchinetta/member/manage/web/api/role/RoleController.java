package org.macchinetta.member.manage.web.api.role;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Role;
import org.macchinetta.member.manage.domain.service.role.RoleService;
import org.macchinetta.member.manage.web.common.error.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Role> getAllRoles(){
		return roleService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Role getRole(@PathVariable long id){
		return roleService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Role create(@RequestBody Role role){
		return roleService.create(role);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable long id, @RequestBody Role role){
		if(id != role.getId()) throw new BadRequestException("The ID of requested subject was invalid.");
		roleService.update(role);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id){
		roleService.delete(id);
	}
}
