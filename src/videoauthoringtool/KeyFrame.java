/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videoauthoringtool;

/**
 *
 * @author Aishwarya
 */
public class KeyFrame {
    int frameNum,topLeftX,topLeftY,bottomRightX,bottomRightY;
    
    
    public KeyFrame(){
        frameNum=0;
        topLeftX=0;
        topLeftY=0;
        bottomRightX=0;
        bottomRightY=0;
    }
    
    public KeyFrame(int keyFrame, int topLeftX, int topLeftY, int bottomRightX, int bottomRightY){
        this.frameNum = keyFrame;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
    }
    
    public void display(){
        System.out.println("Frame Num : "+frameNum);
        System.out.println("topLeftX : "+topLeftX);
        System.out.println("topLeftY : "+topLeftY);
        System.out.println("bottom X : "+bottomRightX);
        System.out.println("bottom Y : "+bottomRightY);
    }
}
