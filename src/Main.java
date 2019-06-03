import takenocco2.Service;
import test1.Test1Scene;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Service.inst().changeScene(new Test1Scene());
        });
    }
}
