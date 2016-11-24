package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class MemberInSubject implements Serializable{

	private static final long serialVersionUID = 1L;

	private Member member;

	private Set<Role> roles;

}
