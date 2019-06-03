package test2;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Service;
import takenocco2.Transform;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EarthAsset extends Asset {
    private EarthModel model;
    public EarthAsset(){
        super();
        transform.setSize(new Dimension(100,100));
        setName("EarthAsset");
        model=new EarthModel(transform,this);
        modelList.add(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(10,10,transform.size.width-10,transform.size.height-10);
    }

    private class EarthModel extends Model {
        private int step=0;
        private int r=300;
        private double omega=0.03;
        private double theta;
        public EarthModel(Transform transform, Asset asset) {
            super(transform, asset);
        }

        @Override
        public String getName() {
            return "EarthModel";
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
