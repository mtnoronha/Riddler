package com.sifionsolution.codex.model.wrapper.builder;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.sifionsolution.codex.model.Riddle;
import com.sifionsolution.codex.model.wrapper.SelectOneWrapper;

@RequestScoped
public class RiddleSelectBuilder {

	public List<SelectOneWrapper> build(List<Riddle> rawList) {
		List<SelectOneWrapper> list = new ArrayList<SelectOneWrapper>();

		for (Riddle riddle : rawList) {
			list.add(new SelectOneWrapper(String.valueOf(riddle.getId()), riddle.getDescription()));
		}

		return list;
	}

}
