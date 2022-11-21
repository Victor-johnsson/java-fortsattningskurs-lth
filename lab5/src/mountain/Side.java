package mountain;

public class Side {
    private Point one, two;
    public Side (Point one, Point two){
        this.one = one;
        this.two = two;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Side) {
            Side s = (Side) obj;

            if (s.getPointOne().equals(one) && s.getPointTwo().equals(two)) {
                return true;
            } else if (s.getPointOne().equals(two) && s.getPointTwo().equals(one)) {
                return true;
            }


        }
        return false;
    }

    public Point getPointOne(){
        return  one;
    }

    public void setTwo(Point two) {
        this.two = two;
    }

    public Point getPointTwo() {
        return two;
    }
    @Override
    public int hashCode(){
        return one.hashCode() + two.hashCode();
    }
}
