package com.mauriciotogneri.obstacles.objects;

import android.graphics.Color;
import android.graphics.PointF;
import com.mauriciotogneri.obstacles.shapes.Polygon;
import com.mauriciotogneri.obstacles.shapes.Rectangle;

public class Background
{
	private final Rectangle base;

	private Polygon polygon1;
	private Polygon polygon2;
	private Polygon polygon3;
	private Polygon polygon4;
	
	private float x1;
	private float x2;
	private float x3;
	private float x4;

	private final Rectangle wallTop;
	private final Rectangle wallBottom;

	private static final int SHAPE_WIDTH = 40;
	private static final int SHAPE_SPACE = 30;
	private static final int WALL_HEIGHT = 5;
	
	private static final int COLOR_WALL = Color.argb(255, 90, 110, 120);
	
	// 255, 110, 110
	private static final int COLOR_BASE = Color.argb(255, 170, 160, 210);
	private static final int COLOR_SHAPES = Color.argb(255, 165, 155, 205);
	
	public Background(int width, int height)
	{
		this.base = new Rectangle(0, 0, width, height, Background.COLOR_BASE);

		this.wallTop = new Rectangle(0, height - Background.WALL_HEIGHT, width, Background.WALL_HEIGHT, Background.COLOR_WALL);
		this.wallBottom = new Rectangle(0, 0, width, Background.WALL_HEIGHT, Background.COLOR_WALL);

		createShapes(height);
	}

	public void update(float value)
	{
		this.x1 -= value;
		
		if ((this.x1 + Background.SHAPE_WIDTH) < 0)
		{
			this.x1 = (Background.SHAPE_WIDTH * 4) + (Background.SHAPE_SPACE * 4);
			this.polygon1.moveX(this.x1);
		}
		else
		{
			this.polygon1.moveX(-value);
		}

		this.x2 -= value;
		
		if ((this.x2 + Background.SHAPE_WIDTH) < 0)
		{
			this.x2 = (Background.SHAPE_WIDTH * 4) + (Background.SHAPE_SPACE * 4);
			this.polygon2.moveX(this.x2);
		}
		else
		{
			this.polygon2.moveX(-value);
		}
		
		this.x3 -= value;

		if ((this.x3 + Background.SHAPE_WIDTH) < 0)
		{
			this.x3 = (Background.SHAPE_WIDTH * 4) + (Background.SHAPE_SPACE * 4);
			this.polygon3.moveX(this.x3);
		}
		else
		{
			this.polygon3.moveX(-value);
		}

		this.x4 -= value;
		
		if ((this.x4 + Background.SHAPE_WIDTH) < 0)
		{
			this.x4 = (Background.SHAPE_WIDTH * 4) + (Background.SHAPE_SPACE * 4);
			this.polygon4.moveX(this.x4);
		}
		else
		{
			this.polygon4.moveX(-value);
		}
	}
	
	private void createShapes(int height)
	{
		this.x1 = 0;
		
		PointF[] points1 = new PointF[4];
		points1[0] = new PointF(this.x1, height / 2f);
		points1[1] = new PointF(Background.SHAPE_WIDTH / 2f, height / 4f);
		points1[2] = new PointF(Background.SHAPE_WIDTH / 2f, height * (3f / 4f));
		points1[3] = new PointF(Background.SHAPE_WIDTH, height / 2f);
		this.polygon1 = new Polygon(Background.COLOR_SHAPES, points1);

		this.x2 = Background.SHAPE_SPACE + Background.SHAPE_WIDTH;

		PointF[] points2 = new PointF[3];
		points2[0] = new PointF(this.x2, 0);
		points2[1] = new PointF(this.x2 + (Background.SHAPE_WIDTH / 2f), height / 2f);
		points2[2] = new PointF(this.x2 + Background.SHAPE_WIDTH, 0);
		this.polygon2 = new Polygon(Background.COLOR_SHAPES, points2);

		this.x3 = ((Background.SHAPE_SPACE * 2) + Background.SHAPE_WIDTH * 2);
		
		PointF[] points3 = new PointF[4];
		points3[0] = new PointF(this.x3, height);
		points3[1] = new PointF(this.x3 + (Background.SHAPE_WIDTH / 4f), height * (3f / 4f));
		points3[2] = new PointF(this.x3 + Background.SHAPE_WIDTH, height);
		points3[3] = new PointF(this.x3 + (Background.SHAPE_WIDTH * (3f / 4f)), height * (3f / 4f));
		this.polygon3 = new Polygon(Background.COLOR_SHAPES, points3);
		
		this.x4 = ((Background.SHAPE_SPACE * 3) + Background.SHAPE_WIDTH * 3);

		PointF[] points4 = new PointF[4];
		points4[0] = new PointF(this.x4, height * (3f / 4f));
		points4[1] = new PointF(this.x4, height / 4f);
		points4[2] = new PointF(this.x4 + Background.SHAPE_WIDTH, height * (3f / 4f));
		points4[3] = new PointF(this.x4 + Background.SHAPE_WIDTH, height / 4f);
		this.polygon4 = new Polygon(Background.COLOR_SHAPES, points4);
	}

	public void draw(int positionLocation, int colorLocation)
	{
		this.base.draw(positionLocation, colorLocation);

		this.polygon1.draw(positionLocation, colorLocation);
		this.polygon2.draw(positionLocation, colorLocation);
		this.polygon3.draw(positionLocation, colorLocation);
		this.polygon4.draw(positionLocation, colorLocation);
		
		this.wallTop.draw(positionLocation, colorLocation);
		this.wallBottom.draw(positionLocation, colorLocation);
	}
}