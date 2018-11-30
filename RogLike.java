  import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.ButtonUI;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrameMain extends JFrame {
   public FrameMain() {

      setTitle("용사 키우기");
      setSize(960, 1000);
      setVisible(true);
      setResizable(false);
      getContentPane().setLayout(new GridLayout(2, 1, 10, 10));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel panel1 = new JPanel();
      panel1.setLayout(null);
      panel1.setBackground(Color.ORANGE);
      panel1.setSize(960, 535);
      JPanel panel2 = new JPanel();
      panel2.setLayout(null);
      panel2.setSize(960, 455);
      panel2.setBackground(Color.GRAY);

      getContentPane().add(panel1);
      getContentPane().add(panel2);

      JLabel ENEMY = new JLabel("");
      ENEMY.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS.png"));
      ENEMY.setBounds(582, 12, 319, 233);
      panel2.add(ENEMY);

      JLabel EnemyHP = new JLabel("HP :");
      EnemyHP.setBounds(451, 87, 62, 18);
      panel2.add(EnemyHP);

      JLabel EnemyATK = new JLabel("ATK :");
      EnemyATK.setBounds(451, 128, 62, 18);
      panel2.add(EnemyATK);

      JLabel EnemyLevel = new JLabel("LEVEL :");
      EnemyLevel.setBounds(451, 170, 62, 18);
      panel2.add(EnemyLevel);

      JLabel MainUnit2 = new JLabel("MainUnit");
      MainUnit2.setBounds(81, 379, 62, 18);
      panel2.add(MainUnit2);

      JLabel MainUnitHp = new JLabel("HP : ");
      MainUnitHp.setBounds(322, 284, 62, 18);
      panel2.add(MainUnitHp);

      JLabel MainUnitAtk = new JLabel("ATK : ");
      MainUnitAtk.setBounds(322, 314, 62, 18);
      panel2.add(MainUnitAtk);

      JLabel MainUnitLevel = new JLabel("LEVEL : ");
      MainUnitLevel.setBounds(322, 344, 62, 18);
      panel2.add(MainUnitLevel);

      JLabel MainUnitEXP = new JLabel("EXP : ");
      MainUnitEXP.setBounds(322, 379, 62, 18);
      panel2.add(MainUnitEXP);

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
            if (e.getKeyCode() == 37)
               MainUnit.setLocation(MainUnit.getX() - 10, MainUnit.getY());
            else if (e.getKeyCode() == 38)
               MainUnit.setLocation(MainUnit.getX(), MainUnit.getY() - 10);
            else if (e.getKeyCode() == 39)
               MainUnit.setLocation(MainUnit.getX() + 10, MainUnit.getY());
            else if (e.getKeyCode() == 40)
               MainUnit.setLocation(MainUnit.getX(), MainUnit.getY() + 10);
         }
      });

      JLabel Heal = new JLabel("Heal");
      Heal.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\Heal.png"));
      Heal.setBounds(419, 391, 71, 86);
      panel1.add(Heal);

      JLabel Boss = new JLabel();
      Boss.setBounds(717, 261, 165, 166);
      panel1.add(Boss);
      Boss.setIcon(new ImageIcon("C:\\201532056\\ExpertProject\\src\\ProjectFile\\BOSS2.png"));

   }

   public static void main(String arg[]) {
      FrameMain Frame = new FrameMain();
   }
}
