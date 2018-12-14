package RogLike;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.text.Font;
import javazoom.jl.player.Player;
import sun.applet.Main;

class Enemy {

   public int HP;
   public int ATK;
   public int LEVEL;

   public Enemy() {
   }

   public Enemy(int HP, int ATK, int LEVEL) {
      this.HP = HP;
      this.ATK = ATK;
      this.LEVEL = LEVEL;
   }

   public int getHP() {
      return HP;
   }

   public void setHP(int hP) {
      HP = hP;
   }

   public int getATK() {
      return ATK;
   }

   public void setATK(int aTK) {
      ATK = aTK;
   }

   public int getLEVEL() {
      return LEVEL;
   }

   public void setLEVEL(int lEVEL) {
      LEVEL = lEVEL;
   }

}

class HR {

   private int HP;
   private int ATK;
   private int LEVEL;
   private int EXP;

   public HR() {
   }

   public HR(int HP, int ATK, int LEVEL, int EXP) {
      this.HP = HP;
      this.ATK = ATK;
      this.LEVEL = LEVEL;
      this.EXP = EXP;
   }

   public boolean isPossibleLevelUp() {
      switch (LEVEL) {
      case 1:
         if (EXP >= 100)
            return true;
      case 2:
         if (EXP >= 110)
            return true;
      case 3:
         if (EXP >= 120)
            return true;
      case 4:
         if (EXP >= 130)
            return true;
      case 5:
         if (EXP >= 140)
            return true;
      case 6:
         if (EXP >= 150)
            return true;
      case 7:
         if (EXP >= 160)
            return true;
      case 8:
         if (EXP >= 170)
            return true;
      case 9:
         if (EXP >= 180)
            return true;
      }
      return false;
   }

   public void levelUp() {
      switch (LEVEL) {
      case 1:
         if (EXP >= 100) {
            EXP -= 100;
            ATK += 5;
            HP += 50;
         }
      case 2:
         if (EXP >= 110) {
            EXP -= 110;
            ATK += 5;
            HP += 50;
         }
      case 3:
         if (EXP >= 120) {
            EXP -= 120;
            ATK += 5;
            HP += 50;
         }
      case 4:
         if (EXP >= 130) {
            EXP -= 130;
            ATK += 5;
            HP += 50;
         }
      case 5:
         if (EXP >= 140) {
            EXP -= 140;
            ATK += 5;
            HP += 50;
         }
      case 6:
         if (EXP >= 150) {
            EXP -= 150;
            ATK += 5;
            HP += 50;
         }
      case 7:
         if (EXP >= 160) {
            EXP -= 160;
            ATK += 5;
            HP += 50;
         }
      case 8:
         if (EXP >= 170) {
            EXP -= 170;
            ATK += 5;
            HP += 50;
         }
      case 9:
         if (EXP >= 180) {
            EXP -= 180;
            ATK += 5;
            HP += 50;
         }
      }
      LEVEL = LEVEL + 1;
   }

   public boolean isLive() {
      if (HP <= 0)
         return false;
      else
         return true;
   }

   public int getHP() {
      return HP;
   }

   public void setHP(int hP) {
      HP = hP;
   }

   public int getATK() {
      return ATK;
   }

   public void setATK(int aTK) {
      ATK = aTK;
   }

   public int getLEVEL() {
      return LEVEL;
   }

   public void setLEVEL(int lEVEL) {
      LEVEL = lEVEL;
   }

   public int getEXP() {
      return EXP;
   }

   public void setEXP(int eXP) {
      EXP = eXP;
   }

   public void HealHP() {
      HP = 50 + getLEVEL() * 50;
   }

}

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

class Music extends Thread {
   private Player player;
   private boolean isLoop;
   private File file;
   private FileInputStream fis;
   private BufferedInputStream bis;

   public Music(String name, boolean isLoop) {
      try {
         this.isLoop = isLoop;
         file = new File(
               FrameMain.class.getResource("../ProjectFile/" + name).toURI());
         fis = new FileInputStream(file);
         bis = new BufferedInputStream(fis);
         player = new Player(bis);
      } catch (Exception e) {
         System.out.println("오류!");
      }
   }

