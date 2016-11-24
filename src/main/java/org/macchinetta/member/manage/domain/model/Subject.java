package org.macchinetta.member.manage.domain.model;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;

	long id;

	String name;

	Set<Tag> tags;

}
