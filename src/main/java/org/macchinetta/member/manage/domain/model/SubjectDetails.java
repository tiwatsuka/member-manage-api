package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class SubjectDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private Set<Tag> tags;
	
	private Set<GroupInSubject> groups;

}
