package mx.tc.j2se.evaluation;

public class Circle {

    private int radius;
    private double area;

    public Circle() {
        this.radius = 1;
    }

    public Circle(int radius) {

        if (radius <= 0 ) {
            throw new IllegalArgumentException("the radius is not valid");
        }
        this.radius = radius;
    }

    public double getArea() {

        this.area = Math.PI * (this.radius * this.radius);
        return area;

    }
    public void setArea(double area) {
        this.area = area;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {

        if (radius <= 0) {
            throw new IllegalArgumentException("the radius was invalid");
        }
        this.radius = radius;
    }

}