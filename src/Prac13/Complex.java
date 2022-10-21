package Prac13;

public class Complex {
    int real;
    int image;
    public Complex() {
        this.real = 0;
        this.image = 0;
    }
    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }
    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", image=" + image +
                '}';
    }
}
