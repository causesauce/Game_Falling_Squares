import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;


class Drawing extends JFrame  {
    public static Thread mainThread;
    public static Boolean lock;
    static int totalBlocks = 0;
    static int killedBlocks = 0;
    static JPanel score;

    static AppliedThread at;
    static ArrayList<Square> squares = new ArrayList<>();
    static JLabel scoreLabel;




    Drawing() {
        lock = true;
        at = new AppliedThread();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        score = new JPanel();
        Border border = BorderFactory.createTitledBorder("SCORE");
        score.setBorder(border);
        scoreLabel = new JLabel("CURRENT SCORE: 0%");
        score.add(scoreLabel);
        score.setBackground(Color.white);
        getContentPane().setBackground(Color.black);
        add(score, BorderLayout.SOUTH);
        add(new MyPanel(), BorderLayout.CENTER);



        //-----------------------------------------------------


        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);



    }




                                                                        // main
    public static void main(String[] args) {
        Drawing d = new Drawing();


        mainThread = new Thread(() ->{
            at.start();

            while(lock){
                d.repaint();

                try{
                    Thread.sleep(5);
                }catch (InterruptedException e){

                }
            }
            d.setVisible(false);
        });
        mainThread.start();

    }
}




