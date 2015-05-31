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
	private JLabel swotLabel;
	private JLabel sLabel;
	private JLabel wLabel;
	private JLabel oLabel;
	private JLabel tLabel;
	private JTextArea stren;
	private JTextArea weak;
	private JTextArea oper;
	private JTextArea threat;
	private JTextArea desc;
	private JButton add;
	private JButton go;
	private JComboBox swot;
	private JScrollPane scrollS;
	private JScrollPane scrollW;
	private JScrollPane scrollO;
	private JScrollPane scrollT;

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
		
		stren = new JTextArea();
		stren.setBackground(Color.CYAN);
		scrollS = new JScrollPane(stren);
		scrollS.setBounds(x, y, w, h);
		frame.add(scrollS);
		
		x = (int)(width * .49);
		
		weak = new JTextArea();
		weak.setBounds(x, y, w, h);
		weak.setBackground(Color.CYAN);
		scrollW = new JScrollPane(weak);
		scrollW.setBounds(x, y, w, h);
		frame.add(scrollW);
		
		x = (int)(width * .02);
		y = (int)(height * .45);
		
		oper = new JTextArea();
		oper.setBounds(x, y, w, h);
		oper.setBackground(Color.CYAN);
		scrollO = new JScrollPane(oper);
		scrollO.setBounds(x, y, w, h);
		frame.add(scrollO);
		
		x = (int)(width * .49);
		
		threat = new JTextArea();
		threat.setBounds(x, y, w, h);
		threat.setBackground(Color.CYAN);
		scrollT = new JScrollPane(threat);
		scrollT.setBounds(x, y, w, h);
		frame.add(scrollT);
			
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
