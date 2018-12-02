package RogLike;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
   private Image img;

   public ImagePanel(Image img) {
      this.img = img;
      setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
      setLayout(null);
   }

   public void paintComponent(Graphics g) {
      g.drawImage(img, 0, 0, null);
   }
}

class Monster {
   private int Level;
   private int HP;
   private int ATK;

   Monster(int Level, int HP, int ATK) {
      this.Level = Level;
      this.HP = HP;
      this.ATK = ATK;
   }

   int getLevel() {
      return Level;
   }

   int getHP() {
      return HP;
   }

   int getATK() {
      return HP;
   }

   void setHP(int HP) {
      this.HP = HP;
   }
}

class Hero {
   private int MainLevel;
   private int MainHP;
   private int MainATK;
   private int MainEXP;

   public Hero(int Level, int HP, int ATK) {
      MainLevel = Level;
      MainHP = HP;
      MainATK = ATK;
      MainEXP = 0;
   }

   int getMainLevel() {
      return MainLevel;
   }

   int getMainHP() {
      return MainHP;
   }

   int getMainATK() {
      return MainATK;
   }

   int getEXP() {
      return MainEXP;
   }

   void increaseLevel() {
      MainLevel++;
   }

   void increaseHP() {
      MainHP = MainHP + 50;
   }

   void increaseATK() {
      MainATK = MainATK + 10;
   }

   void increaseEXP(int EXP) {
      MainEXP = MainEXP + EXP;
   }
   
   void decreaseHP(int ATK) {
      MainHP = MainHP - ATK; 
   }
   
   void HealHP() {
      MainHP = 50 + getMainLevel()*50;
   }

   void setEXP() {
      MainEXP = 0;
   }

}

public class FrameMain extends JFrame {

   Random rd = new Random();
   int R = rd.nextInt(10);

   private JLabel ENEMY = new JLabel("");
   private JLabel EnemyHP = new JLabel("HP :");
   private JLabel EnemyATK = new JLabel("ATK :");
   private JLabel EnemyLevel = new JLabel("LEVEL :");

   private JLabel MainUnit2 = new JLabel("MainUnit");
   private JLabel MainUnitHp = new JLabel("HP : ");
   private JLabel MainUnitAtk = new JLabel("ATK : ");
   private JLabel MainUnitLevel = new JLabel("LEVEL : ");
   private JLabel MainUnitEXP = new JLabel("EXP : ");

