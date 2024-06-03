import javax.swing.*;
import java.awt.*;

public class XOGame extends JFrame {
    JButton [][] gameArray ;
    String player = "X";
    public XOGame(String title){
        super(title);
        setBounds(400,150,350,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(3,3,10,10));

        gameArray = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3 ; j++) {
                gameArray[i][j] = new JButton("");
                gameArray[i][j].setFont(new Font("Tahoma" , Font.BOLD , 25));
                gameArray[i][j].setHorizontalAlignment(JLabel.CENTER);
                gameArray[i][j].setBackground(Color.green);
                this.getContentPane().add(gameArray[i][j]);

                gameArray[i][j].addActionListener(e -> {
                    JButton btn = (JButton) e.getSource();
                    if(e.getActionCommand().equals("")){
                        btn.setText(player);
                        btn.setBackground(Color.gray);

                        if(player.equals("X")) player ="O";
                        else player = "X";
                    }
                });
            }
        }

    }

    public static void main(String[] args) {
        XOGame game = new XOGame("X O Game");
        game.setVisible(true);
    }

}
