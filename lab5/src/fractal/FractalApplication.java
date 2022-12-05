package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);
		fractals[0] = new Mountain(new Point(200,500),new Point(400,500), new Point(100,100), 20);
	    new FractalView(fractals, "Fraktaler", 600, 600);

	}

}
