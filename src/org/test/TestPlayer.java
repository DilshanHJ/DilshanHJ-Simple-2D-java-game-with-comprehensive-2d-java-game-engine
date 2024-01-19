package org.test;

import org.engine.GameLoop;
import org.graphics.Animation;
import org.graphics.Renderer;
import org.inputs.KeyInput;
import org.inputs.MouseInput;
import org.resources.ImageResource;
import org.world.GameObject;
import org.world.World;

import com.jogamp.newt.event.KeyEvent;

public class TestPlayer extends GameObject {
        
        GameObject legs = new GameObject();
        public TestPlayer(){
                animations = new Animation[2];
                
                graphicsRotation = -95;

                // Rifle Idle Animation
                animations[0] = new Animation();
                animations[0].frames =new ImageResource[20];
                animations[0].fps = 20;
                for(int i=0;i<20;i++){
                       animations[0].frames[i] = new ImageResource("/res/Top_Down_Survivor/rifle/idle/survivor-idle_rifle_"+i+".png"); 
                }

                // Rifle Move Animation
                animations[1] = new Animation();
                animations[1].frames =new ImageResource[20];
                animations[1].fps =30;
                for(int i=0;i<20;i++){
                       animations[1].frames[i] = new ImageResource("/res/Top_Down_Survivor/rifle/move/survivor-move_rifle_"+i+".png"); 
                }


                //Create The Legs Animation
                
                legs.width=width*0.8f;
                legs.height=height *0.8f;
                
                World.addObject(legs);
                legs.animations = new Animation[2];

                //Legs Idle Animation
                legs.animations[0] = new Animation();
                legs.animations[0].frames =new ImageResource[1];
                legs.animations[0].frames[0] = new ImageResource("/res/Top_Down_Survivor/feet/idle/survivor-idle_0.png");
                
                //Legs Moving animatin
                legs.animations[1] = new Animation();
                legs.animations[1].frames = new ImageResource[20];
                legs.animations[1].fps =18;
                for(int i=0;i<20;i++){
                        legs.animations[1].frames[i] = new ImageResource("/res/Top_Down_Survivor/feet/run/survivor-run_"+i+".png");
                }
        }

        

                
        
        @Override
        public void update(){
                float xInput=0;
                float yInput=0;

                if(KeyInput.getKey(KeyEvent.VK_LEFT)){
                        xInput--;
                }
                if(KeyInput.getKey(KeyEvent.VK_RIGHT)){
                        xInput++;
                }
                if(KeyInput.getKey(KeyEvent.VK_UP)){
                        yInput++;
                }
                if(KeyInput.getKey(KeyEvent.VK_DOWN)){
                        yInput--;
                }

                //Animation changing 
                if (xInput !=0 || yInput !=0){
                        currentAnimation=1;
                        legs.currentAnimation=1;
                        legs.width=width *1.2f;
                        legs.height=height *0.6f;
                }else{
                        currentAnimation=0;
                        legs.currentAnimation=0;
                        legs.width=width*0.8f;
                        legs.height=height *0.8f;
                }

                //movement with in the screen
                x += xInput * GameLoop.updateDelta();
                y += yInput * GameLoop.updateDelta();

                //off the screen camera adjestment
                Renderer.cameraX=x;
                Renderer.cameraY=y;
                // if(x-Renderer.cameraX <= -4 && KeyInput.getKey(KeyEvent.VK_LEFT)){
                //         Renderer.cameraX -= 1.0f * GameLoop.updateDelta();
                // }

                // if(x-Renderer.cameraX >= 4 && KeyInput.getKey(KeyEvent.VK_RIGHT)){
                //         Renderer.cameraX += 1.0f * GameLoop.updateDelta();
                // }

                // if(y-Renderer.cameraY <= -2 && KeyInput.getKey(KeyEvent.VK_DOWN)){
                //         Renderer.cameraY -= 1.0f * GameLoop.updateDelta();
                // }

                // if(y-Renderer.cameraY >= 2 && KeyInput.getKey(KeyEvent.VK_UP)){
                //         Renderer.cameraY += 1.0f * GameLoop.updateDelta();
                // }

                //Mouse Look
                float radians = (float)Math.atan2(MouseInput.getWorldX()-x,MouseInput.getWorldY()-y);
                rotation = (float)Math.toDegrees(radians);

                //legs
                legs.graphicsRotation=graphicsRotation;
                legs.rotation=rotation;
                legs.x=x;
                legs.y=y;
        }
        
        
}
