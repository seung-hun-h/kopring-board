package com.example.kopringboard

import com.example.kopringboard.entity.Article
import com.example.kopringboard.entity.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoryTests @Autowired constructor(
	val entityManager: TestEntityManager,
	val userRepository: MemberRepository,
	val articleRepository: ArticleRepository
) {

	@Test
	fun `When findByIdOrNull then return Article`() {
		val user = Member("springjuergen", "Juergen", "Hoeller")
		entityManager.persist(user)
		val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community...", "Lorem ipsum", user)
		entityManager.persist(article)
		entityManager.flush()
		val result = articleRepository.findByIdOrNull(article.id!!)
		assertThat(result).isEqualTo(article)
	}

	@Test
	fun `When findByLogin then return User`() {
		val member = Member("springjuergen", "Juergen", "Hoeller")
		entityManager.persist(member)
		entityManager.flush()
		val user = userRepository.findByLogin(member.login)
		assertThat(user).isEqualTo(member)
	}
}