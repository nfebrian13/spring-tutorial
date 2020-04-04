package com.id.nana.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.id.nana.boot.dao.NasabahDao;
import com.id.nana.boot.entity.Nasabah;

@Controller
@RequestMapping("/nasabah")
public class NasabahController {

	@Autowired
	private NasabahDao nasabahDao;

	/*
	 * example : pageable http://localhost:8080/nasabah/list?size=1&page=1
	 */

	@GetMapping("/list")
	public ModelMap tampilkanDataNasabah(Pageable page) {
		ModelMap mm = new ModelMap();
		mm.addAttribute("dataNasabah", nasabahDao.findAll(page));
		return mm;
	}

	@GetMapping("/form")
	public ModelMap tampilkanForm(@RequestParam(required = false, value = "id") Nasabah n) {
		ModelMap mm = new ModelMap();

		if (n == null) {
			n = new Nasabah();
		}

		mm.addAttribute("nasabah", n);
		return mm;
	}

	/*
	 * ModelAttribute: adalah objek dari nasabah BindingResult : untuk menampung
	 * error, dan membuat validasi SessionStatus : jika user telah input form dan
	 * terjadi error, maka akan keep fieldnya di view
	 */

	@PostMapping("/form")
	public String processForm(@ModelAttribute @Valid Nasabah n, BindingResult errors, SessionStatus status) {
		if (errors.hasErrors()) {
			return "nasabah/form";
		}

		nasabahDao.save(n);
		status.setComplete();

		return "redirect:list";
	}
}