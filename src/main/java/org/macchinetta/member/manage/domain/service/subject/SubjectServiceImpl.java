package org.macchinetta.member.manage.domain.service.subject;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Group;
import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.model.SubjectDetails;
import org.macchinetta.member.manage.domain.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public Set<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject findOne(long id) {
		return subjectRepository.findOne(id);
	}

	@Override
	public Subject create(Subject subject) {
		Subject result = subjectRepository.create(subject);
		subject.getTags().stream()
			.forEach(tag -> subjectRepository.addTag(subject.getId(), tag.getId()));
		return result;
	}

	@Override
	public boolean delete(long id) {
		subjectRepository.findOne(id)
			.getTags()
			.stream()
			.forEach(tag -> subjectRepository.removeTag(id, tag.getId()));
		subjectRepository.removeAllMembers(id);
		subjectRepository.removeAllGroups(id);
		return subjectRepository.delete(id);
	}

	@Override
	public boolean update(Subject subject) {
		Subject old = subjectRepository.findOne(subject.getId());
		subject.getTags()
				.stream()
				.filter(tag -> !old.getTags().contains(tag))
				.forEach(tag -> subjectRepository.addTag(subject.getId(), tag.getId()));
		old.getTags()
			.stream()
			.filter(tag -> !subject.getTags().contains(tag))
			.forEach(tag -> subjectRepository.removeTag(subject.getId(), tag.getId()));
		return subjectRepository.update(subject);
	}

	@Override
	public boolean addTag(long subjectId, long tagId) {
		return subjectRepository.addTag(subjectId, tagId);
	}

	@Override
	public boolean removeTag(long subjectId, long tagId) {
		return subjectRepository.removeTag(subjectId, tagId);
	}

	@Override
	public boolean addGroup(long subjectId, long groupId) {
		return subjectRepository.addGroup(subjectId, groupId);
	}

	@Override
	public boolean removeGroup(long subjectId, long groupId) {
		subjectRepository.removeAllMembersInGroup(subjectId, groupId);
		return subjectRepository.removeGroup(subjectId, groupId);
	}

	@Override
	public Set<Group> findGroups(long subjectId) {
		return subjectRepository.findGroups(subjectId);
	}

	@Override
	public SubjectDetails findDetails(long id) {
		return subjectRepository.findDetails(id);
	}

	@Override
	public Set<Subject> findByGroupId(long groupId) {
		return subjectRepository.findByGroupId(groupId);
	}

	@Override
	public Set<Subject> findByMemberId(long memberId) {
		return subjectRepository.findByMemberId(memberId);
	}

}
