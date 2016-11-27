package org.macchinetta.member.manage.domain.service.role;

import java.util.Set;

import org.macchinetta.member.manage.domain.mapper.RoleMapper;
import org.macchinetta.member.manage.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleMapper roleMapper;

	@Override
	public Set<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public Role findOne(long id) {
		return roleMapper.findOne(id);
	}

	@Override
	public Role create(Role role) {
		return roleMapper.create(role);
	}

	@Override
	public boolean delete(long id) {
		roleMapper.removRoleFromAllSubjects(id);
		return roleMapper.delete(id);
	}

	@Override
	public boolean update(Role role) {
		return roleMapper.update(role);
	}

}
