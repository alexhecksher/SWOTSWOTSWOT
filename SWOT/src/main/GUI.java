package main;

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
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
	private JTextField desc;
	private JTextField value;
	
	private JLabel streL;
	private JLabel weakL;
	private JLabel oppoL;
	private JLabel threatL;
	private JLabel descL;
	private JLabel valueL;
	
	private JScrollPane streS;
	private JScrollPane weakS;
	private JScrollPane oppoS;
	private JScrollPane threatS;
	
	private JButton add;
	private JButton go;
	
	private JComboBox<String> swot;
	
	private final Font defFont = new Font("Verdana", Font.PLAIN, 22);
	
	private int x,y,w,h;
	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	
	CustomFocusPolicy cfp;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.getFrame().addComponentListener(new ComponentAdapter() {
			            public void componentResized(ComponentEvent e) {
			                window.update();
			            }
			        });
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
		update();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("SWOT");
		frame.setBounds(100, 100, width, height);
		
		stre = new JTextArea();
		weak = new JTextArea();
		oppo = new JTextArea();
		threat = new JTextArea();
		
		streL = new JLabel("Strength");
		weakL = new JLabel("Weak");
		oppoL = new JLabel("Opportunity");
		threatL = new JLabel("Threat");
		
		descL = new JLabel();
		desc = new JTextField();
		
		swot = new JComboBox<String>();
		swot.addItem("S");
		swot.addItem("W");
		swot.addItem("O");
		swot.addItem("T");
		
		valueL = new JLabel("Value");
		value = new JTextField();
		
		add = new JButton("Add");
		
		go = new JButton("Go");
	}
	
	public void update() {		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		width = frame.getContentPane().getWidth();
		height = frame.getContentPane().getHeight();
		
		dim(.02,.07,.47,.29);
		
		createTextArea(stre, x, y, w, h);
		frame.add(stre);
		
		x = (int)(width * .51);
		
		createTextArea(weak, x, y, w, h);
		frame.add(weak);
		
		x = (int)(width * .02);
		y = (int)(height * .43);
		
		createTextArea(oppo, x, y, w, h);
		frame.add(oppo);
		
		x = (int)(width * .51);
		
		createTextArea(threat, x, y, w, h);
		frame.add(threat);
		
		dim(.02,.02,.47,.05);
		
		createLabel(streL, x, y, w, h);
		frame.add(streL);
		
		x = (int)(width * .51);
		
		createLabel(weakL, x, y, w, h);
		frame.add(weakL);
		
		x = (int)(width * .02);
		y = (int)(height * .38);
		
		createLabel(oppoL, x, y, w, h);
		frame.add(oppoL);
		
		x = (int)(width * .51);
		
		createLabel(threatL, x, y, w, h);
		frame.add(threatL);
		
		dim(.17,.74,.81,.04);
		
		createLabel(descL, x, y, w, h);
		descL.setHorizontalAlignment(JLabel.LEFT);
		frame.add(descL);
				
		dim(.17,.78,.81,.11);
		
		desc.setBounds(x, y, w, h);
		desc.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					addAction();
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					swot.requestFocus();
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		desc.setFont(defFont);
		frame.add(desc);
		
		dim(.02,.78,.09,.05);
		
		swot.setBounds(x, y, w, h);
		swot.setFont(defFont);
		swot.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					addAction();
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		frame.add(swot);
		
		dim(.02,.84,.09,.05);
		
		createLabel(valueL, x, y, w, h);
		frame.add(valueL);
		
		dim(.11,.84,.05,.05);
		
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
		
        add.setFont(defFont);
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
        
        go.setFont(defFont);
        go.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	Logic result = new Logic(ideas);
                	//JOptionPane.showMessageDialog(frame, result.getResults());
                	JFrame resultFr = new JFrame("Results");
            		resultFr.setBounds(width / 2, height / 2, width / 2, height / 3);
            		resultFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            		resultFr.getContentPane().setLayout(null);
            		
            		resultFr.setVisible(true);
            		int rWidth = resultFr.getContentPane().getWidth();
            		int rHeight = resultFr.getContentPane().getHeight();
            		
            		JTextArea resultText = new JTextArea();
            		createTextArea(resultText, 0, 0, rWidth, rHeight);
            		resultText.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            		resultText.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
            		resultText.setCaretPosition((int)JTextArea.CENTER_ALIGNMENT);
            		resultText.setText(result.getResults());
            		resultFr.add(resultText);
            		resultFr.setVisible(true);
                }
            });
        go.setBounds(x, y, w, h);
        frame.add(go);
        
        Vector<Component> order = new Vector<Component>(3);
        order.add(swot);
        order.add(value);
        order.add(desc);
        cfp = new CustomFocusPolicy(order);
        frame.setFocusTraversalPolicy(cfp);
        
	}
	
	private void createTextArea(JTextArea text, int x, int y, int w, int h) {
		text.setBounds(x, y, w, h);
		text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        text.setFont(defFont);
	}
	
	private JLabel createLabel(JLabel label, int x, int y, int w, int h) {
		label.setBounds(x, y, w, h);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font(label.getName(), Font.PLAIN, fontSize(label, label.getText())));
		
		return label;
	}
	
	/*private JScrollPane addScroll(JTextArea text, int x, int y, int w, int h) {
		JScrollPane scroll = new JScrollPane(text);
		scroll.setBounds(x, y, w, h);
		
		return scroll;
	}*/
	
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
        	if(!Character.isDigit(temp)) return -1;
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
    	descStr = descStr.trim();
    	int val = toNum(value.getText());
    	if(swot.getSelectedItem() instanceof String && descStr.length() > 0 && val > 0) {
        	String swotVal = (String)swot.getSelectedItem();
        	Idea tempIdea = new Idea(swotVal, descStr, val);
        	ideas.add(tempIdea);
        	if(swotVal.equals("S")) {
        		stre.setText(stre.getText() + descStr + '\t');
        	}
        	else if(swotVal.equals("W")) {
        		weak.setText(weak.getText() + descStr + '\t');
        	}
        	else if(swotVal.equals("O")) {
        		oppo.setText(oppo.getText() + descStr +'\t');
        	}
        	else {
        		threat.setText(threat.getText() + descStr + '\t');
        	}
    	}
    	desc.setText("");
    	value.setText("");
    	swot.requestFocus();
	}
	
	public JFrame getFrame() {
		return frame;
	}
}