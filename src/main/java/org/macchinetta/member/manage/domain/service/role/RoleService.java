package org.macchinetta.member.manage.domain.service.role;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Role;

public interface RoleService {

	Set<Role> findAll();

	Role findOne(long id);

	Role create(Role role);

	boolean delete(long id);

	boolean update(Role role);

}
