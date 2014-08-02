package com.sifionsolution.riddler.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.shiro.authz.annotation.RequiresRoles;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.annotation.Secured;
import br.com.caelum.vraptor.validator.Validator;

import com.sifionsolution.riddler.model.dao.RiddleDAO;
import com.sifionsolution.riddler.model.dto.SaveableClue;
import com.sifionsolution.riddler.model.dto.SaveableRiddle;

@Controller
@Secured
public class RiddleController {

	@Inject
	private RiddleDAO dao;

	@Inject
	private Validator validator;

	@Inject
	private Result result;

	@RequiresRoles("Moderador")
	@Get("/enigma")
	public void index() {
	}

	@RequiresRoles("Moderator")
	@Post("/enigma/salvar")
	public void save(@NotNull @Valid SaveableRiddle riddle, @NotNull @Valid List<SaveableClue> clues) {
		validator.onErrorRedirectTo(RiddleController.class).index();

		dao.save(riddle, clues);

		result.redirectTo(RiddleController.class).index();
	}
}
