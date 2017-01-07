import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A program that allows users to edit a scene composed
   of items.
*/
public class SceneEditor extends JFrame
{
    public SceneEditor(){
    	super();
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	final ScenePanel scene = new ScenePanel();

      
        ButtonPanel buttons = new ButtonPanel(scene);
     

        add(scene, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setSize(500, 500);
        setVisible(true);
        setResizable(false);

    }
	public static void main(String[] args)
   {
       new SceneEditor();

     }
}


