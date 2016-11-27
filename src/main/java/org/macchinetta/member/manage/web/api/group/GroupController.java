package org.macchinetta.member.manage.web.api.group;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Group;
import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.service.group.GroupService;
import org.macchinetta.member.manage.domain.service.subject.SubjectService;
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
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	SubjectService subjectService;

	@Autowired
	GroupService groupService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Group getGroup(@PathVariable long id){
		return groupService.findOne(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Group> getAllGroups(){
		return groupService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Group create(@RequestBody Group group){
		return groupService.create(group);
		
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable long id, @RequestBody Group group){
		if(id != group.getId()) throw new BadRequestException("The ID of requested subject was invalid.");
		groupService.update(group);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id){
		groupService.delete(id);
	}

	@GetMapping("/{id}/subjects")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Subject> getSubjects(@PathVariable long id){
		return subjectService.findByGroupId(id);
	}

}
