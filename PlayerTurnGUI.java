import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerTurnGUI extends JFrame {
    private JLabel[] playerLabels;
    private int currentPlayerIndex = 0;

    public PlayerTurnGUI() {
        setTitle("Player Turn Highlighter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        ImageIcon[] playerImages = new ImageIcon[4];
        playerImages[0] = new ImageIcon("h2.png");
        playerImages[1] = new ImageIcon("h4.png");
        playerImages[2] = new ImageIcon("r2.jpg");
        playerImages[3] = new ImageIcon("r4.jpeg");

        playerLabels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            playerLabels[i] = new JLabel(playerImages[i]);
            playerLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }

        JButton nextTurnButton = new JButton("Next Turn");

        setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            add(playerLabels[i]);
        }
        add(nextTurnButton);

        // Add ActionListener to the button
        nextTurnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerLabels[currentPlayerIndex].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                currentPlayerIndex = (currentPlayerIndex + 1) % 4;
                playerLabels[currentPlayerIndex].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PlayerTurnGUI playerTurnGUI = new PlayerTurnGUI();
                playerTurnGUI.setVisible(true);
            }
        });
    }
}

