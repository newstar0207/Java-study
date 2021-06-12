package ch13;



import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePuzzle extends JFrame implements ActionListener , MouseListener{
    private int pieces = 4;
    private int totalPieces = pieces * pieces;
    private BufferedImage img;
    private ArrayList<Integer> pieceNums = new ArrayList<>();
    

    public static void main(String[] args) {
        new ImagePuzzle();
    }

    public ImagePuzzle() { // constructor
        this.setTitle("Puzzle Game");
        try {
            img = ImageIO.read(new File("C:\\img.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        // shuffle();
        for (int i = 0; i < totalPieces; i++)
            pieceNums.add(i);

        this.add(new ImagePanel(), BorderLayout.CENTER);
        JButton imgDivideBtn = new JButton("이미지 쪼개기");
        this.add(imgDivideBtn, BorderLayout.SOUTH);

        imgDivideBtn.addActionListener(this);
        this.setSize(img.getWidth(), img.getHeight()+30);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void shuffle() {
        Collections.shuffle(pieceNums);

        System.out.println(pieceNums);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       shuffle();
       repaint();

    }

    class ImagePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int pieceWidth = img.getWidth() / pieces;
            int pieceHeight = img.getHeight() / pieces;

            for (int x = 0; x < pieces; x++) {
                for (int y = 0; y < pieces; y++) {
                    int sx = pieceNums.get(x*pieces + y)/pieces * pieceWidth; // 교과서 를 합친 표현.
                    int sy = pieceNums.get(x*pieces + y)%pieces * pieceHeight;

                    int dx = x * pieceWidth;
                    int dy = y * pieceHeight;

                    g.drawImage(img, dx, dy, dx+pieceWidth, dy+pieceHeight, sx, sy, sx+pieceWidth, sy+pieceHeight, null);
                }
            }
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
    
    
    
}


