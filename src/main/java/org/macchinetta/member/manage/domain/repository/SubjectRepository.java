package org.macchinetta.member.manage.domain.repository;

import java.util.Set;

import org.macchinetta.member.manage.domain.model.Subject;

public interface SubjectRepository {

	Set<Subject> findAll();

	Subject findOne(long id);

	Subject create(Subject subject);

	boolean delete(long id);

	boolean update(Subject subject);

	boolean addTag(long subjectId, long tagId);

	boolean removeTag(long subjectId, long tagId);

	boolean addGroup(long subjectId, long groupId);

	boolean removeGroup(long subjectId, long groupId);

}
