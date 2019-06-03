package test1;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Transform;

public class SquareModel extends Model {

    public SquareModel(Transform transform, Asset asset) {
        super(transform, asset);

    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
        transform.shiftPhase(0,vy);
    }

    private int vy=0;
    public void askedDown(){
        vy=1;
    }
    public void askedVerticalStop(){
        vy=0;
    }
}
