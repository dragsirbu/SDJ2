
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
public class BookmakerGUI extends JFrame implements Observer
{
    private JLabel labelScore, labelOdds;
    private JButton buttonUpdate;
    // model class
    private FootballGame game;
    public BookmakerGUI(FootballGame game)
    {
        super("Football Game Odds");
        this.game = game;
        this.game.addObserver(this);
        createComponents();
        initializeComponents();
        registerEventHandlers();
        addComponentsToFrame();
        show();

    }
    private void createComponents()
    {
        labelOdds = new JLabel("Odds for home team as winner: 1:1.5");
        labelScore = new JLabel(game.getScore());
        buttonUpdate = new JButton("Update");
        labelScore.setFont(new Font(labelScore.getFont().getFontName(),
                Font.PLAIN, 20));
        labelOdds.setFont(new Font(labelOdds.getFont().getFontName(),
                Font.PLAIN, 20));
    }
    private void initializeComponents()
    {
        setSize(400, 120); // set frame size
        setLocationRelativeTo(null); // center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void registerEventHandlers()
    {
        ButtonHandler handler = new ButtonHandler();
        buttonUpdate.addActionListener(handler);
    }
    private void addComponentsToFrame()
    {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(labelScore, BorderLayout.NORTH);
        contentPane.add(labelOdds, BorderLayout.CENTER);
        contentPane.add(buttonUpdate, BorderLayout.SOUTH);
        setContentPane(contentPane);
    }
    private class ButtonHandler implements ActionListener
    {
        public ButtonHandler()
        {
        }
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == buttonUpdate)
            {
                String score = game.getScore();
                labelScore.setText(score);
                int homeScore = Integer.parseInt(score.substring(0,
                        score.indexOf("-") - 1).trim());
                int awayScore = Integer.parseInt(score.substring(
                        score.indexOf("-") + 1).trim());
                int diff = homeScore - awayScore;
                if (diff == 0)
                    labelOdds.setText("Odds for home team as winner: 1:1.5");
                else if (diff < 0)
                    labelOdds.setText("Odds for home team as winner: 1:"
                            + (-diff*2));
                else
                    labelOdds.setText("Odds for home team as winner: 1:1.2");

            }

        }

    }
    public void update(Observable arg0, Object arg1) {
        labelScore.setText(game.getScore());
    }
}