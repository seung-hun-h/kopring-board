package com.example.kopringboard.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
	var login: String,
	var firstname: String,
	var lastname: String,
	var description: String? = null,
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
) {
}