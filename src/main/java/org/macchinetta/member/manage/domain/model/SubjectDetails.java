package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class SubjectDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Subject subject;
	
	private Set<GroupInSubject> groups;

}
