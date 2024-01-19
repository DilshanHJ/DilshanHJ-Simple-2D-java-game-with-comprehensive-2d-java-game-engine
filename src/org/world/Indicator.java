package org.world;

import org.graphics.Graphics;
import org.inputs.KeyInput;
import org.test.Projectile;

import com.jogamp.newt.event.KeyEvent;



public class Indicator extends GameObject {
        public static float angle=0;
        public static float speed=0;

        @Override
        public void render(){
                Graphics.drawText("Speed:"+(int)speed+" Angle:"+(int)angle, 50, 50);
        }

        @Override
        public void update(){
                

                if(KeyInput.getKey(KeyEvent.VK_D)){
                        if(speed<50){
                                speed=speed +0.2f;
                        }

                }

                if(KeyInput.getKey(KeyEvent.VK_A)){
                        if(speed>0){
                                speed= speed -0.2f;
                        }
                        
                }

                if(KeyInput.getKey(KeyEvent.VK_W)){
                        if(angle<180){
                                angle+=0.2f;
                        }

                }

                if(KeyInput.getKey(KeyEvent.VK_S)){
                        if(angle>0){
                                angle-=0.2f;
                        }
                        
                }

                if(KeyInput.getKey(KeyEvent.VK_R)){
                        Projectile.speedX=0;
                        Projectile.speedY=0;
                        Projectile.count=3*60;
                        
                }

                
        }
}
