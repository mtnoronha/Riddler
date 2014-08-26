package com.sifionsolution.codex.controller;

import static com.sifionsolution.codex.enums.Role.ADMIN;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sifionsolution.codex.google.charts.ChartCell;
import com.sifionsolution.codex.google.charts.ChartColumn;
import com.sifionsolution.codex.google.charts.ChartWrapper;
import com.sifionsolution.codex.google.charts.builder.ChartBuilder;
import com.sifionsolution.codex.security.AllowTo;

@Controller
@AllowTo(ADMIN)
public class AnalysisController {

	@Inject
	private Result result;

	@Get("/analysis")
	public void index() {
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
