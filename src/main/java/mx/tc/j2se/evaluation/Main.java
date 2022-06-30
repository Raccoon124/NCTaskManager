package mx.tc.j2se.evaluation;

import static mx.tc.j2se.evaluation.Evaluation1.biggestCircle;

public class Main {


    public static void main(String[] args) {


        Circle[] circles = {new Circle(40), new Circle(20), new Circle(5)};
        biggestCircle(circles);


    }


}
