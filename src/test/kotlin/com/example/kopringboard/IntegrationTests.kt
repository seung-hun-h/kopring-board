package com.example.kopringboard

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

	@Test
	fun `Assert blog page title, content and status code`() {
		val result = restTemplate.getForEntity<String>("/")
		assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(result.body).contains("<h1>Board</h1>")
	}
}