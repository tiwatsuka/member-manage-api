package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.macchinetta.member.manage.domain.model.Group;

@Mapper
public interface GroupMapper {

	Set<Group> findAll();

	Group findOne(long id);

	boolean create(Group group);

	boolean delete(long id);

	boolean update(Group group);

	boolean removeGroupFromAllSubjects(long id);
	
}
