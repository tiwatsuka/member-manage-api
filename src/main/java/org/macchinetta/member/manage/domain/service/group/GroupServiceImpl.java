package org.macchinetta.member.manage.domain.service.group;

import java.util.Set;

import org.macchinetta.member.manage.domain.mapper.GroupMapper;
import org.macchinetta.member.manage.domain.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupMapper groupRepository;

	@Override
	public Set<Group> findAll() {
		return groupRepository.findAll();
	}

	@Override
	public Group findOne(long id) {
		return groupRepository.findOne(id);
	}

	@Override
	public Group create(Group group) {
		return groupRepository.create(group);
	}

	@Override
	public boolean delete(long id) {
		groupRepository.removeAllMembersInGroupFromAllSubjects(id);
		groupRepository.removeGroupFromAllSubjects(id);
		return groupRepository.delete(id);
	}

	@Override
	public boolean update(Group group) {
		return groupRepository.update(group);
	}

}
