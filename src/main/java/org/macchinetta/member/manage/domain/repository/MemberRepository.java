package org.macchinetta.member.manage.domain.repository;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Member;

public interface MemberRepository {

	Set<Member> findAll();
	
	Set<Member> findByGroupId(long groupId);
	
	Member findOne(long id);

	Member create(Member member);

	boolean delete(long id);

	boolean update(Member member);

	boolean addRole(long subjectId, long groupId, long memberId, long roleId);

	boolean removeRole(long subjectId, long groupId, long memberId, long roleId);
	
	boolean removeMemberFromAllSubject(long memberId);

}
