package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawGraph extends JPanel {

	private static final int PREF_W = 640;
	private static final int PREF_H = 480;
	private static final int BORDER_GAP = 30;

	private static final Color GRAPH_POINT_COLOR_TRUE = new Color(255, 0, 0);
	private static final Color GRAPH_POINT_COLOR_FALSE = new Color(0, 0, 255);
	private static final Color GRAPH_POINT_COLOR_CONTROL = new Color(0, 255, 0);

	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);

	private static final int GRAPH_POINT_WIDTH = 12;
	private static final int Y_HATCH_CNT = 10;
	private static final int X_HATCH_CNT = 10;

	private List<Integer> scores;

	public DrawGraph(List<Integer> scores) {
		this.scores = scores;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (X_HATCH_CNT );
		double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (Y_HATCH_CNT);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < scores.size(); i++) {
			int x1 = (int) (i * xScale + BORDER_GAP);
			int y1 = (int) ((Y_HATCH_CNT - scores.get(i)) * yScale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}
		drawGrid(g2,xScale,yScale);


		g2.setColor(GRAPH_POINT_COLOR_TRUE);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	private void drawGrid(Graphics2D g2, double xScale, double yScale) {
		// create x and y axes
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

		// create hatch marks for y axis.
		int sizeOfRow = getHeight() - BORDER_GAP * 2;
		for (int i = 0; i < Y_HATCH_CNT; i++) {
			int x0 = BORDER_GAP;
			int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
			int y0 = (int) (yScale*i + BORDER_GAP);
			int y1 = y0;
			g2.drawLine(x0, y0, x1, y1);
		}

		int x0 = 0;
		for (int i = 0; i < Y_HATCH_CNT; i++) {

			x0 = (int) (xScale*i + BORDER_GAP);
			int x1 = x0;
			int y0 = getHeight() - BORDER_GAP;
			int y1 = y0 - GRAPH_POINT_WIDTH;
			g2.drawLine(x0, y0, x1, y1);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGui() {
		List<Integer> scores = new ArrayList<Integer>();
		Random random = new Random();
		int maxDataPoints = 10;
		for (int i = 0; i < maxDataPoints ; i++) {
			scores.add(i);
		}
		DrawGraph mainPanel = new DrawGraph(scores);

		JFrame frame = new JFrame("DrawGraph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}