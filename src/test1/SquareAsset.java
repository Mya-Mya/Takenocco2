package test1;

import takenocco2.Asset;
import takenocco2.Model;
import takenocco2.Transform;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SquareAsset extends Asset implements KeyListener {
    SquareModel myModel;
    public SquareAsset(){
        super();
        transform.setPhase(new Point(100,100));
        //☆名前を決める。
        setName("Square");
        //☆modelはコンストラクタで生成する。
        myModel=new SquareModel(transform,this);
        //☆modelは独自で変数を用意してもいいが、modelListに追加することを忘れずに。
        modelList.add(myModel);

        setFocusable(true);
        addKeyListener(this);
    }

    @Override//Component
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        //☆ここでの座標はtransform.positionを基準とする。
        g.fillRect(0,0,transform.size.width,transform.size.height);
    }

    @Override//KeyListener
    public void keyTyped(KeyEvent e) {
    }

    //☆キー入力等のイベントがあってもその都度model.updateを呼び出すことはできないので設計に工夫が必要。
    @Override//KeyListener
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ENTER) {
            myModel.askedDown();
        }
    }

    @Override//KeyListener
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ENTER) {
            myModel.askedVerticalStop();
        }
    }
}
