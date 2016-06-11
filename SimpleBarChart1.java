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
 * class for graphical representation of ustat1 vector
 */
  public class SimpleBarChart1 extends JPanel {
  private double[] value;
  private String[] colors;
  private String title; 
  public SimpleBarChart1(LGraph L)
  {
      ustat ustatone=new ustat(1,L);
       colors=new String[ustatone.m];
      value=new double[ustatone.m];
       for (int i=0;i<ustatone.m;i++)
      {
          colors[i]=Integer.toString(ustatone.Neighb[i].C[ustatone.Neighb[i].center]);
          for(int j=0;j<L.p;j++)
          {
            colors[i]=colors[i]+",";
            colors[i]=colors[i]+Integer.toString(ustatone.Neighb[i].colordistribution()[j]);
        }
        for (int r=0;r<ustatone.m;r++)
      {
          value[i]=ustatone.val[i];
        }
        title="U stat1(centre color,freq color1,freq color2....";
        
    }
}
  public SimpleBarChart1(double[] val, String[] color, String t) {
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
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 12);
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
    frame.setSize(500, 500);
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
