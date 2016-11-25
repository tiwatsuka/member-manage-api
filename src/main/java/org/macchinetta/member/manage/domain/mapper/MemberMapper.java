package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.macchinetta.member.manage.domain.model.Member;

@Mapper
public interface MemberMapper {

	Set<Member> findAll();
	
	Set<Member> findByGroupId(long groupId);
	
	@Select("SELECT member_id, member_name, email, phone FROM t_member WHERE member_id = #{id}")
	Member findOne(long id);

	Member create(Member member);

	boolean delete(long id);

	boolean update(Member member);

	boolean addRole(long subjectId, long groupId, long memberId, long roleId);

	boolean removeRole(long subjectId, long groupId, long memberId, long roleId);
	
	boolean removeMemberFromAllSubject(long memberId);

}
