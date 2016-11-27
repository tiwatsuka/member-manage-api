package org.macchinetta.member.manage.domain.service.subject;

import java.util.Collections;
import java.util.Set;	
import java.util.stream.Collectors;

import org.macchinetta.member.manage.domain.mapper.SubjectMapper;
import org.macchinetta.member.manage.domain.model.Group;
import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.model.SubjectDetails;
import org.macchinetta.member.manage.domain.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectMapper subjectMapper;
	
	@Override
	public Set<Subject> findAll() {
		return subjectMapper.findAll();
	}

	@Override
	public Subject findOne(long id) {
		return subjectMapper.findOne(id);
	}

	@Override
	public Subject create(Subject subject) {
		subjectMapper.create(subject);
		subject.getTags().stream()
			.forEach(tag -> subjectMapper.addTag(subject.getId(), tag.getId()));
		return subjectMapper.findOne(subject.getId());
	}

	@Override
	public boolean delete(long id) {
		Subject subject = subjectMapper.findOne(id);
		if(subject == null) return false;
		subject.getTags()
			.stream()
			.forEach(tag -> subjectMapper.removeTag(id, tag.getId()));
		subjectMapper.removeAllMembers(id);
		return subjectMapper.delete(id);
	}

	@Override
	public boolean update(Subject subject) {
		Subject old = subjectMapper.findOne(subject.getId());
		if(old == null) return false;
		Set<Long> tagIds = subject.getTags().stream().map(Tag::getId).collect(Collectors.toSet());
		Set<Long> oldTagIds = old.getTags().stream().map(Tag::getId).collect(Collectors.toSet());
		tagIds.stream()
			  .filter(tagId -> !oldTagIds.contains(tagId))
			  .forEach(tagId -> subjectMapper.addTag(subject.getId(), tagId));
		oldTagIds.stream()
		   		 .filter(tagId -> !tagIds.contains(tagId))
		   		 .forEach(tagId -> subjectMapper.removeTag(subject.getId(), tagId));
		return subjectMapper.update(subject);
	}

	@Override
	public boolean addTag(long subjectId, long tagId) {
		return subjectMapper.addTag(subjectId, tagId);
	}

	@Override
	public boolean removeTag(long subjectId, long tagId) {
		return subjectMapper.removeTag(subjectId, tagId);
	}

	@Override
	public Set<Group> findGroups(long subjectId) {
		return subjectMapper.findGroups(subjectId);
	}

	@Override
	public SubjectDetails findDetails(long id) {
		SubjectDetails details = subjectMapper.findDetails(id);
		if(details == null){
			Subject subject = subjectMapper.findOne(id);
			if (subject != null){
				details = new SubjectDetails();
				details.setId(subject.getId());
				details.setName(subject.getName());
				details.setTags(subject.getTags());
				details.setGroups(Collections.emptySet());
			}
		}
		return details;
	}

	@Override
	public Set<Subject> findByGroupId(long groupId) {
		return subjectMapper.findByGroupId(groupId);
	}

	@Override
	public Set<Subject> findByMemberId(long memberId) {
		return subjectMapper.findByMemberId(memberId);
	}

	@Override
	public boolean removeAllMembersInGroup(long subjectId, long groupId) {
		return subjectMapper.removeAllMembersInGroup(subjectId, groupId);
	}

	@Override
	public boolean removeAllMembers(long subjectId) {
		return subjectMapper.removeAllMembers(subjectId);
	}

}
