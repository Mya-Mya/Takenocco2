import takenocco2.Service;
import test1.Test1Scene;
import test2.Test2Scene;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Service.inst();
            Service.inst().changeScene(new Test2Scene(new Dimension(1000,1000)));
        });
    }
}
