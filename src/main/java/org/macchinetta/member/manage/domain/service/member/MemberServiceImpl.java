package org.macchinetta.member.manage.domain.service.member;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Member;
import org.macchinetta.member.manage.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public Set<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member findOne(long id) {
		return memberRepository.findOne(id);
	}

	@Override
	public Member create(Member member) {
		return memberRepository.create(member);
	}

	@Override
	public boolean delete(long id) {
		memberRepository.removeMemberFromAllSubject(id);
		return memberRepository.delete(id);
	}

	@Override
	public boolean update(Member member) {
		return memberRepository.update(member);
	}

	@Override
	public boolean addRole(long subjectId, long groupId, long memberId, long roleId) {
		return memberRepository.addRole(subjectId, groupId, memberId, roleId);
	}

	@Override
	public boolean removeRole(long subjectId, long groupId, long memberId, long roleId) {
		return memberRepository.removeRole(subjectId, groupId, memberId, roleId);
	}

}
