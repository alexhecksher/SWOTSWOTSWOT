package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

public class GUI {

	private final int width = 1000;
	private final int height = 1000;
	private JFrame frame;
	private JLabel swotLabel, sLabel, wLabel, oLabel, tLabel;
	private JTextArea desc;
	private JButton add, go;
	private JComboBox swot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int x = 0, y = 0, h = 0, w = 0;
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		x = (int)(width * .33);
		y = (int)(height * .02);
		w = x;
		h = (int)(height * .1);
		
		swotLabel = new JLabel("SWOT");
		swotLabel.setBounds(x, y, w, h);
		swotLabel.setFont(new Font(swotLabel.getName(), Font.BOLD, fontSize(swotLabel, swotLabel.getText())));
		frame.add(swotLabel);
		
		x = (int)(width * .02);
		y = (int)(height * .13);
		w = (int)(width * .45);
		h = (int)(height * .3);
		
		frame.add(createTextArea(x, y, w, h));
		
		x = (int)(width * .49);
		
		frame.add(createTextArea(x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .45);
		
		frame.add(createTextArea(x, y, w, h));
		
		x = (int)(width * .49);
		
		frame.add(createTextArea(x, y, w, h));
			
	}
	
	public JScrollPane createTextArea(int x, int y, int w, int h) {
		JTextArea text = new JTextArea();
		text.setBackground(Color.CYAN);
		text.setLineWrap(true);
        text.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(text);
		scroll.setBounds(x, y, w, h);
		
		return scroll;
	}
	
	public int fontSize(Component comp, String text) {
		Font textFont = comp.getFont();
		
		int stringWidth = swotLabel.getFontMetrics(textFont).stringWidth(text);
		int componentWidth = swotLabel.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(textFont.getSize() * widthRatio);
		int componentHeight = comp.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSize = Math.min(newFontSize, componentHeight);

		return fontSize;
	}

}
