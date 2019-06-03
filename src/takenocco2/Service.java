package takenocco2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * このインスタンスはアプリケーション1つにつき1つしか存在しないが、全てのクラスがここにアクセスできる。
 * これは、すべてのクラスがsceneにアクセスできることを意味する。
 */
public class Service extends JFrame implements WindowListener, KeyListener {
    //シングルトンパターンを適用する。
    private static Service instance;
    public static Service inst(){
        if(instance==null)instance=new Service();
        return instance;
    }

    //画面の大きさを変数で保持しておく。
    private final Dimension wndSize=new Dimension(1000,700);
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
        getRootPane().setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(this);
        setVisible(true);
    }

    //Sceneに関する変数と関数。
    private Scene nowScene;
    //<SceneManager.LoadScene>
    public void changeScene(Scene nextScene){
        nowScene=nextScene;
        nextScene.buildPrimaryAssets();
        getContentPane().removeAll();
        getContentPane().add(nextScene);
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

    //キー入力に関する変数と関数
    private Set<Integer> keypressing=new HashSet<>();
    public boolean isPressing(int keyCode){
        return keypressing.contains(keyCode);
    }

    @Override//KeyListener
    public void keyTyped(KeyEvent e) {

    }

    @Override//KeyListener
    public void keyPressed(KeyEvent e) {
        keypressing.add(e.getKeyCode());
    }

    @Override//KeyListener
    public void keyReleased(KeyEvent e) {
        keypressing.remove(e.getKeyCode());
    }
}
