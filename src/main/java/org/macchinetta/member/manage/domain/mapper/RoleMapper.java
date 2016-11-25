package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.macchinetta.member.manage.domain.model.Role;

@Mapper
public interface RoleMapper {

	Set<Role> findAll();

	@Select("SELECT role_id, role_name FROM t_role WHERE role_id = #{id}")
	Role findOne(long id);

	Role create(Role role);

	boolean delete(long id);

	boolean update(Role role);

	boolean removRoleFromAllSubjects(long roleId);

}
