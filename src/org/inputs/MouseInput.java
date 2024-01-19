package org.inputs;

import org.graphics.Renderer;
import org.test.Projectile;
import org.test.Swordman;
import org.world.Indicator;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInput implements MouseListener {

        private static int x=0;
        private static int y=0;

        public static int getX(){
                return x;
        }

        public static int getY(){
                return y;
        }

        public static float getWorldX(){
                return (Renderer.unitsWide / Renderer.getWindowWidth() * x -Renderer.unitsWide/2) + Renderer.cameraX;
        }

        public static float getWorldY(){
                float unitsTall=Renderer.unitsWide*((float)Renderer.getWindowHeight()/(float)Renderer.getWindowWidth());
                return -(unitsTall / Renderer.getWindowHeight() * y -unitsTall/2) + Renderer.cameraY;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                Projectile.speedX =(float)(Indicator.speed * Math.cos(Math.toRadians(Indicator.angle)));
                Projectile.speedY= (float)(Indicator.speed * Math.sin(Math.toRadians(Indicator.angle)));;
                Swordman.isAttacking=true;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
                
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                
        }

        @Override
        public void mouseExited(MouseEvent e) {
                
        }

        @Override
        public void mouseMoved(MouseEvent e) {
                x= e.getX();
                y= e.getY();
        }

        @Override
        public void mousePressed(MouseEvent e) {
                
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
                
        }

        @Override
        public void mouseWheelMoved(MouseEvent arg0) {
                
                
        }
        
}
