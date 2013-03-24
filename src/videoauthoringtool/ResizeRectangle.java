/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videoauthoringtool;

/**
 *
 * @author Chava
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.beans.Visibility;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author $@P
 */
public class ResizeRectangle extends JPanel{
  
  private int SIZE = 8;
  int frameNum,topLeftX,topLeftY,bottomRightX,bottomRightY;
  private Rectangle2D[] points = { new Rectangle2D.Double(0, 0,SIZE, SIZE), new Rectangle2D.Double(100, 100,SIZE, SIZE) };
  Rectangle2D s = new Rectangle2D.Double();
  ShapeResizeHandler ada = new ShapeResizeHandler();
    Point displacement = new Point();
  
  public ResizeRectangle(int f) {
    frameNum = f;
    setLocation(100,100);
    setSize(120, 120);
    //setBounds(100, 100, 100, 100);
    setVisible(true);
    setOpaque(false);
    addMouseListener(ada);
    addMouseMotionListener(ada);
  }
 

    @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.red);
    for (int i = 0; i < points.length; i++) {
      g2.fill(points[i]);
    }
    
    topLeftX = (int) points[0].getCenterX();
    topLeftY = (int) points[0].getCenterY();
    bottomRightX = (int) Math.abs(points[1].getCenterX()- points[0].getCenterX());
    bottomRightY = (int) Math.abs(points[1].getCenterY()- points[0].getCenterY());
    //s.setRect(topLeftX, topLeftY, bottomRightX, bottomRightY);
    Point loc = getLocation();
    System.out.println(loc.x+" "+loc.y);
    
    
    /*setLocation((int)loc.x+displacement.x,(int)loc.y+displacement.y);
    setSize(bottomRightX+10,bottomRightY+10);
    s.setRect(points[0].getCenterX(),points[0].getCenterY(),bottomRightX,bottomRightY); */
    
    // for bottom right corner
    setSize(bottomRightX+10,bottomRightY+10);
    s.setRect(points[0].getCenterX(),points[0].getCenterY(),bottomRightX,bottomRightY); 

    g2.draw(s);
  }

  class ShapeResizeHandler extends MouseAdapter {
    Rectangle2D r = new Rectangle2D.Double(0,0,SIZE,SIZE);
    private int pos = -1;
      @Override
    public void mousePressed(MouseEvent event) {
      Point p = event.getPoint();

      for (int i = 0; i < points.length; i++) {
        if (points[i].contains(p)) {
          pos = i;
          return;
        }
      }
    }

      @Override
    public void mouseReleased(MouseEvent event) {
      pos = -1;
    }

      @Override
    public void mouseDragged(MouseEvent event) {
      if (pos == -1)
        return;

      /*Point loc = getLocation();
      displacement =  event.getPoint();
      points[1].setRect(points[1].getX()-displacement.x,points[1].getY()-displacement.y,points[1].getWidth(),points[1].getHeight());*/
      
      
      /*if(pos==0){
        
        points[1].setRect(points[1].getX()-event.getPoint().x,points[1].getY()-event.getPoint().y,points[1].getWidth(),points[1].getHeight());
      }*/
      //else
      
      
      // for bottom right corner
      points[1].setRect(event.getPoint().x,event.getPoint().y,points[pos].getWidth(),points[pos].getHeight()); 
      System.out.println("dragged x y="+event.getPoint().x+" "+event.getPoint().y);
      
      repaint();
    }
  }
}