import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class myuzik extends JFrame implements ActionListener {

    private JButton playButton, stopButton, resetButton, quitButton;
    private Clip clip;

    public myuzik() {
        setTitle("Myuzik Pleya");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        quitButton = new JButton("Quit");

        playButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        quitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.CENTER);

        try {
            File file = new File("the_avengers_cypher_katapilla_x_khaligraph_og_jones_official_video_mp3_66298.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            clip.start();
        } else if (e.getSource() == stopButton) {
            clip.stop();
        } else if (e.getSource() == resetButton) {
            clip.setMicrosecondPosition(0);
        } else if (e.getSource() == quitButton) {
            JOptionPane.showMessageDialog(null, "Goodbye!");
            clip.close();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new myuzik().setVisible(true);
            }
        });
    }
}
