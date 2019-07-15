package test3;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Service;
import takenocco2.Transform;

import java.awt.*;

public class CarAsset extends Asset {
    private CarModel model;
    public CarAsset(){
        super();
        transform.setSize(new Dimension(30,100));
        model=new CarModel(transform,this);
        modelList.add(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,transform.size.width,transform.size.height);
    }

    private class CarModel extends Model {
        public CarModel(Transform transform, Asset asset) {
            super(transform, asset);
        }

        @Override
        public String getName() {
            return "CarModel";
        }

        @Override
        public void start() {
            Asset bean=new BeanAsset();
            transform.addChild(bean.transform);
            bean.transform.setPhase(new Point(0,100));
            Service.inst().getNowScene().addAsset(bean);
        }

        @Override
        public void update() {

        }
    }
}
