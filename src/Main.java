import com.sun.javafx.geom.Vec3f;
import com.sun.javafx.geom.Vec4f;

import javax.swing.*;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;
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


    Vec3f vec = new Vec3f(50, 5, 0);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Vec3f vec1 = new Vec3f(50, 100, 300);
        Vec3f res = new Vec3f(100, 200, 2);


        Vector3f vector = new Vector3f(vec.x, vec.y, vec.z);
        Tuple3f tup = new Vector3f(0, 0, 0);


//        vec.dot(vec1);

        g.drawRect((int) vec.x, (int) vec.y, (int) vec1.x, (int) vec1.y);
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

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            vec.add(new Vec3f(-1, 0, 0));
            repaint();
        }
        if (e.getKeyChar() == 'w') {
            vec.add(new Vec3f(0, -1, 0));
            repaint();
        }
        if (e.getKeyChar() == 's') {
            vec.add(new Vec3f(0, 1, 0));
            repaint();
        }
        if (e.getKeyChar() == 'd') {
            vec.add(new Vec3f(1, 0, 0));
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
