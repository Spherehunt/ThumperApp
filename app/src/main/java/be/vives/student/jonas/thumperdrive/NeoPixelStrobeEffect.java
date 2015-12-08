package be.vives.student.jonas.thumperdrive;

/**
 * Created by Jonas on 1-12-2015.
 */
public class NeoPixelStrobeEffect {
    private int red;
    private int green;
    private int blue;
    private int delay;

    NeoPixelStrobeEffect(int r , int g,int b,int d){
        red = r;
        green = g;
        blue = b;
        delay = d;
    }

    NeoPixelStrobeEffect(){
        this(0,0,0,0);
    }
}
