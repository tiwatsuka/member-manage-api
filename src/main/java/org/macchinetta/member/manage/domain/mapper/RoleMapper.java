package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.macchinetta.member.manage.domain.model.Role;

@Mapper
public interface RoleMapper {

	Set<Role> findAll();

	Role findOne(long id);

	Role create(Role role);

	boolean delete(long id);

	boolean update(Role role);

	boolean removRoleFromAllSubjects(long roleId);

}
