package org.macchinetta.member.manage.domain.service.group;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Group;

public interface GroupService {

	Set<Group> findAll();

	Group findOne(long id);

	Group create(Group group);

	boolean delete(long id);

	boolean update(Group group);

}
