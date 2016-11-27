package org.macchinetta.member.manage.web.api.subject;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Group;
import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.model.SubjectDetails;
import org.macchinetta.member.manage.domain.service.member.MemberService;
import org.macchinetta.member.manage.domain.service.subject.SubjectService;
import org.macchinetta.member.manage.web.common.error.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@Autowired
	MemberService memberService;

	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Subject> getAllSubject(){
		return subjectService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Subject getSubject(@PathVariable long id){
		return subjectService.findOne(id);
	}

	@GetMapping("/{id}/detail")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SubjectDetails getDetail(@PathVariable long id){
		return subjectService.findDetails(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Subject create(@RequestBody Subject subject){
		return subjectService.create(subject);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Subject subject, @PathVariable long id){
		if(id == subject.getId()){
			subjectService.update(subject);
		}else{
			throw new BadRequestException("The ID of requested subject was invalid.");
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id){
		subjectService.delete(id);
	}

	@GetMapping("/{id}/groups")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Group> getGroups(@PathVariable long id){
		return subjectService.findGroups(id);
	}

	@DeleteMapping("/{id}/groups/{groupId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAllMembersInGroup(@PathVariable("id") long id, @PathVariable("groupId") long groupId){
		subjectService.removeAllMembersInGroup(id, groupId);
	}

	@PostMapping("/{id}/groups/{groupId}/members/{memberId}/roles/{roleId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addMemberAndRole(@PathVariable("id") long id,
			@PathVariable("groupId") long groupId,
			@PathVariable("memberId") long memberId,
			@PathVariable("roleId") long roleId){
		memberService.addRole(id, groupId, memberId, roleId);
	}

	@DeleteMapping("/{id}/groups/{groupId}/members/{memberId}/roles/{roleId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeMemberAndRole(@PathVariable("id") long id,
			@PathVariable("groupId") long groupId,
			@PathVariable("memberId") long memberId,
			@PathVariable("roleId") long roleId){
		memberService.removeRole(id, groupId, memberId, roleId);
	}
	
	@DeleteMapping("/{id}/members")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAllMembers(@PathVariable long id){
		subjectService.removeAllMembers(id);
	}

}
