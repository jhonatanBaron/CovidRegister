package com.uptc.prg2.CovidRegister.viewer.reports;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PointGraphics extends JPanel {

	private static final long serialVersionUID = 1L;
	private short x1AxisX, y1AxisX, x2AxisX, y2AxisX, x1AxisY,
			y1AxisY, x2AxisY, y2AxisY;
	private double intervalX, intervalY;
	public static short valueMaxY = 320;
	private short rankY;
	private ArrayList<String> tag, valueString;
	private ArrayList<Integer> valueData, position;

	PointGraphics() {
		tag = new ArrayList<>();
		valueData = new ArrayList<>();
		valueString = new ArrayList<>();
		position = new ArrayList<>();
		this.setBackground(Color.WHITE);
		Toolkit jFrameWindow = Toolkit.getDefaultToolkit();
		Dimension screenSize = jFrameWindow.getScreenSize();
		this.setSize((int) (screenSize.getWidth() / 1.6),
				(int) (screenSize.getHeight() / 1.5));
	}

//	public void infoExtractor(
//			ArrayList<DataReport> dataList) {
//		for (int i = 0; i < dataList.size(); i++) {
//			tag.add(dataList.get(i).getDataTypeName());
//			valueString.add(String.valueOf(
//					(int) dataList.get(i).getDataValue()));
//			valueData.add(
//					(int) dataList.get(i).getDataValue());
//			position.add(i + 1);
//		}
//	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		RenderingHints render = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2d.setRenderingHints(render);
		graphics.setColor(Color.BLACK);
		this.updateCoordinates(graphics2d);
		graphics.drawLine(x1AxisX, y1AxisX, x2AxisX, y2AxisX);
		graphics.drawLine(x1AxisY, y1AxisY, x2AxisY, y2AxisY);
		graphics.setFont(new Font("Open Sans", Font.PLAIN, 14));
		this.paintGrid(graphics2d);
		this.paintDivisionsX(graphics);
		this.paintDivisionsY(graphics);
		this.paintLabelX(graphics2d);
		this.paintLabelY(graphics);
		this.paintLabelValue(graphics2d);
		this.paintStatisticalGraphPoints(graphics2d);
	}

	public void updateCoordinates(Graphics graphics) {
		x1AxisX = (short) (this.getWidth() / 27);
		y1AxisX = (short) (this.getHeight() / 1.05);
		x2AxisX = (short) (this.getWidth() - 60);
		y2AxisX = (short) (this.getHeight() / 1.05);
		x1AxisY = (short) (this.getWidth() / 27);
		y1AxisY = 10;
		x2AxisY = (short) (this.getWidth() / 27);
		y2AxisY = (short) (this.getHeight() / 1.05);
	}

	public double getIntervalX() {
		intervalX = (short) ((x2AxisX - x1AxisX) / tag.size());
		return intervalX;
	}

	public double getIntervalY() {
		intervalY = (short) ((y2AxisY - y1AxisY) / 40);
		return intervalY;
	}

	private void paintDivisionsX(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		short y1DivisionY = (short) (y2AxisX - 5);
		short y2DivisionY = (short) (y2AxisX + 5);
		short xDivisionX = (short) x1AxisY;
		for (short i = (short) x1AxisY; i < getWidth(); i += getIntervalX()) {
			xDivisionX += getIntervalX();
			graphics.drawLine(xDivisionX, y1DivisionY, xDivisionX,
					y2DivisionY);
		}
	}

	private void paintDivisionsY(Graphics graphics) {
		short x1DivisionX = (short) (x1AxisY - 5);
		short x2DivisionX = (short) (x1AxisY + 5);
		short yDivisionY = y2AxisY;
		for (short i = y2AxisY; i > 0; i -= getIntervalY()) {
			yDivisionY -= getIntervalY();
			graphics.drawLine(x1DivisionX, yDivisionY, x2DivisionX,
					yDivisionY);
		}
	}

	private void paintGrid(Graphics graphics) {
		graphics.setColor(Color.LIGHT_GRAY);
		short y1DivisionY = (short) (y2AxisX + 5);
		short x1DivisionX = (short) (x1AxisY + 5);
		short x2DivisionX = (short) (x2AxisX);
		short yDivisionY = y2AxisY;
		short xDivisionX = (short) x1AxisY;
		for (short i = (short) x1AxisY; i < getWidth(); i += getIntervalX()) {
			xDivisionX += getIntervalX();
			graphics.drawLine(xDivisionX, 0, xDivisionX, y1DivisionY);
		}

		for (short i = y2AxisY; i > 0; i -= getIntervalY()) {
			yDivisionY -= getIntervalY();
			graphics.drawLine(x1DivisionX, yDivisionY, x2DivisionX,
					yDivisionY);
		}
	}

	public void paintLabelX(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		short yDivisionX = (short) (y2AxisX + 5);
		short xDivisionX = (short) x1AxisY;

		for (short i = x1AxisX; i < x2AxisX; i += getIntervalX()) {
			for (int j = 0; j < tag.size(); j++) {
				xDivisionX += getIntervalX();
				graphics.drawString(tag.get(j), (int) xDivisionX - 90,
						(int) yDivisionX + 10);
			}
		}
	}

	public void paintLabelY(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		short xDivisionX = (short) (x1AxisY);
		short yDivisionY = y2AxisY;

		int value = 0;
		rankY = (short) (valueMaxY / 0.22);
		for (short i = y2AxisY; i > 0; i -= getIntervalY()) {
			value += rankY;
			yDivisionY -= getIntervalY();
			graphics.drawString("" + value, (int) xDivisionX - 40,
					(int) yDivisionY + 5);
		}
	}

	public void paintStatisticalGraphPoints(Graphics graphics) {
		graphics.setColor(Color.MAGENTA);
		for (int i = 0; i < position.size(); i++) {
			double ancho = getIntervalX() / 5;
			double puntoinicialx = getCoordX(position.get(i))
					- (ancho / 2);
			graphics.fillOval((int) puntoinicialx,
					(int) getCoordY(valueData.get(i)),
					(int) ((int) getIntervalX() / 4),
					(int) getIntervalY());
		}
	}

	public void paintLabelValue(Graphics graphics) {
		for (int i = 0; i < valueString.size(); i++) {
			double ancho = getIntervalX() / 1.5;
			double puntoinicialx = getCoordX(position.get(i))
					- (ancho / 5.5);
			graphics.drawString(valueString.get(i),
					(int) puntoinicialx,
					(int) (getCoordY(valueData.get(i)) - 5));
		}
	}

	private double getCoordX(double x) {
		double real_x = x1AxisY + (x * getIntervalX());
		return real_x;
	}

	private double getCoordY(double y) {
		double real_y = y2AxisY - ((y / rankY) * intervalY);
		return (real_y);
	}

	public void graficVisibility(boolean visibility) {
		this.setVisible(visibility);
	}
}
