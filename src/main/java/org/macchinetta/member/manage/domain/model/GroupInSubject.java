package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class GroupInSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	private Group group;

	private Set<MemberInSubject> members;

}
