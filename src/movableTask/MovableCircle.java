package movableTask;

public class MovableCircle implements Movable{
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	public void moveUp(){
		this.center.moveUp();
	}
	public void moveDown(){
		this.center.moveDown();
	}
	public void moveLeft(){
		this.center.moveLeft();
	}
	public void moveRight(){
		this.center.moveRight();
	}

	public String toString(){
		return "x: " + this.center.x + " y: " + this.center.y + " xSpeed: " + this.center.xSpeed + " ySpeed: " + this.center.ySpeed + " radius: " + this.radius;
	}
}
