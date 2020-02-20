/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Chekib
 */
 import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

   

public class JFreeChartChartBorderExample {

	public static void main(int a, int b ) {

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Nombre De Compétition En Attente = "+a, a);
		dataset.setValue("Nombre De Compétition approuvé = "+b, b);
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Compétition", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
		chart.setBorderVisible(true);
		chart.setBorderPaint(Color.red); // You can set any color as border here.

		ChartFrame frame = new ChartFrame("JFreeChat Pie Chart", chart);
		frame.pack();
		frame.setVisible(true);
	}
}


