package test3;

import takenocco2.Asset;
import takenocco2.Scene;
import takenocco2.Service;

import java.awt.*;

public class Test3Scene extends Scene {
    public Test3Scene() {
        super(Service.inst().getCntSize());
    }

    @Override
    public void buildPrimaryAssets() {
        Asset car1=new CarAsset();
        car1.transform.setInitialPhase(new Point(200,200));
        addAsset(car1);
        callStartToAllModels();
    }
}
