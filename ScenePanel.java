import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

import java.util.*;

/**
   A component that shows a scene composed of shapes.
*/
public class ScenePanel extends javax.swing.JPanel {

   private ArrayList<SceneShape> shapes;
   private ArrayList<SceneShape> tempShape; 
   private Color color = Color.black; 
   private Point mousePoint;
   ButtonPanel buttonPanel; 
	   
   public ScenePanel() {
      shapes = new ArrayList<SceneShape>();
      tempShape = new ArrayList<SceneShape>(); 

      addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
             // figure out which shape did the mouse click on
            	mousePoint = event.getPoint();
               for (SceneShape s: shapes) {
                  if (s.contains(mousePoint) && s.isSelected() == false) { 
                	  //selected shape is painted black ..check draw method
                     //s.setSelected(!s.isSelected());
                     //index = shapes.indexOf(s);
                     tempShape.add(s);
                     s.setSelected(true);
                  }
                  else {
                	tempShape.removeAll(shapes);
                	s.setSelected(false);
                  }
               }
               repaint();
            }
      });

      addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent event){
               Point lastMousePoint = mousePoint;
               mousePoint = event.getPoint();
               Iterator it = shapes.iterator();
               while  (it.hasNext()) { //you can select and move more than one shape.. need to iterate through all shapes
            	   SceneShape  s = (SceneShape) it.next();
            	   if (s.isSelected()) { //if shape is selected
            		   // calculate distance for dragging
            		   double dx = mousePoint.getX() - lastMousePoint.getX();
            		   double dy = mousePoint.getY() - lastMousePoint.getY();
            		   s.translate((int) dx, (int) dy);
            	   }
               	}
               repaint();
            }
         });
   }

   /**
      Adds a shape to the scene.
      @param s the shape to add
   */
   public void add(SceneShape s) {
      shapes.add(s);
      repaint();
   }

   /**
      Removes all selected shapes from the scene.
   */
   public void removeSelected() { //iterate to remove shape from list
      for (int i = shapes.size() - 1; i >= 0; i--) {
         SceneShape s = shapes.get(i);
         if (s.isSelected()) shapes.remove(i);
      }
      repaint();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      for (SceneShape s: shapes) { //iterate to draw all shapes.
    	  g2.setColor(Color.black);
    	  s.draw(g2);
    	  if (s.isSelected()){ //this code should move to the draw method !
        	g2.setColor(color);
        	s.draw(g2);
            s.drawSelection(g2);
         }
      }
      repaint(); 
    	
   }
   
   public ArrayList<SceneShape> getShapes() { 
	   return tempShape;
   }
   
   public void setColor(Color color) {
	   this.color = color; 
   }
}
