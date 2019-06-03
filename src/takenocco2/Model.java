package takenocco2;

/**
 * assetの振る舞い等を記述する。<MonoBehaviour>
 * 特定のasset下でしか機能しないため、assetのインナークラスとして継承してもよい。
 */
public abstract class Model {
    //このtransformはこのmodelの所有主であるassetのtransformと等価である。
    public Transform transform;
    public Asset asset;
    public Model(Transform transform,Asset asset){
        this.transform=transform;
        this.asset=asset;
    }
    //★Sceneの仕様により、他のクラスからnameで検索されることがあるので、分かりやすい名前を返すようにすること。<tag>
    public abstract String getName();
    public abstract void start();
    public abstract void update();
}
