package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.macchinetta.member.manage.domain.model.Member;

@Mapper
public interface MemberMapper {

	Set<Member> findAll();
	
	Set<Member> findByGroupId(long groupId);
	
	Member findOne(long id);

	Member create(Member member);

	boolean delete(long id);

	boolean update(Member member);

	boolean addRole(@Param("subjectId") long subjectId,
			@Param("groupId") long groupId,
			@Param("memberId") long memberId,
			@Param("roleId") long roleId);

	boolean removeRole(@Param("subjectId") long subjectId,
			@Param("groupId") long groupId,
			@Param("memberId") long memberId,
			@Param("roleId") long roleId);
	
	boolean removeMemberFromAllSubject(long memberId);

}
