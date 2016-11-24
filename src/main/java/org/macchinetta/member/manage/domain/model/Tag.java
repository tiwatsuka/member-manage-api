package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;

	long id;

	String name;

}
