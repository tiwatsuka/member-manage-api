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
	RoleMapper roleRepository;

	@Override
	public Set<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Role create(Role role) {
		return roleRepository.create(role);
	}

	@Override
	public boolean delete(long id) {
		roleRepository.removRoleFromAllSubjects(id);
		return roleRepository.delete(id);
	}

	@Override
	public boolean update(Role role) {
		return roleRepository.update(role);
	}

}
