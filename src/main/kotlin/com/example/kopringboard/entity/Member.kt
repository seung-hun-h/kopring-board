package com.example.kopringboard.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member(
	var login: String,
	var firstname: String,
	var lastname: String,
	var description: String? = null,
	@Id @GeneratedValue var id: Long? = null
) {
}