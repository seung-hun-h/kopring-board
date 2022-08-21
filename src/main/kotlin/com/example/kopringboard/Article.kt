package com.example.kopringboard

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Article(
	var title: String,
	var headline: String,
	var content: String,
	@ManyToOne var author: Member,
	var slug: String = title.toSlug(),
	var addedAt: LocalDateTime = LocalDateTime.now(),
	@Id @GeneratedValue var id: Long? = null
) {
}