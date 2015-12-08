package be.vives.student.jonas.thumperdrive;

/**
 * Created by Jonas on 1-12-2015.
 */
public class SpeedEffect {

    int left_speed;
    int right_speed;

    SpeedEffect(int left, int right){
        this.left_speed = left;
        this.right_speed = right;
    }
    SpeedEffect(){
        this(0,0);
    }
}
