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
	private JTextArea stre;
	private JTextArea weak;
	private JTextArea oper;
	private JTextArea threat;
	private JTextArea desc;
	private JButton add;
	private JButton go;
	private JComboBox swot;
	
	Font font = new Font("Verdana", Font.PLAIN, 13);
	
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
		int x = 0;
		int y = 0;
		int w = 0;
		int h = 0;
		
		frame = new JFrame();
		frame.setBounds(0, 0, width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		x = (int)(width * .33);
		y = (int)(height * .02);
		w = x;
		h = (int)(height * .1);
		
		frame.add(createLabel("SWOT", x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .18);
		w = (int)(width * .45);
		h = (int)(height * .25);
		
		stre = createTextArea(x, y, w, h);
		frame.add(addScroll(stre, x, y, w, h));
		
		x = (int)(width * .49);
		
		weak = createTextArea(x, y, w, h);
		frame.add(addScroll(weak, x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .45);

		oper = createTextArea(x, y, w, h);
		frame.add(addScroll(oper, x, y, w, h));
		
		x = (int)(width * .49);
		
		threat = createTextArea(x, y, w, h);
		frame.add(addScroll(threat, x, y, w, h));
		
		stre.setFont(font);
		oper.setFont(font);
		weak.setFont(font);
		threat.setFont(font);
		
	}
	
	public JTextArea createTextArea(int x, int y, int w, int h) {
		JTextArea text = new JTextArea();
		text.setBackground(Color.CYAN);
		text.setLineWrap(true);
        text.setWrapStyleWord(true);
		
        return text;
	}
	
	public JLabel createLabel(String text, int x, int y, int w, int h) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, w, h);
		label.setFont(new Font(label.getName(), Font.BOLD, fontSize(label, label.getText())));
		
		return label;
	}
	
	public JScrollPane addScroll(JTextArea text, int x, int y, int w, int h) {
		JScrollPane scroll = new JScrollPane(text);
		scroll.setBounds(x, y, w, h);
		
		return scroll;
	}
	
	public int fontSize(Component comp, String text) {
		Font textFont = comp.getFont();
		
		int stringWidth = comp.getFontMetrics(textFont).stringWidth(text);
		int componentWidth = comp.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(textFont.getSize() * widthRatio);
		int componentHeight = comp.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSize = Math.min(newFontSize, componentHeight);

		return fontSize;
	}

}