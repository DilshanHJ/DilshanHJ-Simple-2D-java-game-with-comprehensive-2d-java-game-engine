package org.test;

import org.graphics.Animation;
import org.graphics.Renderer;
import org.resources.ImageResource;
import org.world.GameObject;
import org.world.World;

public class Projectile extends GameObject{
        public static float speedY =0;
        public static float speedX = 0;
        public static float g =10.0f;
        public static boolean ejected =false;
        public static int count =0;
        private GameObject body;
        

        


        public Projectile(){

                animations = new Animation[1];
                animations[0]=new Animation();
                animations[0].frames = new ImageResource[1];
                animations[0].frames[0] = new ImageResource("/res/Laka/Head.png");

                y=-1.6f;
                x=-0.2f;
                width=0.5f;
                height=0.5f;
                rotation=0f;


                //Body
                body=new GameObject();
                body.animations = new Animation[1];
                body.animations[0]=new Animation();
                body.animations[0].frames = new ImageResource[1];
                body.animations[0].frames[0] = new ImageResource("/res/Laka/Body.png");
                body.y=-2;
                World.addObject(body);
                
                

        }

        @Override
        public void update(){
                if(ejected){
                        headEject();
                }
                
        }

        private void headEject(){
                // motion under gravity
                float dy= (float)(speedY/60 -0.5*g/(60*60));
                speedY = speedY-g/60;
                if(y<-2){
                        y=-2f;
                        if(Math.abs(speedY)<1f){
                                speedY=0;
                        }else{
                                speedY= (float)(-0.7 *speedY);
                                
                                
                        }
                }else{
                        y=y+dy;
                }
                

                
                //Linear Uniform Motion
                float dx = speedX/60;
                x=x+dx;
                

                if(y== -2){
                        speedX= (float)(0.9*speedX);
                        rotation=rotation+ speedX*10f;
                        if(Math.abs(speedX)<1f){
                                speedX=0;
                        }
                        
                }else{
                        if(speedX !=0){
                                rotation=rotation+10f;
                        }
                }

                if(speedX==0 && speedY ==0){
                        count++;

                        if(count>3*60 && y!= -1.6f && x != -0.2f){
                                y=-1.6f;
                                x=-0.2f;
                                rotation=0f;
                                Renderer.cameraX=0;
                                Renderer.cameraY=0;
                                ejected=false;
                                count=0;
                        }
                        
                }


                //off the screen camera adjestment
                if(x-Renderer.cameraX <= -4){
                        Renderer.cameraX -= Math.abs(dx);
                }

                if(x-Renderer.cameraX >= 4 ){
                        Renderer.cameraX += Math.abs(dx);
                }

                if(y-Renderer.cameraY <= -2 ){
                        Renderer.cameraY -= Math.abs(dy);
                }

                if(y-Renderer.cameraY >= 2 ){
                        Renderer.cameraY += Math.abs(dy);
                }
        }
}
