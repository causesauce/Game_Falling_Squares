
import java.awt.*;

public class Square{
    private int x;
    private int y;
    private final int width = 20;
    private final int height = 20;



    final int velocity = 1;

    Square(){
        x = ((int)(Math.random()*450))+10;
        y = -20;
    }



    public void draw(Graphics g){

        g.setColor(Color.white);

            g.fillRect(x, y, width, height);
            y += velocity;


    }

   int getX(){
        return x;
   }

   int getY(){
        return y;
   }

   int getWidth(){
        return width;
   }

   int getHeight(){
        return height;
   }


}
