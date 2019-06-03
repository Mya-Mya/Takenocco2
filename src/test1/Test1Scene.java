package test1;

import takenocco2.Asset;
import takenocco2.Scene;

import javax.swing.*;
import java.awt.*;

public class Test1Scene extends Scene {
    public Test1Scene() {
        super(new Dimension(2000,2000));

        int x=200;
        Asset cameraCenteringAsset=null;
        for(int i=0;i<20;i++){
            Asset newAsset=new SquareAsset(new Point(x,500));
            if(i==10)cameraCenteringAsset=newAsset;
            addAsset(newAsset);
            x+=100;
        }
        cameraCenteringAsset.setBackground(Color.red);
        cameraCenteringAsset.transform.addChild(cameraTransform);
        cameraTransform.setPhase(new Point(getSize().width/2,getSize().height/2));
        callStartToAllModels();
    }
}
