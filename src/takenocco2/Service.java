package takenocco2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * このインスタンスはアプリケーション1つにつき1つしか存在しないが、全てのクラスがここにアクセスできる。
 * これは、すべてのクラスがsceneにアクセスできることを意味する。
 */
public class Service extends JFrame implements WindowListener {
    //シングルトンパターンを適用する。
    private static Service instance;
    public static Service inst(){
        if(instance==null)instance=new Service();
        return instance;
    }

    //画面の大きさを変数で保持しておく。
    private final Dimension wndSize=new Dimension(700,500);
    private Dimension cntSize;
    public Dimension getCntSize(){
        return cntSize;
    }

    public Service(){
        super("Takenocco2Architecture");
        addWindowListener(this);
        setPreferredSize(wndSize);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        cntSize=getRootPane().getSize();
        setVisible(true);
    }

    //Sceneに関する変数と関数。
    private Scene nowScene;
    //<SceneManager.LoadScene>
    public void changeScene(Scene nextScene){
        getContentPane().removeAll();
        getContentPane().add(nextScene);
        nowScene=nextScene;
    }
    public Scene getNowScene(){
        return nowScene;
    }

    @Override//WindowListener
    public void windowOpened(WindowEvent e) {

    }

    @Override//WindowListener
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override//WindowListener
    public void windowClosed(WindowEvent e) {

    }

    @Override//WindowListener
    public void windowIconified(WindowEvent e) {

    }

    @Override//WindowListener
    public void windowDeiconified(WindowEvent e) {

    }

    @Override//WindowListener
    public void windowActivated(WindowEvent e) {

    }

    @Override//WindowListener
    public void windowDeactivated(WindowEvent e) {

    }
}
