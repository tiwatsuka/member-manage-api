package org.macchinetta.member.manage.domain.service.member;

import java.util.Set;

import org.macchinetta.member.manage.domain.mapper.MemberMapper;
import org.macchinetta.member.manage.domain.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public Set<Member> findAll() {
		return memberMapper.findAll();
	}

	@Override
	public Member findOne(long id) {
		return memberMapper.findOne(id);
	}

	@Override
	public Member create(Member member) {
		return memberMapper.create(member);
	}

	@Override
	public boolean delete(long id) {
		memberMapper.removeMemberFromAllSubject(id);
		return memberMapper.delete(id);
	}

	@Override
	public boolean update(Member member) {
		return memberMapper.update(member);
	}

	@Override
	public boolean addRole(long subjectId, long groupId, long memberId, long roleId) {
		return memberMapper.addRole(subjectId, groupId, memberId, roleId);
	}

	@Override
	public boolean removeRole(long subjectId, long groupId, long memberId, long roleId) {
		return memberMapper.removeRole(subjectId, groupId, memberId, roleId);
	}

}
