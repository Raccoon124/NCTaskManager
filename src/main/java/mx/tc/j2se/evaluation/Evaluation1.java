package mx.tc.j2se.evaluation;

public class Evaluation1 extends Circle {

    public static void main(String[] args) {

        Circle[] cirArray = {new Circle(10), new Circle(15), new Circle(18)};
        for (int i = 0; i < 3; i++) {
            System.out.println(cirArray[i].getRadius());

            Evaluation1 eval  = new Evaluation1();

            eval.biggestCircle(cirArray[i].getRadius());

        }
    }

    public int biggestCircle(int index) {

        return index;
    }
}
