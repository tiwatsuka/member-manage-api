package org.macchinetta.member.manage.web.api.tag;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Tag;
import org.macchinetta.member.manage.domain.service.tag.TagService;
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
@RequestMapping("/tags")
public class TagController {

	@Autowired
	TagService tagService;

	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Tag> getAllTags(){
		return tagService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Tag getTag(@PathVariable long id){
		return tagService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tag create(@RequestBody Tag tag){
		return tagService.create(tag);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable long id, @RequestBody Tag tag){
		if(id != tag.getId()) throw new BadRequestException("The ID of requested subject was invalid.");
		tagService.update(tag);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id){
		tagService.delete(id);
	}
}
