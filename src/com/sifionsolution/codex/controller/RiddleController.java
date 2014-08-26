package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.ADMIN;
import static com.sifionsolution.codex.enums.Role.MODERATOR;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sifionsolution.codex.model.Riddle;
import com.sifionsolution.codex.model.dao.RiddleDAO;
import com.sifionsolution.codex.model.dto.SaveableClue;
import com.sifionsolution.codex.model.dto.SaveableRiddle;
import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo({ MODERATOR, ADMIN })
public class RiddleController {

	@Inject
	private RiddleDAO dao;

	@Inject
	private Validator validator;

	@Inject
	private Result result;

	@Get({ "/riddle/{riddle}", "/riddle", "/riddle/" })
	public void index(Riddle riddle) {
		result.include("riddle", riddle);

		if (riddle != null) {
			result.include("clues", riddle.getClues());
		}
	}

	@Get("/riddle/clone/{riddle}")
	public void clone(Riddle riddle) {
		result.redirectTo(RiddleController.class).index(riddle.getNewEntityClone());
	}

	@Get("/riddles")
	public void list() {
		result.include("riddles", dao.list());
	}

	@Post("/riddle/save")
	public void save(@NotNull @Valid SaveableRiddle riddle, @NotNull @Valid List<SaveableClue> clues) {
		Riddle entity = new Riddle();
		entity.load(riddle, clues);

		validator.onErrorRedirectTo(RiddleController.class).index(entity);

		dao.save(riddle, clues);

		result.redirectTo(RiddleController.class).list();
	}

	@Get("/riddle/remove/{riddle}")
	public void remove(Riddle riddle) {
		dao.remove(riddle);

		result.redirectTo(RiddleController.class).list();
	}
}
