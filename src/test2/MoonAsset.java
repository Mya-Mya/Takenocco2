package test2;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Transform;

import java.awt.*;

public class MoonAsset extends Asset {
    private MoonModel model;
    public MoonAsset(){
        super();
        transform.setSize(new Dimension(30,30));
        setName("MoonAsset");
        model=new MoonModel(transform,this);
        modelList.add(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(10,10,transform.size.width-10,transform.size.height-10);
    }

    private class MoonModel extends Model {
        private int step=0;
        private int r=100;
        private double omega=0.07;
        private double theta;
        public MoonModel(Transform transform, Asset asset) {
            super(transform, asset);
        }

        @Override
        public String getName() {
            return "MoonModel";
        }

        @Override
        public void start() {

        }

        @Override
        public void update() {
            step++;
            theta=omega*step;
            transform.setPhase(new Point(
                    (int)(r*Math.cos(theta)),
                    (int)(r*Math.sin(theta))
            ));
        }
    }
}
