import javax.swing.*;


public class AppliedThread extends Thread {
    Square square;

    @Override
    public void run(){
        while(Drawing.totalBlocks < 50){
            square = new Square();
            Drawing.squares.add(square);
            Drawing.totalBlocks++;
            try {
                sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(!Drawing.squares.isEmpty()){
            System.out.println(Drawing.squares.size());
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(MyPanel.myScore > 50){
            if(MyPanel.myScore == 100){
                JOptionPane.showMessageDialog(null, "HIGH FIVE, YOU ARE AN ABSOLUTE CHAMPION \n SCORE IS 100%");
                Drawing.lock = false;
                return;
            }
            Drawing.lock = false;
            JOptionPane.showMessageDialog(null, "You won, your score is greater than 50%");

        }else {
            Drawing.lock = false;
            JOptionPane.showMessageDialog(null, "You lost, your score is less than 50.1%");
        }
    }
}


