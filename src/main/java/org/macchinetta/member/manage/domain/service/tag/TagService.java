package org.macchinetta.member.manage.domain.service.tag;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Tag;

public interface TagService {

	Set<Tag> findAll();

	Tag findOne(long id);

	Tag create(Tag tag);

	boolean delete(long id);

	boolean update(Tag tag);

}
