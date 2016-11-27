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
	GroupMapper groupMapper;

	@Override
	public Set<Group> findAll() {
		return groupMapper.findAll();
	}

	@Override
	public Group findOne(long id) {
		return groupMapper.findOne(id);
	}

	@Override
	public Group create(Group group) {
		groupMapper.create(group);
		return group;
	}

	@Override
	public boolean delete(long id) {
		groupMapper.removeGroupFromAllSubjects(id);
		return groupMapper.delete(id);
	}

	@Override
	public boolean update(Group group) {
		return groupMapper.update(group);
	}

}
