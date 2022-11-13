/**
 * Tictactoe
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tictactoe implements ActionListener {
    JFrame window=new JFrame("Tic Tac Toe"); 
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel=new JPanel();
    JPanel reloadPanel=new JPanel();
    JPanel scorePanel=new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton reloadbutton=new JButton("Reload");
    JButton closebutton=new JButton("Close");
    JLabel label_player_X=new JLabel("Player-X");
    JLabel label_player_O=new JLabel("Player-O");
    int playerX_Score=0;
    int playerO_Score=0;
    boolean playerX_turn;
    
    Tictactoe(){
           // set the size of the JFrame
        window.setSize(1000, 800);
         // set the background color of the JFrame
        window.getContentPane().setBackground(new Color(0, 255, 51));
          // set the layout of the JFrame 
        window.setLayout(new BorderLayout());
        // set the JFrame to be visible
        window.setVisible(true);
        // set the background color of the JPanel
        textfield.setBackground(new Color(25, 25, 25));
        // set the foreground color of the JPanel
        textfield.setForeground(new Color(25, 255, 0));
         // set the font of the JPanel
         textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
         // set the horizontal alignment of the JPanel
         textfield.setHorizontalAlignment(JLabel.CENTER);
         // set the text of the JPanel
         textfield.setText("Tic-Tac-Toe");
         // set the JPanel to be opaque
         textfield.setOpaque(true);
         // set the layout of the JPanel
         titlePanel.setLayout(new BorderLayout());
         // set the bounds of the JPanel
         titlePanel.setBounds(0, 0, 800, 100);
         // set the layout of the JPanel
         buttonPanel.setLayout(new GridLayout(3, 3));
         // set the background color of the JPanel
         buttonPanel.setBackground(new Color(150, 150, 150));
         // create a for loop
         for (int i = 0; i < 9; i++) {
            // set the JButton array to a new JButton
            buttons[i] = new JButton();
            // add the JButton array to the JPanel
            buttonPanel.add(buttons[i]);
            // set the font of the JButton array
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            // set the JButton array to be not focusable
            buttons[i].setFocusable(false);
            // add an action listener to the JButton array
            buttons[i].addActionListener(this);
        }
        reloadPanel.setLayout(new GridLayout(1, 2));
        // set the background color of the JPanel
        reloadPanel.setBackground(new Color(150, 150, 150));
        // add the reload button to the JPanel
        reloadPanel.add(reloadbutton);
        // add the close button to the JPanel
        reloadPanel.add(closebutton);
        // set the font of the reload button
        reloadbutton.setFont(new Font("MV Boli", Font.BOLD, 50));
        // set color of the reload button
        reloadbutton.setBackground(new Color(0, 0, 255));
        // set the font of the close button
        closebutton.setFont(new Font("MV Boli", Font.BOLD, 50));
        // set color of the close button
        closebutton.setBackground(new Color(255, 0, 0));
        // set the reload button to be not focusable
        reloadbutton.setFocusable(false);
        // set the close button to be not focusable
        closebutton.setFocusable(false);
        // add an action listener to the reload button
        reloadbutton.addActionListener(this);
        // add an action listener to the close button
        closebutton.addActionListener(this);
        scorePanel.setLayout(new GridLayout(2, 1));
        // set the background color of the JPanel as gold
        scorePanel.setBackground(new Color(255, 255, 0));
        // set the font of the score label
        label_player_X.setFont(new Font("MV Boli", Font.BOLD, 20));
        // set the text of the score label such that it displays the score of both players in two lines
        label_player_X.setText("Player X: " + playerX_Score);
        // add the score label to the JPanel
        scorePanel.add(label_player_X);
        // set the font of the score label
        label_player_O.setFont(new Font("MV Boli", Font.BOLD, 20));
        // set the text of the score label such that it displays the score of both players in two lines
        label_player_O.setText("Player O: " + playerO_Score);
        // add the score label to the JPanel
        scorePanel.add(label_player_O);
        // add the JPanel to the JFrame
        titlePanel.add(textfield);
        titlePanel.add(textfield);
        // add the JPanel to the JFrame
        window.add(titlePanel, BorderLayout.NORTH);
        // add the JPanel to the JFrame
        window.add(buttonPanel);
        // add the JPanel to the JFrame
        window.add(reloadPanel, BorderLayout.SOUTH);
        // add the JPanel to the JFrame
        window.add(scorePanel, BorderLayout.EAST);
        // call the firstTurn method
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            // create an if statement
            if (e.getSource() == buttons[i]) {
                // create an if statement
                if (playerX_turn) {
                    // set the text of the JButton array to X
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 255, 0));
                        buttons[i].setText("X");
                        playerX_turn = false;
                        textfield.setText("O turn");
                        // change color of the textfield
                        textfield.setForeground(new Color(0, 0, 255));
                        check();
                    }
                } else {
                    // set the text of the JButton array to O
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        playerX_turn = true;
                        textfield.setText("X turn");
                        // change color of the textfield
                        textfield.setForeground(new Color(0, 255, 0));
                        check();
                    }
                }
            }
        }
        if (e.getSource() == reloadbutton) {
            // call the reload method
            reload();
        }
        // add functionality to the close button
        if (e.getSource() == closebutton) {
            // close the window
            window.dispose();
        }
        
    }
       // create a method
       public void firstTurn() {
        // create a try catch block
        try {
            // create a thread
            textfield.setText("Tic-Tac-Toe");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // create an if statement
        if (Math.random() < 0.5) {
            playerX_turn = true;
            textfield.setText("X turn");
        } else {
            playerX_turn = false;
            textfield.setText("O turn");
        }
    }
    public void reload(){
        // create a for loop
        for (int i = 0; i < 9; i++) {
            // set the text of the JButton array to empty
            buttons[i].setText("");
            // set the background color of the JButton array to the default color
            buttons[i].setBackground(new Color(240, 240, 240));
            // set the text of the textfield to empty
            buttons[i].setEnabled(true);
        }
        // call the firstTurn method
        firstTurn();
    }
    // create a method
    public void check() {
        // create an if statement
        if (
            (buttons[0].getText() == "X") &&
            (buttons[1].getText() == "X") &&
            (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        // create an if statement
        if (
            (buttons[3].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        // create an if statement
        if (
            (buttons[6].getText() == "X") &&
            (buttons[7].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "X") &&
            (buttons[3].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        // create an if statement
        if (
            (buttons[1].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "X") &&
            (buttons[5].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[1].getText() == "O") &&
            (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        // create an if statement
        if (
            (buttons[3].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        // create an if statement
        if (
            (buttons[6].getText() == "O") &&
            (buttons[7].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[3].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        // create an if statement
        if (
            (buttons[1].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "O") &&
            (buttons[5].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }
       // create a method
       public void xWins(int a, int b, int c) {
        // set the text of the textfield to X wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        // add 1 to the xCount
        playerX_Score++;
        // set the text of the playerX_score_label to the xCount
        label_player_X.setText("Player 1: " + playerX_Score);
    }
    // create a method
    public void oWins(int a, int b, int c) {
        // set the text of the textfield to O wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        // add 1 to the score of O
        playerO_Score++;
        // set the text of the playerO_score_label to the oCount
        label_player_O.setText("Player 2: " + playerO_Score);

    }
}    

  

    
    
