package takenocco2;

import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.jws.WebParam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Scene内に存在する全assetと全modelを把握する。
 * 全modelに対し、適当なタイミングでstart関数とupdate関数を呼び出す。
 * Sceneは、内部に大きなJPanelを保持し、それをJScrollPaneの機能であるスクロール機能を用いることでカメラの目線を再現する。
 * todo カメラの実装
 * Serviceの仕様により、全てのクラスがここにアクセスできる。
 */
public abstract class Scene extends JScrollPane implements ActionListener {
    protected Service service;
    protected List<Asset>assetList;
    protected List<Model>modelList;
    protected JPanel sheet;
    protected Dimension sheetSize;
    protected Dimension sceneSize;

    public Scene(Dimension sheetSize){
        super();
        service=Service.inst();
        this.sheetSize=sheetSize;
        this.sceneSize=service.getCntSize();

        this.setPreferredSize(sceneSize);

        assetList=new ArrayList<>();
        modelList=new ArrayList<>();

        sheet=new JPanel();
        sheet.setLayout(null);
        sheet.setBackground(Color.WHITE);
        sheet.setPreferredSize(sheetSize);
        sheet.setVisible(true);

        getViewport().setView(sheet);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);

        this.setVisible(true);
        new Timer(10,this).start();
    }

    public void refreshModelList(){
        modelList=new ArrayList<>();
        for(Asset a:assetList){
            modelList.addAll(a.modelList);
        }
    }

    //★継承した全てのSceneはassetの初期設定が完了した時点でこれを呼び出すこと。
    public void callStartToAllModels(){
        for(Model m:modelList){
            m.start();
        }
    }

    public void addAsset(Asset a){
        sheet.add(a);
        assetList.add(a);
        refreshModelList();
        for(Model m:a.modelList){
            m.start();
        }
    }
    public void removeAsset(Asset a){
        sheet.remove(a);
        assetList.remove(a);
        refreshModelList();
    }

    //assetやmodelが容易に他のassetとつながることができる。<GameObject.Find>
    public List<Asset>getAssetsByName(String name){
        List<Asset>out= new ArrayList<>();
        for(Asset a:assetList){
            if(a.getName().equals(name)){
                out.add(a);
            }
        }
        return out;
    }
    //assetやmodelが容易に他のmodelとつながることができる。<Component.GetComponent>
    public List<Model>getModelsByName(String name){
        List<Model>out= new ArrayList<>();
        for(Model m:modelList){
            if(m.getName().equals(name)){
                out.add(m);
            }
        }
        return out;
    }

    @Override//ActionListener
    public void actionPerformed(ActionEvent e) {
        for(Model m:modelList){
            m.update();
        }
    }
}
