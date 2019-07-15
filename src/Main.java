import takenocco2.Service;
import test1.Test1Scene;
import test2.Test2Scene;
import test3.Test3Scene;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Service.inst();
            Service.inst().changeScene(new Test3Scene());
        });
    }
}
