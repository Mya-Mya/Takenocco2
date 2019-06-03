package test2;

import takenocco2.Asset;
import takenocco2.Scene;
import takenocco2.Transform;

import java.awt.*;

public class Test2Scene extends Scene {
    public Test2Scene(Dimension sheetSize) {
        super(sheetSize);

    }

    @Override
    public void buildPrimaryAssets() {
        Asset sun=new SunAsset();
        Asset earth=new EarthAsset();
        Asset moon=new MoonAsset();
        Asset moover=new CameraMoover();
        addAsset(sun);
        addAsset(earth);
        addAsset(moon);
        addAsset(moover);

        sun.transform.setInitialPhase(new Point(500,500));
        sun.transform.addChild(earth.transform);
        earth.transform.addChild(moon.transform);

        cameraTransform.addChild(moover.transform);

        callStartToAllModels();
    }
}
