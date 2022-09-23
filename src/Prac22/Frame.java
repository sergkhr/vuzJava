package Prac22;

import javax.swing.*;
import java.awt.*;
import  java.lang.*;

public class Frame extends JFrame {
    public Frame() {
        super("Frame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        //drawing panel
        //JPanel panel = new JPanel();
        Panel2 panel = new Panel2();
        panel.setBounds(0, 0, 600, 400);
        panel.setBackground(Color.WHITE);
        add(panel);
        //drawing
        Graphics g = panel.getGraphics();
        panel.paintComponent(g);
    }


    class Panel2 extends JPanel {

        Panel2() {
            // set a preferred size for the custom panel.
            //setPreferredSize(new Dimension(420,420));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for(int i = 0; i < 20; i++){
                int var = (int)(Math.random() * 3);
                switch (var){
                    case 0:
                        Rectangle rect = new Rectangle((int)(Math.random() * 600), (int)(Math.random() * 400), (int)(Math.random() * 50), (int)(Math.random() * 50));
                        rect.draw(g);
                        break;
                    case 1:
                        Circle circle = new Circle((int)(Math.random() * 600), (int)(Math.random() * 400), (int)(Math.random() * 50));
                        circle.draw(g);
                        break;
                    case 2:
                        Triangle triangle = new Triangle((int)(Math.random() * 600), (int)(Math.random() * 400), (int)(Math.random() * 50), (int)(Math.random() * 50));
                        triangle.draw(g);
                        break;
                }
            }
        }
    }
}

abstract class Shape{
    protected Color color;
    protected int x;
    protected int y;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public abstract void draw(Graphics g);
}
class Rectangle extends Shape{
    protected int width;
    protected int length;
    public Rectangle(){
        this.width = 1;
        this.length = 2;
        this.x = 0;
        this.y = 0;
    }
    public Rectangle(int x, int y, int width, int length){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }
    public Rectangle(int x, int y, int width, int length, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }
    public int getWidth(){
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getLength(){
        return this.length;
    }
    public void setLength(int length){
        this.length = length;
    }

    public String toString(){
        return "A shapeTask.Rectangle with width=" + this.width + " and length=" + this.length + ", which is a subclass of " + super.toString();
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.length);
    }
}
class Circle extends Shape{
    protected int radius;
    public Circle(){
        this.radius = 1;
        this.x = 0;
        this.y = 0;
    }
    public Circle(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }
    public Circle(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
    public int getRadius(){
        return this.radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public String toString(){
        return "A shapeTask.Circle with radius=" + this.radius + ", which is a subclass of " + super.toString();
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval(this.x, this.y, this.radius, this.radius);
    }
}
class Triangle extends Shape{
    protected int width;
    protected int height;
    public Triangle(){
        this.width = 1;
        this.height = 1;
        this.x = 0;
        this.y = 0;
    }
    public Triangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }
    public Triangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public int getWidth(){
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public String toString(){
        return "A shapeTask.Triangle with width=" + this.width + " and height=" + this.height + ", which is a subclass of " + super.toString();
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillPolygon(new int[]{this.x, this.x + this.width, this.x + this.width / 2}, new int[]{this.y, this.y, this.y + this.height}, 3);
    }
}
