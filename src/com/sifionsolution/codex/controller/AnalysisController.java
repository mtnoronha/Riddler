package com.sifionsolution.codex.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static com.sifionsolution.codex.enums.Role.ADMIN;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sifionsolution.codex.analysis.wrapper.builder.AnalysisWrapperBuilder;
import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.google.charts.builder.ChartBuilder;
import com.sifionsolution.codex.model.Riddle;
import com.sifionsolution.codex.model.RiddleTest;
import com.sifionsolution.codex.model.dao.RiddleAnalysisDao;
import com.sifionsolution.codex.model.wrapper.builder.RiddleSelectBuilder;
import com.sifionsolution.codex.riddle.test.analysis.AnalysisWrapper;
import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(ADMIN)
public class AnalysisController {

	@Inject
	private Result result;

	@Inject
	private RiddleAnalysisDao dao;

	@Inject
	private RiddleSelectBuilder builder;

	@Inject
	private AnalysisWrapperBuilder analysisBuilder;

	@Get("/analysis")
	public void index() {
		result.include("riddles", builder.build(dao.listRiddles()));
	}

	@Get("/analysis/overall/{riddle}")
	public void overall(Riddle riddle) {
		List<RiddleTest> tests = dao.testsFor(riddle);

		AnalysisWrapper wrapper = analysisBuilder.build(tests);

		result.use(json()).withoutRoot().from(wrapper).recursive().serialize();

	}

	@Get("/analysis/test")
	public void test() {
		ChartBuilder builder = new ChartBuilder();

		builder.addColumn(new ChartColumn("", "Topping", "", "string"));
		builder.addColumn(new ChartColumn("", "Slices", "", "number"));

		builder.addRow(new ChartCell("Mushrooms", null), new ChartCell(new Integer(3), null));
		builder.addRow(new ChartCell("Onions", null), new ChartCell(new Integer(1), null));
		builder.addRow(new ChartCell("Olives", null), new ChartCell(new Integer(1), null));
		builder.addRow(new ChartCell("Zucchini", null), new ChartCell(new Integer(1), null));
		builder.addRow(new ChartCell("Pepperoni", null), new ChartCell(new Integer(2), null));

		ChartWrapper wrapper = builder.build();

		result.use(Results.json()).withoutRoot().from(wrapper).recursive().serialize();
	}

}
