/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videoauthoringtool;

import java.util.ArrayList;

/**
 *
 * @author Aishwarya
 */
public class Metafile {

    public int rectID, numOfKeyFrames, linkedVideoStartFrame;
    String rectName, linkedVideoName;
    public ArrayList<KeyFrame> kf;
    
    public Metafile(){
        kf=new ArrayList<KeyFrame>();
        rectID=0;
        numOfKeyFrames=0;
        linkedVideoStartFrame=0;
        rectName="";
        linkedVideoName="";
    }
    
    public void display(){
        System.out.println("rectID : "+rectID);
        System.out.println("rectName : "+rectName);
        System.out.println("linkedvideoname : "+linkedVideoName);
        System.out.println("linkedVideoStartFrame : "+linkedVideoStartFrame);
        System.out.println("numofkeyframes : "+numOfKeyFrames);
        int i=0;
        while(i<kf.size())
        {
            kf.get(i++).display();
        }
    }
    
   /* public void addKeyFrame(int keyFrame, int topLeftX, int topLeftY, int bottomRightX, int bottomRightY){ 
        KeyFrame key = new KeyFrame();
        kf.add(key);
        this.numOfKeyFrames++;
    }*/
}
