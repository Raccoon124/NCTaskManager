package mx.tc.j2se.evaluation;


import static mx.tc.j2se.evaluation.Evaluation1.biggestCircle;

public class Main {


    public static void main(String[] args) {

        Circle circ = new Circle();
        circ.setRadius(2);
        System.out.println(circ.getRadius());
        System.out.println(circ.getArea());

        Circle[] circles = {new Circle(10), new Circle(210), new Circle(30)};
        biggestCircle(circles);

    }


}
