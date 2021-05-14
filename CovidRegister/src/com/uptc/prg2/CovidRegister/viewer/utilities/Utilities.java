package com.uptc.prg2.CovidRegister.viewer.utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Utilities {

	public static Component space(int widht, int height) {
		Dimension sizeSpace = new Dimension();
		sizeSpace.setSize(widht, height);
		JLabel componentSpace = new JLabel();
		componentSpace.setText(
				"                                ");
		componentSpace.setMaximumSize(sizeSpace);
		return componentSpace;
	}

	public static Component image(int widht, int height,
			String URL) {
		JLabel componentImage = new JLabel();
		String url = URL;
		ImageIcon icon = new ImageIcon(new ImageIcon(url)
				.getImage().getScaledInstance(widht, height,
						Image.SCALE_DEFAULT));
		componentImage.setIcon(icon);
		componentImage.setSize(widht, height);
		componentImage.setBorder(null);
		return componentImage;
	}

	public static Component text(JLabel componentText,
			Font font, String text, Color color) {
		componentText.setForeground(color);
		componentText.setFont(font);
		componentText.setText(text);
		return componentText;
	}

	public static Component buttonImage(JButton buttonImage,
			int widht, int height, String URL) {
		JLabel componentImage = new JLabel();
		String url = URL;
		ImageIcon icon = new ImageIcon(new ImageIcon(url)
				.getImage().getScaledInstance(widht, height,
						Image.SCALE_DEFAULT));
		componentImage.setIcon(icon);
		componentImage.setSize(widht, height);
		componentImage.setBorder(null);
		buttonImage.setContentAreaFilled(false);
		buttonImage.setBorderPainted(false);
		buttonImage.add(componentImage);
		return buttonImage;
	}

	public static Component button(JButton button,
			int width, int height, String text) {
		Dimension sizeButton = new Dimension();
		sizeButton.setSize(width, height);
		button.setText(text);
		button.setMaximumSize(sizeButton);
		button.isBorderPainted();
		button.isContentAreaFilled();
		return button;
	}

	public static Component textField(JTextField cTextField,
			Font font, String text, Color color, int width,
			int height) {
		Dimension sizeTextField = new Dimension();
		sizeTextField.setSize(width, height);
		cTextField.setForeground(color);
		cTextField.setFont(font);
		cTextField.setText(text);
		cTextField.setEditable(true);
		cTextField.setMaximumSize(sizeTextField);
		return cTextField;
	}

	public static Component comboBox(
			JComboBox<String> correctOption,
			String[] options, int width, int height) {
		Dimension sizeComboBox = new Dimension();
		sizeComboBox.setSize(width, height);
		// correctOption = new JComboBox<>(choice);
		for (int i = 0; i < options.length; i++) {
			correctOption.addItem(options[i]);
		}
		correctOption.setMaximumSize(sizeComboBox);
		correctOption.setBackground(Color.WHITE);
		return correctOption;
	}
}
