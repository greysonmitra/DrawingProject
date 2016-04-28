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
	private JButton drawPolygonButton;
	private JButton drawSquareButton;
	private JButton drawCircleButton;
	private JButton drawEllipseButton;
	private JButton drawTriangleButton;
	private JButton clearButton;
	private ArrayList<Rectangle> rectangleList;
	
	
	public DrawingPanel(DrawingController baseController)
	
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		
		rectangleList = new ArrayList<Rectangle>();
		drawRectangleButton = new JButton("Draw rectangle");
		drawSquareButton = new JButton("make a square");
		drawTriangleButton = new JButton("make a triangle");
		drawEllipseButton = new JButton("make a ellipse");
		drawPolygonButton = new JButton("make a polygon");
		drawCircleButton = new JButton("make a circle");
		clearButton = new JButton("CLEAR");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.add(drawRectangleButton);
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(800, 800));
		this.add(shapePanel);
		this.add(drawSquareButton);
		this.add(drawTriangleButton);								//Height based on value of array. The width constant, xPos is width*index, and xPos is 10 (or 50 or 100) 
		this.add(drawEllipseButton);								//make in GraphPanel (for inheritance project) class.
		this.add(drawPolygonButton);
		this.add(drawCircleButton);
		this.add(clearButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 350, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawEllipseButton, 0, SpringLayout.EAST, drawCircleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawCircleButton, 13, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 59, SpringLayout.EAST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 52, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 54, SpringLayout.SOUTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 0, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 41, SpringLayout.SOUTH, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 52, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, 0, SpringLayout.EAST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 6, SpringLayout.SOUTH, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 13, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.WEST, drawSquareButton, 158, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, drawSquareButton);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, 0, SpringLayout.EAST, shapePanel);
		
	}
	
	public void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			/*	int xPosition = (int)(Math.random() * 600);
				int yPosition = (int)(Math.random() * 600);
				int width = (int)(Math.random() * 50);
				int height = (int)(Math.random() * 50);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));   */
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});
		
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
		
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
		
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
			}
		});
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
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
