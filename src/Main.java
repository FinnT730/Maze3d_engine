import com.sun.javafx.geom.Vec3f;
import com.sun.javafx.geom.Vec4f;

import javax.swing.*;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.util.Vector;

public class Main extends Component implements Runnable {


    Thread thread = new Thread(this);

    static JFrame app = new JFrame("Maze");

    public Main() {
        thread.run();
        app.setSize(640, 480);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.add(this);
    }

    public static void main(String[] args) {
        new Main();
    }


    Vec3f vec = new Vec3f(50, 5, 0);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Vec3f vec1 = new Vec3f(50, 100, 300);
        Vec3f res = new Vec3f(100, 200, 2);


        Vector3f vector = new Vector3f(vec.x, vec.y, vec.z);
        Tuple3f tup = new Vector3f(0, 0, 0);


        vec.dot(vec1);
        vec.normalize();

        g.drawRect((int) vector.x, (int) vector.y, (int) vec1.x, (int) vec1.y);
//        g.draw3DRect((int)vec.x,(int)vec.y,(int)vec1.x,(int)vec1.y,false);

        System.out.println(vec);
        System.out.println(vec1);


    }


    @Override
    public boolean mouseMove(final Event evt, final int x, final int y) {
        vec.add(new Vec3f(x, y, 0));
        return super.mouseMove(evt, x, y);
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
