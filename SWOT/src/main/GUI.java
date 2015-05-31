package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

public class GUI {

	private int width = 1000;
	private int height = 1000;
	private JFrame frame;
	private JTextArea stre;
	private JTextArea weak;
	private JTextArea oppo;
	private JTextArea threat;
	private JTextArea desc;
	private JTextField value;
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
					//window.frame.setVisible(true);
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
		frame = new JFrame("SWOT");
		frame.setBounds(0, 0, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		width = frame.getContentPane().getWidth();
		height = frame.getContentPane().getHeight();
		
		dim(.02,.07,.47,.29);
		
		stre = createTextArea(x, y, w, h);
		frame.add(addScroll(stre, x, y, w, h));
		
		x = (int)(width * .51);	
		
		weak = createTextArea(x, y, w, h);
		frame.add(addScroll(weak, x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .43);
		
		oppo = createTextArea(x, y, w, h);
		frame.add(addScroll(oppo, x, y, w, h));
		
		x = (int)(width * .51);
		
		threat = createTextArea(x, y, w, h);
		frame.add(addScroll(threat, x, y, w, h));
		
		dim(.02,.02,.47,.05);
		
		frame.add(createLabel("Stengths", x, y, w, h));
		
		x = (int)(width * .51);
		
		frame.add(createLabel("Weaknesses", x, y, w, h));
		
		x = (int)(width * .02);
		y = (int)(height * .38);
		
		frame.add(createLabel("Opportunities", x, y, w, h));
		
		x = (int)(width * .51);
		
		frame.add(createLabel("Threats", x, y, w, h));
		
		dim(.02,.74,.81,.04);
		
		JLabel descLb = createLabel("Description", x, y, w, h);
		descLb.setHorizontalAlignment(JLabel.LEFT);
		frame.add(descLb);
				
		dim(.02,.78,.81,.11);
		
		desc = createTextArea(x, y, w, h);
		desc.setEditable(true);
		frame.add(addScroll(desc, x, y, w, h));
		
		dim(.84,.78,.09,.05);
		
		swot = new JComboBox<String>();
		swot.setBounds(x, y, w, h);
		swot.addItem("S");
		swot.addItem("W");
		swot.addItem("O");
		swot.addItem("T");
		frame.add(swot);
		
		dim(.84,.84,.09,.05);
		
		frame.add(createLabel("Value", x, y, w, h));
		
		dim(.93,.84,.05,.05);
		
		value = new JTextField();
		value.setBounds(x, y, w, h);
		value.setHorizontalAlignment(JTextField.CENTER);
		value.setFont(new Font(value.getName(), Font.PLAIN, fontSize(value, value.getText())));
		value.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					addAction();
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		frame.add(value);
		
		dim(.02, .93, .18, .05);
		
		add = new JButton("Add");
        add.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	addAction();
                }
            });
        add.setBounds(x, y, w, h);
        frame.add(add);
		
        x = (int)(width * .63);
        
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
        frame.add(go);
        
        Vector<Component> order = new Vector<Component>(3);
        order.add(swot);
        order.add(desc);
        order.add(value);//        frame.setFocusTraversalPolicy(policy);
        
	}
	
	private JTextArea createTextArea(int x, int y, int w, int h) {
		JTextArea text = new JTextArea();
		text.setBounds(x, y, w, h);
		//text.setBackground(Color.CYAN);
		text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        text.setFont(new Font("Verdana", Font.PLAIN, 28));
        //text.setForeground(Color.ORANGE);
		
        return text;
	}
	
	private JLabel createLabel(String text, int x, int y, int w, int h) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, w, h);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font(label.getName(), Font.PLAIN, fontSize(label, label.getText())));
		
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
        	char temp = str.charAt(i);
        	if(Character.isLetter(temp)) return -1;
            num = num + (temp - 48);
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
	
	public void addAction() {
    	String descStr = desc.getText();
    	int val = toNum(value.getText());
    	if(swot.getSelectedItem() instanceof String && descStr.length() > 0 && val != -1) {
        	String swotVal = (String)swot.getSelectedItem();
        	Idea tempIdea = new Idea(swotVal, descStr, val);
        	ideas.add(tempIdea);
        	desc.setText("");
        	value.setText("");
        	descStr += "\t\t";
        	if(swotVal.equals("S")) {
        		stre.setText(stre.getText() + descStr);
        	}
        	else if(swotVal.equals("W")) {
        		weak.setText(weak.getText() + descStr);
        	}
        	else if(swotVal.equals("O")) {
        		oppo.setText(oppo.getText() + descStr);
        	}
        	else {
        		threat.setText(threat.getText() + descStr);
        	}
    	}
    }
	

}