   public void run() {
      try {
         do {
	    fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
	    
         } while (isLoop);
      } catch (Exception e) {
         System.out.println();
      }

   }
}

   public class FrameMain extends JFrame {
      HR A = new HR(100, 10, 1, 0);
      Enemy E1 = new Enemy(50, 10, 1);
      Enemy E2 = new Enemy(100, 20, 2);
      Enemy E3 = new Enemy(150, 30, 3);
      Enemy E4 = new Enemy(300, 40, 999);

      Random rd = new Random();
      int R = rd.nextInt(10);

      private JLabel ENEMY = new JLabel("");
      private JLabel EnemyHP = new JLabel("HP :");
      private JLabel EnemyATK = new JLabel("ATK :");
      private JLabel EnemyLevel = new JLabel("LEVEL :");

      private JLabel MainUnit2 = new JLabel("");
      private JLabel MainUnitHp = new JLabel("HP : ");
      private JLabel MainUnitAtk = new JLabel("ATK : ");
      private JLabel MainUnitLevel = new JLabel("LEVEL : ");
      private JLabel MainUnitEXP = new JLabel("EXP : ");

      private int elv = 0;
      private int Aatk = A.getATK();
      private int Ahp = A.getHP();
      private int Eatk, Ehp;

      public FrameMain() {

         setTitle("용사 키우기");
         setSize(960, 1000);
         setResizable(false);
         getContentPane().setLayout(new GridLayout(2, 1, 10, 10));
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         ImagePanel panel1 = new ImagePanel(
               new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\Background.png").getImage());

         Music bgm = new Music("bossbattle.mp3", true);
         bgm.start();

         JPanel panel2 = new JPanel();
         panel2.setLayout(null);
         panel2.setSize(960, 455);
         panel2.setBackground(Color.GRAY);

         getContentPane().add(panel1);
         getContentPane().add(panel2);

         ENEMY.setBounds(582, 12, 319, 233);
         panel2.add(ENEMY);

         EnemyHP.setBounds(451, 87, 100, 18);
         EnemyHP.setFont(EnemyHP.getFont().deriveFont(15.f));
         panel2.add(EnemyHP);

         EnemyATK.setBounds(451, 128, 100, 18);
         EnemyATK.setFont(EnemyATK.getFont().deriveFont(15.f));
         panel2.add(EnemyATK);

         EnemyLevel.setBounds(451, 170, 100, 18);
         EnemyLevel.setFont(EnemyLevel.getFont().deriveFont(15.f));
         panel2.add(EnemyLevel);

         MainUnit2 = new JLabel("");
         MainUnit2.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\Gold3.png"));
         MainUnit2.setBounds(24, 220, 272, 245);
         panel2.add(MainUnit2);

         MainUnitHp.setBounds(322, 284, 100, 18);
         MainUnitHp.setFont(MainUnitHp.getFont().deriveFont(15.f));
         panel2.add(MainUnitHp);
         MainUnitHp.setText("HP : " + A.getHP());

         MainUnitAtk.setBounds(322, 314, 100, 18);
         MainUnitAtk.setFont(MainUnitAtk.getFont().deriveFont(15.f));
         panel2.add(MainUnitAtk);
         MainUnitAtk.setText("ATK : " + A.getATK());

         MainUnitLevel.setBounds(322, 344, 100, 18);
         MainUnitLevel.setFont(MainUnitLevel.getFont().deriveFont(15.f));
         panel2.add(MainUnitLevel);
         MainUnitLevel.setText("Level : " + A.getLEVEL());

         MainUnitEXP.setBounds(322, 379, 100, 18);
         MainUnitEXP.setFont(MainUnitEXP.getFont().deriveFont(15.f));
         panel2.add(MainUnitEXP);
         MainUnitEXP.setText("EXP : " + A.getEXP());

         JButton ATK = new JButton("ATTACK");
         ATK.setBounds(607, 284, 294, 144);
         ATK.setEnabled(false);
         ATK.setFocusable(false);
         panel2.add(ATK);

         JLabel MainUnit = new JLabel();
         MainUnit.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\Red.png"));
         MainUnit.setBounds(95, 373, 49, 77);
         panel1.add(MainUnit);

         ATK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
               if (elv == 1) {

                  Aatk = A.getATK();
                  Eatk = E1.getATK();
                  Ehp = E1.getHP();
                  if (Ahp > 0 && Ehp > 0) {
                     System.out.println("Hero Hit!!");
                     Ehp -= Aatk;
                     if (Ehp <= 0)
                        Ehp = 0;
                     E1.setHP(Ehp);
                     EnemyHP.setText("HP : " + Ehp);

                  }
                  if (Ehp > 0) {
                     System.out.println("Enemy Hit!!");
                     Ahp = A.getHP();
                     Ahp -= Eatk;
                     if (Ahp <= 0)
                        Ahp = 0;
                     A.setHP(Ahp);
                     MainUnitHp.setText("HP : " + Ahp);

                  } else {
                     System.out.println("Enemy is Dead!!");
                     JOptionPane.showMessageDialog(null, "몬스터를 처치 하였습니다!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     ENEMY.setIcon(null);
                     EnemyHP.setText("HP : ");
                     EnemyATK.setText("ATK : ");
                     EnemyLevel.setText("LEVEL : ");
                     A.setEXP(A.getEXP() + 20);
                     System.out.println("+ 20EXP!!");
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setFocusable(true);
                     MainUnit.grabFocus();
                     ATK.setEnabled(false);
                  }
               } else if (elv == 2) {
                  Aatk = A.getATK();
                  Eatk = E2.getATK();
                  Ehp = E2.getHP();
                  if (Ahp > 0 && Ehp > 0) {
                     System.out.println("Hero Hit!!");
                     Ehp -= Aatk;
                     if (Ehp <= 0)
                        Ehp = 0;
                     E2.setHP(Ehp);
                     EnemyHP.setText("HP : " + Ehp);

                  }
                  if (Ehp > 0) {
                     System.out.println("Enemy Hit!!");
                     Ahp = A.getHP();
                     Ahp -= Eatk;
                     if (Ahp <= 0)
                        Ahp = 0;
                     A.setHP(Ahp);
                     MainUnitHp.setText("HP : " + Ahp);

                  } else {
                     System.out.println("Enemy is Dead!!");
                     JOptionPane.showMessageDialog(null, "몬스터를 처치 하였습니다!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     ENEMY.setIcon(null);
                     EnemyHP.setText("HP : ");
                     EnemyATK.setText("ATK : ");
                     EnemyLevel.setText("LEVEL : ");
                     A.setEXP(A.getEXP() + 40);
                     System.out.println("+ 40EXP!!");
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setFocusable(true);
                     MainUnit.grabFocus();
                     ATK.setEnabled(false);
                  }
               } else if (elv == 3) {
                  Aatk = A.getATK();
                  Eatk = E3.getATK();
                  Ehp = E3.getHP();
                  if (Ahp > 0 && Ehp > 0) {
                     System.out.println("Hero Hit!!");
                     Ehp -= Aatk;
                     if (Ehp <= 0)
                        Ehp = 0;
                     E3.setHP(Ehp);
                     EnemyHP.setText("HP : " + Ehp);

                  }
                  if (Ehp > 0) {
                     System.out.println("Enemy Hit!!");
                     Ahp = A.getHP();
                     Ahp -= Eatk;
                     if (Ahp <= 0)
                        Ahp = 0;
                     A.setHP(Ahp);
                     MainUnitHp.setText("HP : " + Ahp);

                  } else {
                     System.out.println("Enemy is Dead!!");
                     JOptionPane.showMessageDialog(null, "몬스터를 처치 하였습니다!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     ENEMY.setIcon(null);
                     EnemyHP.setText("HP : ");
                     EnemyATK.setText("ATK : ");
                     EnemyLevel.setText("LEVEL : ");
                     A.setEXP(A.getEXP() + 60);
                     System.out.println("+ 60EXP!!");
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setFocusable(true);
                     MainUnit.grabFocus();
                     ATK.setEnabled(false);
                  }
               } else if (elv == 999) {
                  Aatk = A.getATK();
                  Eatk = E4.getATK();
                  Ehp = E4.getHP();
                  if (Ahp > 0 && Ehp > 0) {
                     System.out.println("Hero Hit!!");
                     Ehp -= Aatk;
                     if (Ehp <= 0)
                        Ehp = 0;
                     E4.setHP(Ehp);
                     EnemyHP.setText("HP : " + Ehp);

                  }
                  if (Ehp > 0) {
                     System.out.println("Enemy Hit!!");
                     Ahp = A.getHP();
                     Ahp -= Eatk;
                     if (Ahp <= 0)
                        Ahp = 0;
                     A.setHP(Ahp);
                     MainUnitHp.setText("HP : " + Ahp);

                  } else {
                     JOptionPane.showMessageDialog(null, "클리어!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     System.out.println("Game Clear!!");
                     ENEMY.setIcon(null);
                     EnemyHP.setText("HP : ");
                     EnemyATK.setText("ATK : ");
                     EnemyLevel.setText("LEVEL : ");
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setFocusable(true);
                     ATK.setFocusable(false);
                     System.exit(0);
                  }
               }

               if (A.isPossibleLevelUp()) {
                  JOptionPane.showMessageDialog(null, "레벨 업!", "Message",

                        JOptionPane.WARNING_MESSAGE);
                  System.out.println("Hero get Level Up!");
                  A.levelUp();
                  MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                  MainUnitHp.setText("HP : " + A.getHP());
                  MainUnitAtk.setText("ATK : " + A.getATK());
                  MainUnitEXP.setText("EXP : " + A.getEXP());

               }
               if (A.isLive() == false) {
                  JOptionPane.showMessageDialog(null, "게임 오버!", "Message",

                        JOptionPane.WARNING_MESSAGE);
                  System.exit(0);
               }
               Music atkSound = new Music("effect.mp3",false);
               atkSound.start();
            }
         });
         
         MainUnit.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
               int x = MainUnit.getX();
               int y = MainUnit.getY();

               if (e.getKeyCode() == 37) { // 왼쪽키 눌렀을 때
                  if (x >= 672 && x <= 870 && y >= 219 && y <= 375) {
                     JOptionPane.showMessageDialog(null, "보스 등장!", "Message",

                           JOptionPane.WARNING_MESSAGE);// 보스와 만남
                     E4.setHP(300);
                     MainUnit.setFocusable(false);
                     ATK.setFocusable(true);
                     elv = E4.getLEVEL();
                     System.out.println("보스와의 전투를 시작합니다.");
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                     EnemyHP.setText("HP : " + E4.getHP());
                     EnemyATK.setText("ATK : " + E4.getATK());
                     EnemyLevel.setText("Level : " + E4.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setLocation(670, 310);
                  } else if (x >= 370 && x <= 490 && y >= 322 && y <= 450) {// 회복과 만남
                     MainUnit.setLocation(429, 321);
                     A.HealHP();
                     MainUnitHp.setText("HP : " + A.getHP());
                     System.out.println("회복되었습니다!");
                     JOptionPane.showMessageDialog(null, "모두 회복되었습니다!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                  }

                  else {
                     MainUnit.setLocation(x - 10, y);
                     if (x < 0)
                        MainUnit.setLocation(x + 1, y);
                  }
               } else if (e.getKeyCode() == 38) { // 위쪽 키 눌렀을 때
                  if (y >= 219 && y <= 375 && x >= 672 && x <= 870) {
                     JOptionPane.showMessageDialog(null, "보스 등장!", "Message",

                           JOptionPane.WARNING_MESSAGE);// 보스와 만남
                     E4.setHP(300);
                     MainUnit.setFocusable(false);
                     ATK.setFocusable(true);
                     elv = E4.getLEVEL();
                     System.out.println("보스와의 전투를 시작합니다.");
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                     EnemyHP.setText("HP : " + E4.getHP());
                     EnemyATK.setText("ATK : " + E4.getATK());
                     EnemyLevel.setText("Level : " + E4.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setLocation(670, 310);
                  } else {
                     MainUnit.setLocation(x, y - 10);
                     if (y < 0)
                        MainUnit.setLocation(x, y + 1);
                  }
               } else if (e.getKeyCode() == 39) { // 오른쪽키 눌렀을 때
                  if (x >= 670 && y >= 219 && y <= 375) { // 보스와 만남
                     JOptionPane.showMessageDialog(null, "보스 등장!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     E4.setHP(300);
                     MainUnit.setFocusable(false);
                     ATK.setFocusable(true);
                     elv = E4.getLEVEL();
                     System.out.println("보스와의 전투를 시작합니다.");
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                     EnemyHP.setText("HP : " + E4.getHP());
                     EnemyATK.setText("ATK : " + E4.getATK());
                     EnemyLevel.setText("Level : " + E4.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setLocation(670, 310);
                  } else if (x <= 490 && x >= 370 && y >= 322 && y <= 450) { // 회복과 만남
                     MainUnit.setLocation(429, 321);
                     A.HealHP();
                     MainUnitHp.setText("HP : " + A.getHP());
                     System.out.println("회복되었습니다!");
                     JOptionPane.showMessageDialog(null, "모두 회복되었습니다!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                  } else {
                     MainUnit.setLocation(x + 10, y);
                     if (x > 905)
                        MainUnit.setLocation(x - 1, y);
                  }
               } else if (e.getKeyCode() == 40) { // 아래쪽 키 눌렀을 때
                  if (y >= 219 && x >= 672 && x <= 870) { // 보스와 만남
                     JOptionPane.showMessageDialog(null, "보스 등장!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     E4.setHP(300);
                     MainUnit.setFocusable(false);
                     ATK.setFocusable(true);
                     elv = E4.getLEVEL();
                     System.out.println("보스와의 전투를 시작합니다.");
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
                     EnemyHP.setText("HP : " + E4.getHP());
                     EnemyATK.setText("ATK : " + E4.getATK());
                     EnemyLevel.setText("Level : " + E4.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                     MainUnit.setLocation(670, 310);
                  } else if (y >= 322 && x >= 380 && x <= 450) { // 회복과 만남
                     MainUnit.setLocation(429, 321);
                     A.HealHP();
                     MainUnitHp.setText("HP : " + A.getHP());
                     System.out.println("회복되었습니다!");
                     JOptionPane.showMessageDialog(null, "모두 회복되었습니다!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                  }

                  else {
                     MainUnit.setLocation(x, y + 10);
                     if (y > 400)
                        MainUnit.setLocation(x, y - 1);
                  }
               }

               if (x >= 0 && y >= 0 && x <= 270 && y <= 120) {
                  if (R == 0) {
                     JOptionPane.showMessageDialog(null, "몬스터 조우!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     E1.setHP(50);
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     elv = E1.getLEVEL();
                     System.out.println("몬스터 조우!");
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\LEVEL1.png"));
                     EnemyHP.setText("HP : " + E1.getHP());
                     EnemyATK.setText("ATK : " + E1.getATK());
                     EnemyLevel.setText("Level : " + E1.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                  }
                  R = rd.nextInt(10);

               } else if (x >= 320 && y >= 0 && x <= 590 && y <= 120) {
                  if (R == 0) {
                     JOptionPane.showMessageDialog(null, "몬스터 조우!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     E2.setHP(100);
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     elv = E2.getLEVEL();
                     System.out.println("몬스터 조우!");
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\LEVEL2.png"));
                     EnemyHP.setText("HP : " + E2.getHP());
                     EnemyATK.setText("ATK : " + E2.getATK());
                     EnemyLevel.setText("Level : " + E2.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                  }
                  R = rd.nextInt(10);

               } else if (x >= 641 && y >= 0 && x <= 905 && y <= 120) {
                  if (R == 0) {
                     JOptionPane.showMessageDialog(null, "몬스터 조우!", "Message",

                           JOptionPane.WARNING_MESSAGE);
                     E3.setHP(150);
                     MainUnit.setFocusable(false);
                     ATK.setEnabled(true);
                     elv = E3.getLEVEL();
                     System.out.println("몬스터 조우!");
                     ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\LEVEL3.png"));
                     EnemyHP.setText("HP : " + E3.getHP());
                     EnemyATK.setText("ATK : " + E3.getATK());
                     EnemyLevel.setText("Level : " + E3.getLEVEL());
                     MainUnitHp.setText("HP : " + A.getHP());
                     MainUnitAtk.setText("ATK : " + A.getATK());
                     MainUnitLevel.setText("LEVEL : " + A.getLEVEL());
                     MainUnitEXP.setText("EXP : " + A.getEXP());
                  }
                  R = rd.nextInt(10);

               }
            }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
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
         
         setVisible(true);
         MainUnit.requestFocus();

      }

      public static void main(String arg[]) {
         FrameMain Frame = new FrameMain();

      }
   }
