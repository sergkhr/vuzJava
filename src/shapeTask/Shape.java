package shapeTask;

public abstract class Shape {
	protected String color;
	protected boolean filled;

	public Shape() {
		this.color = "green";
		this.filled = true;
	}

	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return this.filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public String toString() {
		return "A shapeTask.Shape with color of " + this.color + " and " + (this.filled ? "filled" : "not filled");
	}

	public abstract double getArea();

	public abstract double getPerimeter();

	public static void ShapeTest(){
		//commented lines are with errors
		Shape s1 = new Circle(5.5, "RED", false); // Upcast shapeTask.Circle to shapeTask.Shape
		System.out.println(s1); // which version?
		System.out.println(s1.getArea()); // which version?
		System.out.println(s1.getPerimeter()); // which version?
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		//System.out.println(s1.getRadius()); //no radius in shape
		Circle c1 = (Circle)s1; // Downcast back to shapeTask.Circle
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());
		//shapeTask.Shape s2 = new shapeTask.Shape(); //shape is abstract
		Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		//System.out.println(s3.getLength()); //s3 is shape, no length in shape
		Rectangle r1 = (Rectangle)s3; // downcast
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength());
		Shape s4 = new Square(6.6); // Upcast
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		//System.out.println(s4.getSide()); no side in shape
		// Take note that we downcast shapeTask.Shape s4 to shapeTask.Rectangle,
		// which is a superclass of shapeTask.Square, instead of shapeTask.Square
		Rectangle r2 = (Rectangle)s4;
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
		//System.out.println(r2.getSide()); //no get side in rectangle
		System.out.println(r2.getLength());
		// Downcast shapeTask.Rectangle r2 to shapeTask.Square
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide());
		System.out.println(sq1.getLength());
	}
}


class Circle extends Shape {
	protected double radius;

	public Circle() {
		this.radius = 1.0;
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled); // call the parent constructor
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public String toString() {
		return "A shapeTask.Circle with radius=" + this.radius + ", which is a subclass of " + super.toString();
	}
}


class Rectangle extends Shape{
	protected double width;
	protected double length;

	public Rectangle() {
		this.width = 1.0;
		this.length = 2.0;
	}

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return this.width * this.length;
	}

	@Override
	public double getPerimeter() {
		return 2 * (this.width + this.length);
	}

	@Override
	public String toString() {
		return "A shapeTask.Rectangle with width=" + this.width + " and length=" + this.length + ", which is a subclass of " + super.toString();
	}
}


class Square extends Rectangle{
	public Square() {
		super(1.0, 1.0);
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return this.width;
	}

	public void setSide(double side) {
		this.width = side;
		this.length = side;
	}

	@Override
	public void setWidth(double side) {
		this.setSide(side);
	}

	@Override
	public void setLength(double side) {
		this.setSide(side);
	}

	@Override
	public String toString() {
		return "A shapeTask.Square with side=" + this.width + ", which is a subclass of " + super.toString();
	}
}
