package com.id.nana.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nasabah")
public class NasabahController {

	@GetMapping("/list")
	public ModelMap tampilkanDataNasabah() {
		ModelMap mm = new ModelMap();
		return mm;
	}

	@GetMapping("/form")
	public void tampilkanForm() {
	}

	@PostMapping("/form")
	public String processForm() {
		return "redirect:list";
	}
}