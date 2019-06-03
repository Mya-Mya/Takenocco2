package test1;

import takenocco2.Asset;
import takenocco2.Scene;
import takenocco2.Service;

import javax.swing.*;
import java.awt.*;

public class Test1Scene extends Scene {
    public Test1Scene() {
        super(new Dimension(2000,2000));
    }

    @Override
    public void buildPrimaryAssets() {
        int x=200;
        Asset cameraCenteringAsset=null;
        for(int i=0;i<14;i++){
            Asset newAsset=new SquareAsset(new Point(x,500));
            if(i==7)cameraCenteringAsset=newAsset;
            addAsset(newAsset);
            x+=80;
        }
        //Transformの親子関係の構築
        cameraCenteringAsset.transform.setSize(new Dimension(100,100));
        cameraCenteringAsset.transform.addChild(cameraTransform);

        Dimension cntSize= Service.inst().getCntSize();
        cameraTransform.setPhase(new Point(-cntSize.width/2,-cntSize.height/2));
        callStartToAllModels();
    }
}
