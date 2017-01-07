import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class ButtonPanel extends javax.swing.JPanel {
	
	private Color color = Color.black;
	private ArrayList<SceneShape> tempShape; 
	
	public ButtonPanel(final ScenePanel scene){
		super();
    	setLayout(new BorderLayout());
    	
		GridLayout buttonGrid = new GridLayout(1, 3); 
		JPanel buttonPanel = new JPanel(buttonGrid); 
		JPanel radioPanel = new JPanel(); 
		ButtonGroup buttonGroup = new ButtonGroup(); 
		
		JRadioButton blueButton = new JRadioButton("Blue"); 
		JRadioButton redButton = new JRadioButton("Red");
		JRadioButton yellowButton = new JRadioButton("Yellow");
		
		buttonGroup.add(blueButton);
		buttonGroup.add(redButton);
		buttonGroup.add(yellowButton);
		
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						scene.getShapes(); 
						scene.setColor(Color.blue);
			}
		});
		
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					scene.getShapes();
					scene.setColor(Color.red); 
			}
		});
		
		yellowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					scene.getShapes();
					scene.setColor(Color.yellow); 
			}
		});
		
		JButton houseButton = new JButton("House");
		houseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					scene.add(new HouseShape(20, 20, 50));
				}
	    });

		JButton carButton = new JButton("Car");
		carButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					scene.add(new CarShape(20, 20, 50));
	              }
	    });

		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	scene.removeSelected();
	            }
	    });
	        
		buttonPanel.add(houseButton);
	    buttonPanel.add(carButton);
	    buttonPanel.add(removeButton);
	    radioPanel.add(blueButton);
	    radioPanel.add(redButton);
	    radioPanel.add(yellowButton);
	    
	    this.add(buttonPanel);
	    this.add(radioPanel, BorderLayout.NORTH);
	}
	
	public Color getColor() { 
		return color; 
	}
}
  