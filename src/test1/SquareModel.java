package test1;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Service;
import takenocco2.Transform;

import java.awt.event.KeyEvent;
import java.util.Random;

public class SquareModel extends Model {
    private Random random;
    private int vx=0;
    private int vy=0;
    private double omega=0.0;
    private double inithalTheta=0.0;
    public int step=0;

    public SquareModel(Transform transform, Asset asset) {
        super(transform, asset);
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public void start() {
        random=new Random();
        vx=random.nextInt(5)-2;
        vy=random.nextInt(5)-2;
        inithalTheta=random.nextDouble()*6.28;
        omega=random.nextDouble()*0.2;
    }

    @Override
    public void update() {
        step++;

        //キーボード処理の例
        boolean enterPressing=Service.inst().isPressing(KeyEvent.VK_ENTER);
        if(enterPressing){
            transform.shiftPhase(vx,vy);
        }
    }

    public double getTheta(){
        return inithalTheta+step*omega;
    }

}
