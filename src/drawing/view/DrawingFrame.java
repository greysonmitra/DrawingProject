package drawing.view;

import javax.swing.*;

import drawing.controller.*;

import java.awt.Color;
import java.awt.Graphics2D;


public class DrawingFrame extends JFrame
{
	
	private DrawingController baseController;
	private DrawingPanel basePanel;
	
		
	public DrawingFrame(DrawingController baseController)
	{
	
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
		
	private void setupFrame()
	{
		this.setContentPane(basePanel); 
		this.setSize(800,800); 			
		this.setTitle("Drawing and Graphics");
		this.setResizable(false);       
		this.setVisible(true);		    
	} 
	
	
	
		
	public DrawingController getBaseController()
	{
		return baseController;
	}
}


