/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Chekib
 */

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class webcam {
    
    public static void main(String[] args) throws IOException {
       Webcam w = Webcam.getDefault();
       
       for(Dimension supportedSize :w.getViewSizes()){
           System.out.println(supportedSize.toString());
       }
       w.setViewSize(WebcamResolution.VGA.getSize());
       
       w.getLock().disable();
w.open();
ImageIO.write(w.getImage(), "JPG", new File("capture.png"));
w.close();

        
    }
   
}
