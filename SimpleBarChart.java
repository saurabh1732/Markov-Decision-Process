/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package part3_editeurdereseau;

/**
 *
 * @author bhuvan
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * class for drawing bar graph of ustatzero for a l graph
 */
  public class SimpleBarChart extends JPanel {
      /**
       * array for storing components of ustat zero vector
       */
  private double[] value;
  /**
   * Stores name of different colours
   */
  private String[] colors;
  private String title;
  /**
   * constructor for the class taking an L graph as an argument
   */
  public SimpleBarChart(LGraph L)
  {
      ustat ustatzero=new ustat(0,L);
      colors=new String[ustatzero.m];
      value=new double[ustatzero.m];
      for (int i=0;i<ustatzero.m;i++)
      {
          colors[i]=Integer.toString(ustatzero.Neighb[i].C[ustatzero.Neighb[i].center]);
        }
        for (int i=0;i<ustatzero.m;i++)
      {
          value[i]=ustatzero.val[i];
        }
        title="U stat0";
        
    }
  public SimpleBarChart(double[] val, String[] color, String t) {
    this.colors =color ;
    value = val;
    title = t;
  }
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    if (value == null || value.length == 0)
      return;
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < value.length; i++) {
      if (minValue > value[i])
        minValue = value[i];
      if (maxValue < value[i])
        maxValue = value[i];
    }
    Dimension dim = getSize();
    int clientWidth = dim.width;
    int clientHeight = dim.height;
    int barWidth = clientWidth / value.length;
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
    FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 15);
    FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);
    int titleWidth = titleFontMetrics.stringWidth(title);
    int q = titleFontMetrics.getAscent();
    int p = (clientWidth - titleWidth) / 2;
    graphics.setFont(titleFont);
    graphics.drawString(title, p, q);
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    q = clientHeight - labelFontMetrics.getDescent();
    graphics.setFont(labelFont);
    for (int j = 0; j < value.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (value[j] * scale);
      if (value[j] >= 0)
        valueQ += (int) ((maxValue - value[j]) * scale);
      else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
      graphics.setColor(Color.blue);
      graphics.fillRect(valueP, valueQ, barWidth - 2, height);
      graphics.setColor(Color.black);
      graphics.drawRect(valueP, valueQ, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(colors[j]);
      p = j * barWidth + (barWidth - labelWidth) / 2;
      graphics.drawString(colors[j], p, q);
    }
  }
   public void print()
  {
      JFrame frame = new JFrame();
    frame.setSize(1000, 1000);
    frame.getContentPane().add(this);

    WindowListener winListener = new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    };
    frame.addWindowListener(winListener);
    frame.setVisible(true);
}
}

