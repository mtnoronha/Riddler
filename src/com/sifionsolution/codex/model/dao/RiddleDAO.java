package com.sifionsolution.codex.model.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.codex.dao.GenericDAO;
import com.sifionsolution.codex.model.Riddle;
import com.sifionsolution.codex.model.dto.SaveableClue;
import com.sifionsolution.codex.model.dto.SaveableRiddle;

@RequestScoped
public class RiddleDAO {

	private final GenericDAO<Long, Riddle> dao;

	/*
	 * CDI eyes only
	 */
	@Deprecated
	public RiddleDAO() {
		this(null);
	}

	@Inject
	public RiddleDAO(EntityManager manager) {
		dao = new GenericDAO<Long, Riddle>(Riddle.class, manager);
	}

	public void save(SaveableRiddle riddle, List<SaveableClue> clues) {
		Riddle entity = new Riddle();

		entity.load(riddle, clues);

		if (entity.getId() != null) {
			dao.update(entity);
		} else {
			dao.save(entity);
		}
	}

	public List<Riddle> list() {
		return dao.findAll();
	}

	public Riddle find(Long id) {
		return dao.getById(id);
	}

	public void remove(Riddle riddle) {
		if (riddle != null)
			dao.delete(riddle);
	}
}
