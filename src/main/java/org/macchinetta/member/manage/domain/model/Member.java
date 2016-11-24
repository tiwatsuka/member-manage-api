package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	long id;

	String name;

	String email;

	String phone;

}
