package mx.tc.j2se.evaluation;

public class Evaluation1 extends Circle {

    public int size;
    public int index;
    private Circle[] circleArray = new Circle[10];

    public static void biggestCircle(Circle[] circleArray) {
        Circle largest = circleArray[0];

        double max = 0;

        if (circleArray == null) {
            throw new IllegalArgumentException("error");
        }

        int index = 0; // store the index of circle

        for (int i = 0; i < circleArray.length; i++) {
            if (circleArray[i].getArea() > max) {
                max = circleArray[i].getArea();
                index = i;
            }
        }
        System.out.println("the biggest circle is in position: "+index);
        System.out.println("the circle radius is "+circleArray[index].getRadius());
        System.out.println("the circle area is: "+circleArray[index].getArea());


    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}




