package com.sifionsolution.codex.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static com.sifionsolution.codex.enums.Role.ADMIN;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

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

	@Get("/analysis")
	public void index() {
		result.include("riddles", builder.build(dao.listRiddles()));
	}

	@Get("/analysis/overall/{riddle}")
	public void overall(Riddle riddle) {
		List<RiddleTest> tests = dao.testsFor(riddle);

		// FIXME chart creation needs to be delegated
		ChartBuilder chartBuilder = new ChartBuilder();

		chartBuilder.addColumn(new ChartColumn("", "Description", "", "string"));
		chartBuilder.addColumn(new ChartColumn("", "Quantity", "", "number"));

		chartBuilder.addRow(new ChartCell("Total", null), new ChartCell(tests.size(), null));
		Integer feedbacks = 0;
		Integer solved = 0;
		Integer gaviups = 0;

		for (RiddleTest test : tests) {
			if (test.getComment() != null)
				feedbacks++;

			if (test.getSolved() == true)
				solved++;
			else
				gaviups++;
		}

		chartBuilder.addRow(new ChartCell("Solved", null), new ChartCell(solved, null));
		chartBuilder.addRow(new ChartCell("Gaviups", null), new ChartCell(gaviups, null));
		chartBuilder.addRow(new ChartCell("With feedback", null), new ChartCell(feedbacks, null));

		AnalysisWrapper wrapper = new AnalysisWrapper(chartBuilder.build());
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
