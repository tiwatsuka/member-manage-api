package org.macchinetta.member.manage.domain.repository;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Group;

public interface GroupRepository {

	Set<Group> findAll();

	Group findOne(long id);

	Group create(Group group);

	boolean delete(long id);

	boolean update(Group group);

	boolean removeGroupFromAllSubjects(long id);
	
	boolean removeAllMembersInGroupFromAllSubjects(long id);
	
}
