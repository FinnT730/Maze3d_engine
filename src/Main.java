import com.sun.javafx.geom.Vec3f;
import com.sun.javafx.geom.Vec4f;
import javafx.scene.Camera;
import javafx.scene.ParallelCamera;

import javax.swing.*;
import javax.vecmath.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class Main extends Component implements Runnable, KeyListener, MouseListener {


    Thread thread = new Thread(this);

    static JFrame app = new JFrame("Maze");

    public Main() {
        app.setSize(640, 480);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.addKeyListener(this);
        app.addMouseListener(this);
        app.add(this);
        thread.run();
    }

    public static void main(String[] args) {
        new Main();
    }


    Matrix3f matrix = new Matrix3f();

    Vec3f vec = new Vec3f(0, 0, 0);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Vec3f vec1 = new Vec3f(0, 0, 300);
        Vec3f res = new Vec3f(100, 200, 2);


        Vector3f vector = new Vector3f(vec.x, vec.y, vec.z);
        Tuple3f tup = new Vector3f(0, 0, 0);

        tup.set(vec1.x,vec1.y,vec1.z);
        Point3f point = new Point3f(tup);


        matrix.set(new Quat4f(10,10,50,50));


        point.project(new Point4f(vec.x,vec.y,vec.z,vec1.x));

//        vec.dot(vec1);

        g.drawRect((int) vec.x, (int) vec.y, (int) matrix.getM00(), (int) matrix.getM01());
//        g.draw3DRect((int)vec.x,(int)vec.y,(int)vec1.x,(int)vec1.y,false);

//        System.out.println(vec);
//        System.out.println(vec1);


    }

    boolean canRun = true;

//    @Override
//    public boolean keyDown(final Event evt, final int key) {
//        if(key == 'p') {
//            vec.add(new Vec3f(5,0,0));
//            repaint();
//        }
//        if(key == '-') {
//            canRun = false;
//        }
//        repaint();
//        return super.keyUp(evt, key);
//    }
//
//    @Override
//    public boolean mouseMove(final Event evt, final int x, final int y) {
//        vec.add(new Vec3f(x, y, 0));
//        return super.mouseMove(evt, x, y);
//    }


    @Override
    public void run() {
        while (canRun) {
            try {
                repaint();
                this.update(this.getGraphics());
                thread.sleep(1 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        System.out.println(matrix.toString());
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            vec.add(new Vec3f(-10, 0, 0));
            repaint();
        }
        if (e.getKeyChar() == 'w') {
            vec.add(new Vec3f(0, -10, 0));
            repaint();
        }
        if (e.getKeyChar() == 's') {
            vec.add(new Vec3f(0, 10, 0));
            repaint();
        }
        if (e.getKeyChar() == 'd') {
            vec.add(new Vec3f(10, 0, 0));
            repaint();
        }


        if (e.getKeyChar() == '=') {
            canRun = false;
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            app.getGraphics().dispose();
        }


        if(e.getKeyChar() == '-') {
            canRun = true;
            thread.run();
        }

        update(this.getGraphics());

    }

    @Override
    public void keyReleased(final KeyEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
//        System.out.println("dd");
//        Vec3f vv = new Vec3f(e.getX(),e.getY(),0);
//        vec = vv;
//        vv = null;
//        repaint();
    }

    @Override
    public void mousePressed(final MouseEvent e) {

    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }
}
