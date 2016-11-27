package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.macchinetta.member.manage.domain.model.Tag;

@Mapper
public interface TagMapper {

	Set<Tag> findAll();

	Tag findOne(long id);

	Tag create(Tag tag);

	boolean delete(long id);

	boolean update(Tag tag);

	boolean removeTagFromAllSubject(long id);

}
