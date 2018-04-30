package temperature.view;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;

import temperature.controller.TemperatureController;
public class GuiTemperature extends JFrame implements
        TemperatureView
{
    private JLabel labelTemperature;
    private JButton buttonUpdate;
    // model facade class
    private TemperatureController controller;
    public GuiTemperature()
    {
        super("Temperature presenter");
        labelTemperature = new JLabel("No data");
        buttonUpdate = new JButton("Update");
        labelTemperature.setFont(new Font("Helvetica", Font.PLAIN, 20));
        buttonUpdate.setFont(new Font("Helvetica", Font.PLAIN, 20));
        setSize(350, 120); // set frame size
        setLocationRelativeTo(null); // center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel(new BorderLayout(0, 5));
        contentPane.add(buttonUpdate, BorderLayout.NORTH);
        contentPane.add(labelTemperature);
        setContentPane(contentPane);
    }
    public void startView(TemperatureController controller)
    {
        this.controller = controller;
        GuiButtonHandler handler = new GuiButtonHandler(controller);
        buttonUpdate.addActionListener(handler);
        super.setVisible(true);
    }
    @Override
    public void show(String text)
    {
        labelTemperature.setText(text);
    }
    public void update(Observable who,Object what) {
        controller.execute(what.toString());
    }
}