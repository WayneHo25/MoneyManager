package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import entity.Record;

public class ChartUtil {
	private static String[] sampleLabels(List<Record> rs) {
		String[] sampleLabels = new String[rs.size()];
		for (int i = 0; i < sampleLabels.length; i++) {
			if (0 == i % 5)
				sampleLabels[i] = String.valueOf(i + 1 + "day");
		}

		return sampleLabels;

	}

	public static double[] sampleValues(List<Record> rs) {
		double[] sampleValues = new double[rs.size()];
		for (int i = 0; i < sampleValues.length; i++) {
			sampleValues[i] = rs.get(i).spend;
		}

		return sampleValues;
	}

	public static Image getImage(List<Record> rs, int width, int height) {
		//Get the data of sample according to the expense record
		double[] sampleValues = sampleValues(rs);
		//Get the date according to the expense record
		String[] sampleLabels = sampleLabels(rs);
		//Get the maximum value from sample
		int max = max(sampleValues);

		//The color of data
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };

		//Bar char
		BarChart chart = new BarChart();

		//Set sample count
		chart.setSampleCount(sampleValues.length);
		//Set sample value
		chart.setSampleValues(0, sampleValues);
		//Set sample label
		chart.setSampleLabels(sampleLabels);
		//Set sample color
		chart.setSampleColors(sampleColors);
		//Set range
		chart.setRange(0, max * 1.2);
		//Set value line on
		chart.setValueLinesOn(true);
		//Set sample label on
		chart.setSampleLabelsOn(true);
		//Set sample label style
		chart.setSampleLabelStyle(Chart.BELOW);

		//Set range label font
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		//Set legend on
		chart.setLegendOn(true);
		//Set legend position
		chart.setLegendPosition(Chart.LEFT);
		//Set legend label
		chart.setLegendLabels(new String[] { "月消费报表" });
		//Set legend font
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		//set sample label font
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		//set chart background
		chart.setChartBackground(Color.white);
		//set background
		chart.setBackground(ColorUtil.backgroundColor);
		//transfer chart to image
		Image im = chart.getImage(width, height);
		return im;
	}

	public static int max(double[] sampleValues) {
		int max = 0;
		for (double v : sampleValues) {
			if (v > max)
				max = (int) v;
		}
		return max;

	}

	private static String[] sampleLabels() {
		String[] sampleLabels = new String[30];

		for (int i = 0; i < sampleLabels.length; i++) {
			if (0 == i % 5)
				sampleLabels[i] = String.valueOf(i + 1 + "日");
		}
		return sampleLabels;
	}

	public static Image getImage(int width, int height) {
		//sample values
		double[] sampleValues = sampleValues();
		//sample labels
		String[] sampleLabels = sampleLabels();
		//the maximum value of sample
		int max = max(sampleValues);

		//sample color
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };

		//bar char
		BarChart chart = new BarChart();

		//set sample count
		chart.setSampleCount(sampleValues.length);
		//set sample values
		chart.setSampleValues(0, sampleValues);
		//set sample label
		chart.setSampleLabels(sampleLabels);
		//set sample color
		chart.setSampleColors(sampleColors);
		//set range
		chart.setRange(0, max * 1.2);
		//set value line on
		chart.setValueLinesOn(true);
		//set sample label on
		chart.setSampleLabelsOn(true);
		//set sample label style
		chart.setSampleLabelStyle(Chart.BELOW);

		//set range label font
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		//set legend on
		chart.setLegendOn(true);
		//set legend position
		chart.setLegendPosition(Chart.LEFT);
		//set legend label
		chart.setLegendLabels(new String[] { "月消费报表" });
		//set legend font
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		//set sample legend font
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		//set chart background
		chart.setChartBackground(Color.white);
		//set background
		chart.setBackground(ColorUtil.backgroundColor);
		//transfer chart to image
		Image im = chart.getImage(width, height);
		return im;
	}

	private static double[] sampleValues() {

		double[] result = new double[30];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 300);
		}
		return result;

	}

	public static void main(String[] args) {
		JPanel p = new JPanel();
		JLabel l = new JLabel();
		Image img = ChartUtil.getImage(400, 300);
		Icon icon = new ImageIcon(img);
		l.setIcon(icon);
		p.add(l);
		GUIUtil.showPanel(p);
	}

}
