package org.macchinetta.member.manage.domain.service.tag;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Tag;
import org.macchinetta.member.manage.domain.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	TagRepository tagRepository;

	@Override
	public Set<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findOne(long id) {
		return tagRepository.findOne(id);
	}

	@Override
	public Tag create(Tag tag) {
		return tagRepository.create(tag);
	}

	@Override
	public boolean delete(long id) {
		tagRepository.removeTagFromAllSubject(id);
		return tagRepository.delete(id);
	}

	@Override
	public boolean update(Tag tag) {
		return tagRepository.update(tag);
	}

}
