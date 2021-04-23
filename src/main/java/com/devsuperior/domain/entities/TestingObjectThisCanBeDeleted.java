package com.devsuperior.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_testing_object")
public class TestingObjectThisCanBeDeleted {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
