package test2;

import takenocco2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CameraMoover extends Asset {
    private CameraMooverModel model;
    private JLabel chasingName;
    public CameraMoover(){
        super();
        model=new CameraMooverModel(transform,this);
        modelList.add(model);
        transform.setSize(new Dimension(200,100));
        transform.setPhase(new Point(200,200));

        chasingName=new JLabel();
        chasingName.setFont(new Font("メイリオ",Font.BOLD,25));
        add(chasingName);
    }

    private class CameraMooverModel extends Model {
        public CameraMooverModel(Transform transform, Asset asset) {
            super(transform, asset);
        }

        @Override
        public String getName() {
            return "CameraMooverModel";
        }

        Model sunModel;
        Model earthModel;
        Model moonModel;
        Transform cameraTransform;
        Transform camerasNowParent;

        @Override
        public void start() {
            Scene nowScene=Service.inst().getNowScene();
            sunModel= nowScene.getModelsByName("SumModel").get(0);
            earthModel=nowScene.getModelsByName("EarthModel").get(0);
            moonModel=nowScene.getModelsByName("MoonModel").get(0);
            cameraTransform=nowScene.cameraTransform;

            Dimension cntSize=Service.inst().getCntSize();
            cameraTransform.setPhase(new Point(-cntSize.width/2,-cntSize.height/2));

            camerasNowParent =earthModel.transform;
            camerasNowParent.addChild(cameraTransform);
        }

        @Override
        public void update() {
            if(Service.inst().isPressing(KeyEvent.VK_S)){
                changeCamerasParent(sunModel.transform);
                chasingName.setText("太陽");
            }
            if(Service.inst().isPressing(KeyEvent.VK_E)){
                changeCamerasParent(earthModel.transform);
                chasingName.setText("地球");
            }
            if(Service.inst().isPressing(KeyEvent.VK_M)){
                changeCamerasParent(moonModel.transform);
                chasingName.setText("月");
            }
        }

        private void changeCamerasParent(Transform nextParent){
            camerasNowParent.removeChild(cameraTransform);
            nextParent.addChild(cameraTransform);
            camerasNowParent=nextParent;
        }
    }
}
