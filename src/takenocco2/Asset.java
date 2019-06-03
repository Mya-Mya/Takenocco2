package takenocco2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 見えるものは全てこれを継承する。<GameObject及びRenderer>
 * ★Sceneの仕様により、他のクラスからnameで検索されることがあるので、分かりやすい名前をsetNameで登録すること。
 * ★Transformの仕様により、自身の大きさと位置の変更には必ずtransformを使用すること。
 */
public abstract class Asset extends JPanel implements TransformFollower {
    //★Sceneの仕様により、用いるmodelは全てコンストラクタで生成しmodelListに格納すること。<Componentの中のScript>
    public List<Model> modelList;
    public Transform transform;
    public Asset(){
        super();
        modelList= new ArrayList<>();
        transform=new Transform();
        transform.addFollower(this);
        setVisible(true);
    }

    @Override
    public final void transformChanged() {
        int x=transform.position.x;
        int y=transform.position.y;
        int width=transform.size.width;
        int height=transform.size.height;
        setBounds(x-width/2,y-height/2,width,height);
        repaint();
    }
}
