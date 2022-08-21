package com.example.kopringboard.config

import com.example.kopringboard.ArticleRepository
import com.example.kopringboard.MemberRepository
import com.example.kopringboard.entity.Article
import com.example.kopringboard.entity.Member
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BoardConfiguration {
	@Bean
	fun databaseInitializer(memberRepository: MemberRepository,
							articleRepository: ArticleRepository) = ApplicationRunner {

		val smaldini = memberRepository.save(Member("smaldini", "Stéphane", "Maldini"))
		articleRepository.save(
			Article(
				title = "Reactor Bismuth is out",
				headline = "Lorem ipsum",
				content = "dolor sit amet",
				author = smaldini
			)
		)
		articleRepository.save(
			Article(
				title = "Reactor Aluminium has landed",
				headline = "Lorem ipsum",
				content = "dolor sit amet",
				author = smaldini
			)
		)
	}
}