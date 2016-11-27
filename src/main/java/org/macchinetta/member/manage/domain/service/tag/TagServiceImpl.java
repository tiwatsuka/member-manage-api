package org.macchinetta.member.manage.domain.service.tag;

import java.util.Set;

import org.macchinetta.member.manage.domain.mapper.TagMapper;
import org.macchinetta.member.manage.domain.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	TagMapper tagMapper;

	@Override
	public Set<Tag> findAll() {
		return tagMapper.findAll();
	}

	@Override
	public Tag findOne(long id) {
		return tagMapper.findOne(id);
	}

	@Override
	public Tag create(Tag tag) {
		return tagMapper.create(tag);
	}

	@Override
	public boolean delete(long id) {
		tagMapper.removeTagFromAllSubject(id);
		return tagMapper.delete(id);
	}

	@Override
	public boolean update(Tag tag) {
		return tagMapper.update(tag);
	}

}
