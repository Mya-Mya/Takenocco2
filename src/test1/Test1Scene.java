package test1;

import takenocco2.Scene;

import javax.swing.*;
import java.awt.*;

public class Test1Scene extends Scene {
    public Test1Scene() {
        super(new Dimension(2000,2000));
        addAsset(new SquareAsset());
        callStartToAllModels();
    }
}
