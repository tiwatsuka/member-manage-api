package org.macchinetta.member.manage.domain.repository;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Group;
import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.model.SubjectDetails;

public interface SubjectRepository {

	Set<Subject> findAll();
	
	Set<Subject> findByGroupId(long groupId); 

	Set<Subject> findByMemberId(long memberId); 

	Subject findOne(long id);

	Subject create(Subject subject);

	boolean delete(long id);

	boolean update(Subject subject);

	boolean addTag(long subjectId, long tagId);

	boolean removeTag(long subjectId, long tagId);

	boolean addGroup(long subjectId, long groupId);

	boolean removeGroup(long subjectId, long groupId);

	boolean removeAllGroups(long subjectId);

	boolean removeAllMembersInGroup(long subjectId, long groupId);
	
	boolean removeAllMembers(long subjectId);
	
	Set<Group> findGroups(long subjectId);
	
	SubjectDetails findDetails(long id);

}
