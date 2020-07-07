
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class MyPanel extends JPanel implements MouseListener {

    static double myScore;
    int givenHeight;

    MyPanel(){
        setBackground(Color.BLACK);

        setSize(new Dimension(500,400));
        givenHeight = getHeight();
        addMouseListener(this);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Iterator<Square> iterator = Drawing.squares.iterator();
           while(iterator.hasNext()){
               Square square = iterator.next();
                    square.draw(g);
                    if (square.getY() >= givenHeight) {

                            iterator.remove();

                    }
                }

    }



    @Override
    public void mouseClicked(MouseEvent a) {


    }

    @Override
    public void mousePressed(MouseEvent a) {


            Iterator<Square> iterator = Drawing.squares.iterator();
            while (iterator.hasNext()) {
                    Square square = iterator.next();
                    if (a.getX() >= square.getX()-5 && a.getX() <= (square.getX() + square.getWidth()+5) && a.getY() >= square.getY()-5 && a.getY() <= (square.getY() + square.getHeight()+5)) {
                        Drawing.killedBlocks++;
                        myScore = ((double) (Drawing.killedBlocks) * 100 / 50 );
                        Drawing.scoreLabel.setText("CURRENT SCORE: " + myScore + "%");

                        iterator.remove();
                    }
            }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent a) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

}

