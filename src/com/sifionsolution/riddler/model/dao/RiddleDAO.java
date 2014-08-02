package com.sifionsolution.riddler.model.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sifionsolution.riddler.dao.GenericDAO;
import com.sifionsolution.riddler.model.Clue;
import com.sifionsolution.riddler.model.Riddle;
import com.sifionsolution.riddler.model.dto.SaveableClue;
import com.sifionsolution.riddler.model.dto.SaveableRiddle;

@RequestScoped
public class RiddleDAO {

	private final GenericDAO<Long, Riddle> dao;
	private final GenericDAO<Long, Clue> clueDao;

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
		clueDao = new GenericDAO<Long, Clue>(Clue.class, manager);
	}

	public void save(SaveableRiddle riddle, List<SaveableClue> clues) {
		Riddle entity = new Riddle();
		entity.load(riddle);

		dao.save(entity);

		for (SaveableClue clue : clues) {
			Clue clueEntity = new Clue();
			clueEntity.load(clue, entity);
			clueDao.save(clueEntity);
		}
	}
}
