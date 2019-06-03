package takenocco2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 担当するTransformFollowerの座標と大きさを管理する。
 * 親子関係を持つことができる。
 * ★親子関係の構築はSceneのコンストラクタにてやるべき。
 */
public final class Transform {
    public TransformFollower follower;
    public List<Transform>childList;
    public Point initialPhase;
    public Point phase;
    public Point position;
    public Dimension size;

    public Transform(TransformFollower you){
        follower=you;
        childList= new ArrayList<>();
        size=new Dimension(50,50);
        initialPhase=new Point(0,0);
        position=new Point(0,0);
        phase=new Point(0,0);
        updatePosition();
    }

    //★Assetの大きさは必ずこれで変更すること。
    public void setSize(Dimension size){
        this.size=size;
        follower.transformChanged();
    }

    //★Assetの位置は必ずこれで変更すること。
    public void shiftPhase(int dx,int dy){
        phase.translate(dx, dy);
        updatePosition();
    }

    //★Assetの位置は必ずこれで変更すること。
    public void setPhase(Point phase){
        this.phase=phase;
        updatePosition();
    }

    public void setInitialPhase(Point initialPhase) {
        this.initialPhase = initialPhase;
        updatePosition();
    }

    public void addChild(Transform child){
        childList.add(child);
        child.setInitialPhase(position);
    }

    protected void updatePosition(){
        position.x=initialPhase.x+phase.x;
        position.y=initialPhase.y+phase.y;
        for(Transform t:childList){
            t.setInitialPhase(position);
        }
        follower.transformChanged();
    }
}