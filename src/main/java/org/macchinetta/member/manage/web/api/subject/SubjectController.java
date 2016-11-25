package org.macchinetta.member.manage.web.api.subject;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

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
}
