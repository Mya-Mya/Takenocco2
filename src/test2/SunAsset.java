package test2;

import sun.print.SunMinMaxPage;
import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Service;
import takenocco2.Transform;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SunAsset extends Asset {
    private SunModel model;
    public SunAsset(){
        super();
        setName("SunAsset");

        transform.setSize(new Dimension(200,200));
        model=new SunModel(transform,this);
        modelList.add(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(0,0,transform.size.width,transform.size.height);
    }

    private class SunModel extends Model {
        public SunModel(Transform transform, Asset asset) {
            super(transform, asset);
        }

        @Override
        public String getName() {
            return "SumModel";
        }

        @Override
        public void start() {
        }

        @Override
        public void update() {
            if (Service.inst().isPressing(KeyEvent.VK_ENTER)){
                transform.setSize(new Dimension(transform.size.width+2,transform.size.height+2));
            }
        }
    }
}
