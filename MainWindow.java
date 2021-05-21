package dz8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private int winWidth = 800;
    private int winHeigth = 600;

    private int minMapSize = 3;
    private int maxMapSize = 10;
    private int minWinLength = 3;

    private JButton btnStartGame;
    private JButton btnExitGame;
    private JButton btnClearLog;

    private JPanel panelSettings;
    private JPanel panelControls;

    private GameMap gameMap;

    private JLabel labelMapSize;
    private JLabel labelWinLength;

    private JTextArea gameLog;
    private JScrollPane scrollPane;

    private String mapSizePrefix = "Map size is ";
    private String winLengthPrefix = "Win length is ";

    private JSlider sliderMapSizeSetting;
    private JSlider sliderWinLengthSetting;

    private int round = 0;

    MainWindow() {

        prepareWindow();
        prepareButtons();

        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 1));

        prepareSettings();
        prepareGameLog();

        panelSettings.add(panelControls);
        panelSettings.add(scrollPane);

        gameMap = new GameMap(this);
        add(gameMap);
        add(panelSettings, BorderLayout.EAST);

        setVisible(true);

    }

    private void prepareWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenSizeW = dimension.width;
        int screenSizeH = dimension.height;
        setLocation(screenSizeW / 2 - winWidth / 2, screenSizeH / 2 - winHeigth / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeigth);
        setTitle("GameXO");
        setResizable(false);
    }

    private void prepareButtons() {
        btnStartGame = new JButton("Start Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        btnExitGame = new JButton("Exit Game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClearLog = new JButton("Clear log");
        btnClearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLog.setText(" ");
            }
        });
    }

    private void startGame() {
        int mapSize = sliderMapSizeSetting.getValue();
        int winLength = sliderWinLengthSetting.getValue();
        ++round;
        log("Round: " + round);
        log("New game " + mapSize + mapSize + " win " + winLength);

        gameMap.startGameWithUserSettings(mapSize, mapSize, winLength);

    }

    private void prepareSettings() {
        panelControls = new JPanel();
        panelControls.setLayout(new GridLayout(8, 1));
        mapSetupControllers();
        panelControls.add(labelMapSize);
        panelControls.add(sliderMapSizeSetting);
        panelControls.add(labelWinLength);
        panelControls.add(sliderWinLengthSetting);
        panelControls.add(btnStartGame);
        panelControls.add(btnExitGame);
        panelControls.add(btnClearLog);

    }

    private void mapSetupControllers() {
        labelMapSize = new JLabel(mapSizePrefix + minMapSize);
        labelWinLength = new JLabel(winLengthPrefix + minWinLength);
        sliderMapSizeSetting = new JSlider(minMapSize, maxMapSize, minMapSize);
        sliderMapSizeSetting.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentMapSize = sliderMapSizeSetting.getValue();
                labelMapSize.setText(mapSizePrefix + currentMapSize);
                sliderWinLengthSetting.setMaximum(currentMapSize);

            }
        });
        sliderWinLengthSetting = new JSlider(minWinLength, minMapSize, minMapSize);
        sliderWinLengthSetting.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(winLengthPrefix + sliderWinLengthSetting.getValue());
            }
        });

    }

    private void prepareGameLog() {
        gameLog = new JTextArea();
        scrollPane = new JScrollPane(gameLog);
        gameLog.setEnabled(false);
        gameLog.setLineWrap(true);
    }

    void log(String text) {
        gameLog.append(text + "\n");
    }
}
