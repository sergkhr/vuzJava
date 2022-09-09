package movableTask;

class MovableRectangle implements Movable{
	private MovablePoint topLeft;
	private MovablePoint bottomRight;

	public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed){
		this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
		this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
		//well this two points will have the same speed
	}

	public void moveUp(){
		this.topLeft.moveUp();
		this.bottomRight.moveUp();
	}
	public void moveDown(){
		this.topLeft.moveDown();
		this.bottomRight.moveDown();
	}
	public void moveLeft(){
		this.topLeft.moveLeft();
		this.bottomRight.moveLeft();
	}
	public void moveRight(){
		this.topLeft.moveRight();
		this.bottomRight.moveRight();
	}

	public String toString(){
		return "x1: " + this.topLeft.x + " y1: " + this.topLeft.y + " x2: " + this.bottomRight.x + " y2: " + this.bottomRight.y + " xSpeed: " + this.topLeft.xSpeed + " ySpeed: " + this.topLeft.ySpeed;
	}
}

