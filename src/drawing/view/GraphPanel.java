package drawing.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
		
	public GraphPanel()
	{
		graphSource = new int[] {23, 15, 222, 3, 63, 4, 81};
		setupPanel();
		//initialize graphSource here
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.WHITE);
	}
		
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(int index = 0; index < graphSource.length; index++)
		{
			int height = this.getHeight()/graphSource.length;
			int width = graphSource[index];
			int xPosition = 0;
			int yPosition = height * index;
			
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(new Rectangle(xPosition, yPosition, width, height));
			
			
			//draw a rectangle for each value in the array
		}
	}
}

