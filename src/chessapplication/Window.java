package chessapplication;

import chessapplication.util.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Window extends JFrame {

    private final JPanel mainPanel = new JPanel();
    private final JLabel mainLabel = new JLabel();
    private final JButton newButton = new JButton();
    private final JButton saveButton = new JButton();
    private final JButton loadButton = new JButton();
    private final JButton[][] chessButtons = new JButton[8][8];
    private final Game game;
    private final Font montserrat = new Font("Montserrat Light", 1, 12);

    private Board board;
    private Peice peiceSelected;

    public Window(Game g) {
        game = g;
        init();
    }

    private void init() {
        setTitle("Chess Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(34, 36, 38));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Montserrat Light", 0, 18));
        setMaximumSize(new Dimension(800, 1000));
        setMinimumSize(new Dimension(500, 600));
        setPreferredSize(new Dimension(625, 800));
        setSize(new Dimension(625, 800));

        mainLabel.setText("Chess");
        mainLabel.setFont(montserrat);
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setVerticalAlignment(SwingConstants.TOP);

        newButton.setText("New Game");
        newButton.setFont(montserrat);
        newButton.setBackground(new Color(0, 153, 204));
        newButton.setBounds(0, 50, 150, 25);
        newButton.addActionListener((ActionEvent e) -> {
            game.create();
        });

        saveButton.setText("Save");
        saveButton.setFont(montserrat);
        saveButton.setBackground(new Color(0, 153, 204));
        saveButton.setBounds(0, 75, 150, 25);
        saveButton.addActionListener((ActionEvent e) -> {
            game.SaveGame();
        });

        loadButton.setText("Load");
        loadButton.setFont(montserrat);
        loadButton.setBackground(new Color(0, 153, 204));
        loadButton.setBounds(0, 100, 150, 25);
        loadButton.addActionListener((ActionEvent e) -> {
            game.LoadGame();
        });

        mainPanel.setSize(600, 600);
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        mainPanel.setLayout(new GridLayout(8, 8, 1, 1));
        mainPanel.setBounds(0, 150, mainPanel.getSize().width, mainPanel.getSize().height);

        for (int i = 0; i < chessButtons.length; i++) {
            for (int j = 0; j < chessButtons[i].length; j++) {
                chessButtons[i][j] = new JButton();
                chessButtons[i][j].setBorder(null);
                chessButtons[i][j].setBorderPainted(false);
                chessButtons[i][j].setSize(64, 64);
                chessButtons[i][j].setMargin(new Insets(0, 0, 0, 0));
                chessButtons[i][j].setPreferredSize(new Dimension(64, 64));
                chessButtons[i][j].setMinimumSize(new Dimension(32, 32));
                chessButtons[i][j].setMaximumSize(new Dimension(128, 128));
                chessButtons[i][j].setRolloverEnabled(true);
                chessButtons[i][j].addActionListener((ActionEvent e) -> {
                    ButtonHandlerFunc(e);
                });
                Color c;
                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        c = Color.GRAY;
                    } else {
                        c = Color.DARK_GRAY;
                    }
                } else {
                    if (j % 2 == 0) {
                        c = Color.DARK_GRAY;
                    } else {
                        c = Color.GRAY;
                    }
                }
                chessButtons[i][j].setBackground(c);

                mainPanel.add(chessButtons[i][j]);
            }
        }

        add(mainPanel);

        add(newButton);
        add(saveButton);
        add(loadButton);

        add(mainLabel);
    }

    public void UpdateAndDisplayGUI(Board b) {
        board = b;
        for (int i = 0; i < chessButtons.length; i++) {
            for (int j = 0; j < chessButtons[i].length; j++) {
                Peice p = b.getBoard()[i][j];
                if (p != null) {
                    chessButtons[i][j].setIcon(Utils.resizeIcon(new ImageIcon(this.getClass().getResource(p.imgPath)), chessButtons[i][j].getSize().width, chessButtons[i][j].getSize().height));
                    chessButtons[i][j].repaint();
                    System.out.println("Displaying Peice" + p);
                } else {
                    chessButtons[i][j].setIcon(null);
                }
            }
        }
    }

    //Add Functionality for Deselection
    public void ButtonHandlerFunc(ActionEvent e) {
        for (int i = 0; i < chessButtons.length; i++) {
            for (int j = 0; j < chessButtons[i].length; j++) {
                if (e.getSource() == chessButtons[i][j]) {
                    
                    if (peiceSelected != null) {
                        if (board.getBoard()[i][j] == null) {
                            if (peiceSelected.canMoveTo(i, j)) {
                                chessButtons[peiceSelected.getX()][peiceSelected.getY()].setIcon(null);
                                peiceSelected.moveTo(i, j);
                                game.turn = false;
                                chessButtons[i][j].setIcon(Utils.resizeIcon(new ImageIcon(this.getClass().getResource(peiceSelected.imgPath)), chessButtons[i][j].getSize().width, chessButtons[i][j].getSize().height));
                                peiceSelected = null;
                                setMsg("Selct Peice to Move");
                            } else {
                                setMsg("Invalid Move, Please Select Again");
                            } 
                               
                        } else {
                            setMsg("Invalid Select, Deselect, select a white space");
                        }
                    } else {
                        if (board.getBoard()[i][j] != null) {
                            peiceSelected = board.getBoard()[i][j];
                            if (peiceSelected.getTeam().name() != game.getCurrentPlayer().getColor().name()) {
                                peiceSelected = null;
                                setMsg("Invalid Selection, Please Select Again");
                            } else {
                                setMsg("Select Place to Move");
                            }  
                        }
                    }

                }
            }
        }

    }

    public void setMsg(String msg) {
        mainLabel.setText(msg);
    }

    public void DisplayPopup(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    public String DisplayPopupInput(String msg) {
        String in = JOptionPane.showInputDialog(rootPane, msg);
        return in;
    }

    public int DisplayPopupDecision(String msg) {
        int in = JOptionPane.showConfirmDialog(rootPane, msg);
        return in;
    }
}
