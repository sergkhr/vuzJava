package Prac13;

public interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int image);

    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        Complex complex = factory.createComplex();
        System.out.println(complex);
        Complex complex2 = factory.createComplex(1, 2);
        System.out.println(complex2);
    }
}
