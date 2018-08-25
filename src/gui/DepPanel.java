package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DepPanel extends JPanel {
  private static final long serialVersionUID = 1L;

  private JPanel jp1,jp2;
  private JLabel jLabel1;
  private JTable jTable;
  private JScrollPane jScrollPane;
  private JButton jButton1,jButton2,jButton3;

  public DepPanel(){
    this.setLayout(new BorderLayout());
    jp1 = new JPanel();
    jp2 = new JPanel();
    jLabel1 = new JLabel("Dept management interface");
    jButton1 = new JButton("Add Dept");
    jButton2 = new JButton("Delete Dept");
    jButton3 = new JButton("Update Dept");
    jp1.add(jLabel1);
    jp2.add(jButton1);
    jp2.add(jButton2);
    jp2.add(jButton3);
    this.add(jp1,BorderLayout.NORTH);
    this.add(jp2,BorderLayout.SOUTH);

  }
}
