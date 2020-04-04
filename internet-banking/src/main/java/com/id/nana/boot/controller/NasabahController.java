package com.id.nana.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Pageable;

import com.id.nana.boot.dao.NasabahDao;

@Controller
@RequestMapping("/nasabah")
public class NasabahController {

	@Autowired
	private NasabahDao nasabahDao;

	@GetMapping("/list")
	public ModelMap tampilkanDataNasabah(Pageable page) {
		ModelMap mm = new ModelMap();
		mm.addAttribute("dataNasabah", nasabahDao.findAll(page));
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