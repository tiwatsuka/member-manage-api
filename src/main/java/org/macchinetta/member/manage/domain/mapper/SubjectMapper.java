package org.macchinetta.member.manage.domain.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.macchinetta.member.manage.domain.model.Group;
import org.macchinetta.member.manage.domain.model.Subject;
import org.macchinetta.member.manage.domain.model.SubjectDetails;

@Mapper
public interface SubjectMapper {

	Set<Subject> findAll();
	
	Set<Subject> findByGroupId(long groupId); 

	Set<Subject> findByMemberId(long memberId); 

	Subject findOne(long id);

	long create(Subject subject);

	boolean delete(long id);

	boolean update(Subject subject);

	boolean addTag(@Param("subjectId") long subjectId, @Param("tagId") long tagId);

	boolean removeTag(@Param("subjectId") long subjectId, @Param("tagId") long tagId);

	boolean removeAllMembersInGroup(@Param("subjectId") long subjectId, @Param("groupId") long groupId);
	
	boolean removeAllMembers(long subjectId);
	
	Set<Group> findGroups(long subjectId);
	
	SubjectDetails findDetails(long id);

}
