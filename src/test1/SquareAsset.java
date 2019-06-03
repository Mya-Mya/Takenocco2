package test1;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Transform;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SquareAsset extends Asset{
    private SquareModel myModel;
    public SquareAsset(Point phase){
        super();
        transform.setPhase(phase);
        //☆名前を決める。
        setName("Square");
        //☆modelはコンストラクタで生成する。
        myModel=new SquareModel(transform,this);
        //☆modelは独自で変数を用意してもいいが、modelListに追加することを忘れずに。
        modelList.add(myModel);
    }


    @Override//Component
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        //☆ここでの座標はtransform.positionを基準とする。
        g.fillRect(0,0,transform.size.width,transform.size.height);

        g.setColor(Color.red);
        g.fillOval(
                (int)(transform.size.width/2+20*Math.cos(myModel.getTheta())),
                (int)(transform.size.width/2+20*Math.sin(myModel.getTheta())),
                10,10
                );
    }

}
