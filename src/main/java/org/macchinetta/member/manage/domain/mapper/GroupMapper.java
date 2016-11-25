package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.macchinetta.member.manage.domain.model.Group;

@Mapper
public interface GroupMapper {

	Set<Group> findAll();

	@Select("SELECT group_id, group_name FROM t_group WHERE group_id = #{id}")
	Group findOne(long id);

	Group create(Group group);

	boolean delete(long id);

	boolean update(Group group);

	boolean removeGroupFromAllSubjects(long id);
	
	boolean removeAllMembersInGroupFromAllSubjects(long id);
	
}
