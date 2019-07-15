package test3;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Transform;

import java.awt.*;

public class BeanAsset extends Asset {
    private BeanModel model;
    public BeanAsset(){
        super();
        transform.setSize(new Dimension(30,30));
        model=new BeanModel(transform,this);
        modelList.add(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(0,0,transform.size.width,transform.size.height);
    }

    public class BeanModel extends Model {
        public BeanModel(Transform transform, Asset asset) {
            super(transform, asset);
        }

        @Override
        public String getName() {
            return "BeanModel";
        }

        @Override
        public void start() {

        }

        @Override
        public void update() {

        }
    }
}
