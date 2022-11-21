package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

import java.nio.channels.Pipe;
import java.util.HashMap;

public class Mountain extends Fractal {
    private HashMap<Side,Point> sides = new HashMap<>();
    private Point p1, p2, p3;
    private  double dev;
    public  Mountain(Point one, Point two, Point three, double dev){
        p1 = one;
        p2 = two;
        p3 = three;
        this.dev = dev;
    }
    @Override
    public String getTitle() {
        return "Mountain";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        fractalLine(turtle, order, p1, p2, p3);
    }
    public void fractalLine(TurtleGraphics turtle, int order, Point one, Point two, Point three){
        if(order == 0){
            turtle.moveTo(one.getX(),one.getY());
            turtle.penDown();

            turtle.forwardTo(two.getX(), two.getY());
            turtle.forwardTo(three.getX(), three.getY());
            turtle.forwardTo(one.getX(), one.getY());

        }else{
            Point p1 = middlePoint(one, two, dev /2);
            Point p2 = middlePoint(one,three, dev /2);
            Point p3 = middlePoint(two,three, dev /2);

            fractalLine(turtle, order-1, one, p1, p2);
            fractalLine(turtle, order-1, p1, two, p3);
            fractalLine(turtle, order-1, p1, p2, p3);
            fractalLine(turtle, order-1, p2, p3, three);


        }

    }
    public  Point middlePoint(Point one, Point two, double dev){

        Side side = new Side(one,two);
        if(sides.containsKey(side)){
            Point p1 = sides.get(side);
            sides.remove(side);
            return p1;

        }
        int x  = (one.getX() + two.getX())/2;
        int y = (int) ((one.getY() + two.getY()) / 2 + RandomUtilities.randFunc(dev));

        Point point = new Point(x,y);

        sides.put(side,point);

        return point;

    }
}
