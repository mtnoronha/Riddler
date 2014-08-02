package com.sifionsolution.riddler.controller;

import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.security.annotation.Secured;

import com.sifionsolution.riddler.model.dto.SaveableClue;
import com.sifionsolution.riddler.model.dto.SaveableRiddle;

@Controller
@Secured
public class RiddleController {

	@Get("/enigma")
	public void index() {
	}

	@Post("/enigma/salvar")
	public void save(SaveableRiddle riddle, List<SaveableClue> clues) {
	}
}
