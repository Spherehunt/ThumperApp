package be.vives.student.jonas.thumperdrive;



/**
 * Created by Jonas on 23-11-2015.
 */
public class NeoPixelColorEffect {
    private int red;
    private int green;
    private int blue;



    NeoPixelColorEffect(int r , int g,int b){
        red = r;
        green = g;
        blue = b;
    }

    NeoPixelColorEffect(){
        this(0,0,0);
    }
}

