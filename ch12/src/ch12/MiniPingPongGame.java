package ch12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniPingPongGame extends JPanel implements KeyListener {

   protected Ball ball;
   protected Racquet racquet1;
   protected Racquet racquet2;
   protected Score score;
   protected int player1Score = 0, player2Score = 0;
// 다른 객체의 변수는 game.player1Score 이런씩으로 못씀 / 쓸려면 getter , setter 를 쓰든가 , 지금 내가 한거 처럼 써야함 , 내부클래스로 쓰면 그렇게 쓸수잇음
   public MiniPingPongGame() {
      ball = new Ball(this, Color.white); // this 맴버변수를 사용하기 위해
      this.setBackground(Color.black);
      racquet1 = new Racquet(this, 0, 150, Color.blue, 1);
      racquet2 = new Racquet(this, 570, 150, Color.yellow, 2);
      score = new Score(600, 400);
      this.setFocusable(true);
      this.addKeyListener(this);

   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);
      score.draw(g, player1Score, player2Score);
      Graphics2D g2D = (Graphics2D) g;
      ball.draw(g2D);
      racquet1.draw(g2D);
      racquet2.draw(g2D);
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void keyPressed(KeyEvent e) {
      racquet1.keyPressed(e);
      racquet2.keyPressed(e);
   }

   @Override
   public void keyReleased(KeyEvent e) {
      racquet1.KeyReleased(e);
      racquet2.KeyReleased(e);
   }

   public void move() {
      ball.move();
      racquet1.move();
      racquet2.move();
   }

   public static void main(String[] args) {

      JFrame frame = new JFrame();
      frame.setSize(600, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MiniPingPongGame game = new MiniPingPongGame();
      frame.add(game);
      frame.setVisible(true);

      while (true) {
         game.move();
         game.repaint();
         try {
            Thread.sleep(10);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

   }

}

class Ball {

   private static final int RADIUS = 20;
   protected int x = 0, y = 0, xSpeed = 1, ySpeed = 1;
   private MiniPingPongGame game;
   private Color color;

   public Ball(MiniPingPongGame game, Color color) {
      this.game = game;
      this.color = color;
   }

   public void draw(Graphics2D g) {
      g.setColor(color);
      g.fillOval(x, y, RADIUS, RADIUS);
   }

   public void move() {
      if (x + xSpeed < 0) {
         xSpeed = 1;
         game.player1Score++;
         System.out.println(game.player1Score + " player1");
      }
      if (x + xSpeed > game.getWidth() - 2 * RADIUS) { // 원의 지름 만큼 안에 있는가
         xSpeed = -1;
         game.player2Score++;
         System.out.println(game.player2Score + " player1");
      }
      if (y + ySpeed < 0)
         ySpeed = 1;
      if (y + ySpeed > game.getHeight() - 2 * RADIUS)
         ySpeed = -1;
      if (collision()) // 라켓에 부딪혔을때 좌우를 바꿔줌 (x의)
         xSpeed = -xSpeed;
      x += xSpeed;
      y += ySpeed;

   }

   public Rectangle getBounds() {
      return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS); // width ,height
   }

   private boolean collision() {
      return game.racquet1.getBounds().intersects(getBounds()) || game.racquet2.getBounds().intersects(getBounds());
   }

}

class Racquet {

   private static final int WIDTH = 15;
   private static final int HEIGHT = 80;
   private int x = 0, y = 0;
   private int ySpeed = 0;
   private MiniPingPongGame game;
   private Color color;
   private int id;

   public Racquet(MiniPingPongGame game, int x, int y, Color color, int id) {
      this.game = game;
      this.x = x;
      this.y = y;
      this.color = color;
      this.id = id;
   }

   public void move() {
      if (y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT) {
         y += ySpeed;
      }
   }

   public void draw(Graphics2D g) {
      g.setColor(color);
      g.fillRect(x, y, WIDTH, HEIGHT);

   }

   public void keyPressed(KeyEvent e) {
      if (id == 1) {
         if (e.getKeyCode() == KeyEvent.VK_UP) { // 기호상수
            ySpeed = -3;
         } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ySpeed = 3;
         }
      }
      if (id == 2) {
         if (e.getKeyCode() == KeyEvent.VK_W) {
            ySpeed = -3;
         } else if (e.getKeyCode() == KeyEvent.VK_S) {
            ySpeed = 3;
         }
      }

   }

   public void KeyReleased(KeyEvent e) {
      ySpeed = 0;
   }

   public Rectangle getBounds() {
      return new Rectangle(x, y, WIDTH, HEIGHT);
   }

}

class Score {
   private static int GAME_WIDTH;
   private static int GAME_HEIGHT;
   private int score1 , score2;

   public Score(int gameWidth, int gameHeight) {
      GAME_WIDTH = gameWidth;
      GAME_HEIGHT = gameHeight;
   }

   public void draw(Graphics g, int player1Score , int player2Score) {
      score1 = player1Score;
      score2 = player2Score;
      g.setColor(Color.white);
      g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60)); // String name, int style, int size

      g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);// 시작 점 부터 끝점 좌표인듯
      
      g.drawString(String.valueOf(score1 / 10) + String.valueOf(score1 % 10),
            GAME_WIDTH / 2 - 85, 50);
      g.drawString(String.valueOf(score2 / 10) + String.valueOf(score2 % 10),
            GAME_WIDTH / 2 + 20, 50);
   }

}