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
	private GraphPanel graphPanel;
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
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 46, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 55, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -45, SpringLayout.EAST, this);
		graphPanel = new GraphPanel();
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 552, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -36, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -46, SpringLayout.EAST, this);
		
		rectangleList = new ArrayList<Rectangle>();
		drawRectangleButton = new JButton("Draw rectangle");
		baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangleButton, -36, SpringLayout.SOUTH, this);
		drawSquareButton = new JButton("make a square");
		baseLayout.putConstraint(SpringLayout.EAST, drawSquareButton, -123, SpringLayout.WEST, graphPanel);
		drawTriangleButton = new JButton("make a triangle");
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 0, SpringLayout.WEST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawTriangleButton, -22, SpringLayout.NORTH, drawSquareButton);
		drawEllipseButton = new JButton("make a ellipse");
		baseLayout.putConstraint(SpringLayout.SOUTH, drawEllipseButton, -36, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, -48, SpringLayout.WEST, drawEllipseButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawEllipseButton, -428, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 40, SpringLayout.EAST, drawEllipseButton);
		drawPolygonButton = new JButton("make a polygon");
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 49, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawSquareButton, -6, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawPolygonButton, -31, SpringLayout.NORTH, drawRectangleButton);
		drawCircleButton = new JButton("make a circle");
		baseLayout.putConstraint(SpringLayout.NORTH, drawCircleButton, 0, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 0, SpringLayout.WEST, drawEllipseButton);
		clearButton = new JButton("CLEAR");
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, -45, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -25, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, -17, SpringLayout.NORTH, graphPanel);
		
		
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
		this.add(graphPanel);
		this.add(drawSquareButton);
		this.add(drawTriangleButton);								//Height based on value of array. The width constant, xPos is width*index, and xPos is 10 (or 50 or 100) 
		this.add(drawEllipseButton);								//make in GraphPanel (for inheritance project) class.
		this.add(drawPolygonButton);
		this.add(drawCircleButton);
		this.add(clearButton);
	}
	
	public void setupLayout()
	{
		
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
