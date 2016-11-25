package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.macchinetta.member.manage.domain.model.Tag;

@Mapper
public interface TagMapper {

	Set<Tag> findAll();

	@Select("SELECT tag_id, tag_name FROM t_tag WHERE tag_id = #{id}")
	Tag findOne(long id);

	Tag create(Tag tag);

	boolean delete(long id);

	boolean update(Tag tag);

	boolean removeTagFromAllSubject(long id);

}
