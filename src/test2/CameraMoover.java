package test2;

import takenocco2.*;

import java.awt.*;

public class CameraMoover extends Asset {
    private CameraMooverModel model;
    public CameraMoover(){
        super();
        model=new CameraMooverModel(transform,this);
        modelList.add(model);
        transform.setSize(new Dimension(200,100));
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
        @Override
        public void start() {
            Scene nowScene=Service.inst().getNowScene();
            sunModel= nowScene.getModelsByName("SumModel").get(0);
            earthModel=nowScene.getModelsByName("EarthModel").get(0);
            moonModel=nowScene.getModelsByName("MoonModel").get(0);
        }

        @Override
        public void update() {

        }
    }
}
