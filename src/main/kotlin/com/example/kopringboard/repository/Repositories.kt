package com.example.kopringboard

import com.example.kopringboard.entity.Article
import com.example.kopringboard.entity.Member
import org.springframework.data.repository.CrudRepository

interface ArticleRepository: CrudRepository<Article, Long> {
	fun findBySlug(slug: String): Article?
	fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface MemberRepository: CrudRepository<Member, Long> {
	fun findByLogin(login: String): Member?
}