   public FrameMain() {

      Monster Level1 = new Monster(1, 50, 10);
      Monster Level2 = new Monster(2, 100, 20);
      Monster Level3 = new Monster(3, 150, 30);
      Monster LevelBoss = new Monster(999, 300, 40);
      Hero Heroo = new Hero(1, 100, 10);

      setTitle("용사 키우기");
      setSize(960, 1000);
      setVisible(true);
      setResizable(false);
      getContentPane().setLayout(new GridLayout(2, 1, 10, 10));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ImagePanel panel1 = new ImagePanel(
            new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\background.png").getImage());

      JPanel panel2 = new JPanel();
      panel2.setLayout(null);
      panel2.setSize(960, 455);
      panel2.setBackground(Color.GRAY);

      getContentPane().add(panel1);
      getContentPane().add(panel2);

      ENEMY.setBounds(582, 12, 319, 233);
      panel2.add(ENEMY);

      EnemyHP.setBounds(451, 87, 62, 18);
      panel2.add(EnemyHP);

      EnemyATK.setBounds(451, 128, 62, 18);
      panel2.add(EnemyATK);

      EnemyLevel.setBounds(451, 170, 62, 18);
      panel2.add(EnemyLevel);

      MainUnit2.setBounds(81, 379, 62, 18);
      panel2.add(MainUnit2);

      MainUnitHp.setBounds(322, 284, 62, 18);
      panel2.add(MainUnitHp);
      MainUnitHp.setText("HP : " + String.valueOf(Heroo.getMainHP()));

      MainUnitAtk.setBounds(322, 314, 62, 18);
      panel2.add(MainUnitAtk);
      MainUnitAtk.setText("ATK : " + String.valueOf(Heroo.getMainATK()));

      MainUnitLevel.setBounds(322, 344, 62, 18);
      panel2.add(MainUnitLevel);
      MainUnitLevel.setText("Level : " + String.valueOf(Heroo.getMainLevel()));

      MainUnitEXP.setBounds(322, 379, 62, 18);
      panel2.add(MainUnitEXP);
      MainUnitEXP.setText("EXP : " + String.valueOf(Heroo.getEXP()));

      JButton ATK = new JButton("ATTACK");
      ATK.setBounds(607, 284, 294, 144);
      ATK.setFocusable(false);
      panel2.add(ATK);

      JLabel MainUnit = new JLabel();
      MainUnit.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\Red.png"));
      MainUnit.setBounds(95, 373, 49, 77);
      panel1.add(MainUnit);

      MainUnit.requestFocus();
      MainUnit.addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
            int x = MainUnit.getX();
            int y = MainUnit.getY();

            if (e.getKeyCode() == 37) { // 왼쪽키 눌렀을 때
               if (x >= 672 && x <= 870 && y >= 219 && y <= 375) { // 보스와 만남
                  System.out.println("보스와의 전투를 시작합니다.");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                  EnemyHP.setText("HP : " + String.valueOf(LevelBoss.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(LevelBoss.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(LevelBoss.getLevel()));
                  MainUnit.setLocation(670, 310);
               } else if (x >= 370 && x <= 490 && y >= 322 && y <= 450) {// 회복과 만남
                  MainUnit.setLocation(429, 321);
                  Heroo.HealHP();
                  MainUnitHp.setText("HP : " + String.valueOf(Heroo.getMainHP()));
               }
               
               else {
                  MainUnit.setLocation(x - 10, y);
                  if (x < 0)
                     MainUnit.setLocation(x + 1, y);
               }
            } else if (e.getKeyCode() == 38) { // 위쪽 키 눌렀을 때
               if (y >= 219 && y <= 375 && x >= 672 && x <= 870) { // 보스와 만남
                  System.out.println("보스와의 전투를 시작합니다.");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                  EnemyHP.setText("HP : " + String.valueOf(LevelBoss.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(LevelBoss.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(LevelBoss.getLevel()));
                  MainUnit.setLocation(670, 310);
                  MainUnit.setFocusable(false);
               } else {
                  MainUnit.setLocation(x, y - 10);
                  if (y < 0)
                     MainUnit.setLocation(x, y + 1);
               }
            } else if (e.getKeyCode() == 39) { // 오른쪽키 눌렀을 때
               if (x >= 670 && y >= 219 && y <= 375) { // 보스와 만남
                  System.out.println("보스와의 전투를 시작합니다.");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                  EnemyHP.setText("HP : " + String.valueOf(LevelBoss.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(LevelBoss.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(LevelBoss.getLevel()));
                  MainUnit.setLocation(670, 310);
                  MainUnit.setFocusable(false);
               } else if (x <= 490 && x >= 370 && y >= 322 && y <= 450) // 회복과 만남
                  MainUnit.setLocation(429, 321);
               else {
                  MainUnit.setLocation(x + 10, y);
                  if (x > 905)
                     MainUnit.setLocation(x - 1, y);
               }
            } else if (e.getKeyCode() == 40) { // 아래쪽 키 눌렀을 때
               if (y >= 219 && x >= 672 && x <= 870) { // 보스와 만남
                  System.out.println("보스와의 전투를 시작합니다.");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                  EnemyHP.setText("HP : " + String.valueOf(LevelBoss.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(LevelBoss.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(LevelBoss.getLevel()));
                  MainUnit.setLocation(670, 310);
                  MainUnit.setFocusable(false);
               } else if (y >= 322 && x >= 380 && x <= 450) // 회복과 만남
                  MainUnit.setLocation(429, 321);
               else {
                  MainUnit.setLocation(x, y + 10);
                  if (y > 400)
                     MainUnit.setLocation(x, y - 1);
               }
            }

            if (x >= 0 && y >= 0 && x <= 270 && y <= 120) {
               if (R <= 0) {
                  System.out.println(R + "  몬스터 조우!");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\LEVEL1.png"));
                  EnemyHP.setText("HP : " + String.valueOf(Level1.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(Level1.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(Level1.getLevel()));
                  MainUnit.setFocusable(false);
               }
               R = rd.nextInt(9);
            } else if (x >= 320 && y >= 0 && x <= 590 && y <= 120) {
               if (R <= 0) {
                  System.out.println(R + "  몬스터 조우!");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\LEVEL2.png"));
                  EnemyHP.setText("HP : " + String.valueOf(Level2.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(Level2.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(Level2.getLevel()));
                  MainUnit.setFocusable(false);
               }
               R = rd.nextInt(9);
            } else if (x >= 641 && y >= 0 && x <= 905 && y <= 120) {
               if (R <= 0) {
                  System.out.println(R + "  몬스터 조우!");
                  ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\LEVEL3.png"));
                  EnemyHP.setText("HP : " + String.valueOf(Level3.getHP()));
                  EnemyATK.setText("ATK : " + String.valueOf(Level3.getATK()));
                  EnemyLevel.setText("Level : " + String.valueOf(Level3.getLevel()));
                  MainUnit.setFocusable(false);
               }
               R = rd.nextInt(9);
            }
         }
      });

      JLabel Heal = new JLabel("Heal");
      Heal.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\Heal.png"));
      Heal.setBounds(419, 391, 71, 86);
      panel1.add(Heal);

      JLabel Boss = new JLabel();
      Boss.setBounds(715, 250, 165, 166);
      panel1.add(Boss);
      Boss.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOss3.gif"));

   }

   public static void main(String arg[]) {
      @SuppressWarnings("unused")
      FrameMain Frame = new FrameMain();
      Frame.setVisible(true);
   }
}
