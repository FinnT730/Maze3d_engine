import com.sun.javafx.geom.Vec3f;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Main extends Component {


    static JFrame app = new JFrame("Maze");

    public Main() {
        app.setSize(640,480);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.add(this);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Vec3f vec = new Vec3f(0,0,0);
        Vec3f vec1 = new Vec3f(100,100,0);
        Vec3f res = new Vec3f();


        res.add(vec, vec1);

        g.drawRect((int)vec.x,(int)vec.y,(int)vec1.x,(int)vec1.y);

    }
}
