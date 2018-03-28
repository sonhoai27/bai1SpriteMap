/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sonho
 */
public class B1 {
       public static void joinArray(String inputPath,String outputPath) throws IOException{
        File dir= new File(inputPath);
        File[] files = dir.listFiles();
        BufferedImage sprite= ImageIO.read(files[0]);
        int with=sprite.getWidth()*2;
        int height=sprite.getHeight()*2;
        System.out.println(with);
        System.out.println(height);
        BufferedImage spritemap = new BufferedImage(with, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d=spritemap.createGraphics();
        int x = 0;
        int y = 0;
        int dem = 1;
        for(File file:files){
           if(1<= dem && dem <= 2){
                sprite=ImageIO.read(file);
                g2d.drawImage(sprite, null, x,0);
                x+=sprite.getWidth();
                dem++;
           }else if(3<= dem && dem <= 4) {
                sprite=ImageIO.read(file);
                g2d.drawImage(sprite, null, y,sprite.getHeight());
                y+=sprite.getWidth();
                dem++;
           }
       }
       ImageIO.write(spritemap, "png", new File(outputPath));
    }
    public static void main(String[] args) {
        try{
            B1.joinArray("C:\\Users\\sonho\\Desktop\\rsshiny-001n\\b1\\input\\", "C:\\Users\\sonho\\Desktop\\rsshiny-001n\\b1\\output\\output2.png");
        }catch(IOException ex){
           System.err.println(ex);
        }
    }
}
