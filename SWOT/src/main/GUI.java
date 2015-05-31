package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

	private final int width = 1000;
	private final int height = 1000;
	private JFrame frame;
	private JTextArea stre;
	private JTextArea weak;
	private JTextArea oper;
	private JTextArea threat;
	private JTextArea desc;
	private JTextArea value;
	private JButton add;
	private JButton go;
	private JComboBox<String> swot;
	
	private int x,y,w,h;
	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	
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
		x = 0;
		y = 0;
		w = 0;
		h = 0;
		
		frame = new JFrame();
		frame.setBounds(0, 0, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		dim(.33,.02,.33,.1);
		
		frame.add(createLabel("SWOT", x, y, w, h));
		
		y = (int)(height * .76);
		
		frame.add(createLabel("Input", x, y, w, h));
		
		dim(.02,.18,.45,.25);
		
		stre = createTextArea(x, y, w, h);
		frame.add(addScroll(stre, x, y, w, h));
		
		x = (int)(width * .49);
		
		weak = createTextArea(x, y, w, h);
		frame.add(addScroll(weak, x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .5);

		oper = createTextArea(x, y, w, h);
		frame.add(addScroll(oper, x, y, w, h));
		
		x = (int)(width * .49);
		
		threat = createTextArea(x, y, w, h);
		frame.add(addScroll(threat, x, y, w, h));
		
		dim(.02,.13,.45,.05);
		
		frame.add(createLabel("Stengths", x, y, w, h));
		
		x = (int)(width * .49);
		
		frame.add(createLabel("Weaknesses", x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .45);
		
		frame.add(createLabel("Opportunities", x, y, w, h));
		
		x = (int)(width * .49);
		
		frame.add(createLabel("Threats", x, y, w, h));
		
		dim(.02,.87,.09,.05);
				
		swot = new JComboBox<String>();
		swot.setBounds(x, y, w, h);
		swot.addItem("S");
		swot.addItem("W");
		swot.addItem("O");
		swot.addItem("T");
		frame.add(swot);
		
		x = (int)(width * .12);
		w = (int)(width * .18);
		
		frame.add(createLabel("Description", x, y, w, h));
		
		dim(.3,.87,.54,.15);
		
		desc = createTextArea(x, y, w, h);
		frame.add(addScroll(desc, x, y, w, h));
		
		dim(.85,.87,.09,.05);
		
		value = createTextArea(x, y, w, h);
		frame.add(value);
		
		x = (int)(width * .02);
		y = (int)(height * .93);
		
		
		add = new JButton("Add");
        add.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	Idea temp = new Idea((String)swot.getSelectedItem(), desc.getText(), toNum(value.getText()));
                	ideas.add(temp);
                	desc.setText("");
                	value.setText("");
                }
            });
        add.setBounds(x, y, w, h);
        add.setBackground(Color.ORANGE);
        add.setForeground(Color.BLUE);
        frame.add(add);
		
        y = height;
        
        go = new JButton("Go");
        go.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	Logic result = new Logic(ideas);
                	JOptionPane.showMessageDialog(frame, result.getResults());
                }
            });
        go.setBounds(x, y, w, h);
        go.setBackground(Color.ORANGE);
        go.setForeground(Color.BLUE);
        frame.add(go);
	}
	
	private JTextArea createTextArea(int x, int y, int w, int h) {
		JTextArea text = new JTextArea();
		text.setBounds(x, y, w, h);
		text.setBackground(Color.CYAN);
		text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Verdana", Font.PLAIN, 13));
		
        return text;
	}
	
	private JLabel createLabel(String text, int x, int y, int w, int h) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, w, h);
		label.setFont(new Font(label.getName(), Font.BOLD, fontSize(label, label.getText())));
		
		return label;
	}
	
	private JScrollPane addScroll(JTextArea text, int x, int y, int w, int h) {
		JScrollPane scroll = new JScrollPane(text);
		scroll.setBounds(x, y, w, h);
		
		return scroll;
	}
	
	private int fontSize(Component comp, String text) {
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
	
	private int toNum(String str) {
		int num = 0;
        for(int i = 0; i < str.length(); i++)
        {
            num = num + (str.charAt(i) - 48);
            num *= 10;
        }
        return num / 10;
	}
	
	private void dim(double xVal, double d, double e, double f) {
		x = (int)(width*xVal);
		y = (int)(height*d);
		w = (int)(width*e);
		h = (int)(height*f);
	}

}