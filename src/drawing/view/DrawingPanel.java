package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import drawing.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private DrawingPanel basePanel;
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	private ArrayList<Rectangle> rectangleList;
	
	
	public DrawingPanel(DrawingController baseController)
	
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		rectangleList = new ArrayList<Rectangle>();
		drawRectangleButton = new JButton("Draw rectangle");
		
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.add(drawRectangleButton);
		this.setLayout(baseLayout);
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 500));
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 52, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangleButton, -184, SpringLayout.SOUTH, this);
	}
	
	public void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 600);
				int yPosition = (int)(Math.random() * 600);
				int width = (int)(Math.random() * 50);
				int height = (int)(Math.random() * 50);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponents(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.GREEN);
		mainGraphics.setStroke(new BasicStroke(15));
		mainGraphics.draw(new Rectangle(90, 10, 20, 40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		
		}
	}
}
