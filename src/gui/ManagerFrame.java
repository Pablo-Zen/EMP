package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ManagerFrame extends JFrame {
  Font font = new Font("宋体",Font.PLAIN,20);
  private JMenuBar jMenuBar;
  private JMenu jm1,jm2,jm3;
  private JMenuItem jMenuItem1,jMenuItem2,jMenuItem3;
  private UserPanel userPanel;
  private DepPanel depPanel;
  private EmplPanel emplPanel;
  private JPanel jp1;
  public ManagerFrame(){
    this.setSize(900,600);
    this.setFont(font);
    this.setLocation(100,100);
    this.setTitle("EM System");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    initPanel();
    jm1.add(jMenuItem1);
    jm2.add(jMenuItem2);
    jm3.add(jMenuItem3);
    jMenuBar.add(jm1);
    jMenuBar.add(jm2);
    jMenuBar.add(jm3);
    this.add(jMenuBar, BorderLayout.NORTH);
    this.add(jp1);
    jMenuItem1.addActionListener(new MenuClick());
    jMenuItem2.addActionListener(new MenuClick());
    jMenuItem3.addActionListener(new MenuClick());
    this.setVisible(true);
  }
  private void initPanel(){

    jMenuBar = new JMenuBar();
    jm1 = new JMenu("Dept Manage");
    jm2 = new JMenu("Empl Manage");
    jm3 = new JMenu("Sysm Manage");
    jMenuItem1 = new JMenuItem("Dept Info");
    jMenuItem2 = new JMenuItem("Empl Info");
    jMenuItem3 = new JMenuItem("User info");
    userPanel = new UserPanel();
    depPanel = new DepPanel();
    emplPanel = new EmplPanel();
    jp1 = new JPanel(new BorderLayout());
  }
  private class  MenuClick implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      jp1.removeAll();
      if(e.getSource()==jMenuItem1){
        //dept
        jp1.add(emplPanel);
      }else if(e.getSource()==jMenuItem2){
        jp1.add(depPanel);
      }else if(e.getSource()==jMenuItem3){
        //user
        jp1.add(userPanel);
      }
      jp1.updateUI();
    }
  }
}
