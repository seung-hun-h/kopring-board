package com.example.kopringboard.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BoardViewController {
	@GetMapping
	fun board(model: Model): String {
		model["title"] = "Board"
		return "board"
	}
}