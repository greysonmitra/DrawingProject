package drawing.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.ArrayList;

public class ShapePanel
{
	private ArrayList<Rectangle> rectangleList;
	//more arraylists
	
	public ShapePanel()
	{
		rectangleList = new ArrayList<Rectangle>();
	}
	
	public void addRectangle()
	{
		rectangleList.add(new Rectangle(10, 20, 50, 10));
	}
	
	protected void paintComponents(Graphics currentGraphics)
	{
		//draw in here
	}
}
