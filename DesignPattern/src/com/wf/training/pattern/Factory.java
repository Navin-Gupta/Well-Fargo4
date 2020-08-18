package com.wf.training.pattern;

interface Shape{
	void draw();
}

class Polygon implements Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Polygon drawn");
	}
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle drawn");
	}
}

class Circle implements Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle drawn");
	}
}


class ShapeFactory{
	// method to expose an object as per demand
	public Shape getShape(String type) {
		if(type.equals("circle")){
			return new Circle();
		}
		if(type.equals("polygon")){
			return new Polygon();
		}
		if(type.equals("rectangle")){
			return new Rectangle();
		}
		return null;
	}
}


public class Factory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory factory = new ShapeFactory();
		
		// demand and get in abstract way
		Shape polygonShape =  factory.getShape("polygon");
		polygonShape.draw();
		
	}

}
