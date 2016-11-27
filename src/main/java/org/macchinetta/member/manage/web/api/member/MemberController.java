package org.macchinetta.member.manage.web.api.member;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Member;
import org.macchinetta.member.manage.domain.service.member.MemberService;
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
@RequestMapping("/members")
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Member> getAllMembers(){
		return memberService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Member getMember(@PathVariable long id){
		return memberService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Member create(@RequestBody Member member){
		return memberService.create(member);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable long id, @RequestBody Member member){
		if(id != member.getId()) throw new BadRequestException("The ID of requested subject was invalid.");
		memberService.update(member);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id){
		memberService.delete(id);
	}
}
