package com.example.kopringboard.controller

import com.example.kopringboard.ArticleRepository
import com.example.kopringboard.entity.Article
import com.example.kopringboard.entity.Member
import com.example.kopringboard.format
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class BoardViewController(
	private val articleRepository: ArticleRepository
) {
	@GetMapping
	fun board(model: Model): String {
		model["title"] = "Board"
		model["articles"] = articleRepository.findAllByOrderByAddedAtDesc().map { it.render() }
		return "board"
	}

	@GetMapping("/article/{slug}")
	fun article(@PathVariable slug: String, model: Model): String {
		val article = (articleRepository.findBySlug(slug)
			?.render()
			?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist"))

		model["title"] = article.title
		model["article"] = article
		return "article"
	}

	fun Article.render() = RenderedArticle(
		slug,
		title,
		headline,
		content,
		author,
		addedAt.format()
	)

	data class RenderedArticle(
		val slug: String,
		val title: String,
		val headline: String,
		val content: String,
		val author: Member,
		val addedAt: String
	)
}