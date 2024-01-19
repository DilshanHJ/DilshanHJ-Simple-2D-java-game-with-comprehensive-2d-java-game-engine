package org.test;

import org.graphics.Animation;
import org.resources.ImageResource;
import org.world.GameObject;

public class Swordman extends GameObject {
        public static int count=0;
        public static boolean isAttacking=false;
        public Swordman(){
                y=-2.1f;
                x=-1.2f;
                animations = new Animation[2];

                //  Idle Animation
                animations[0] = new Animation();
                animations[0].frames =new ImageResource[18];
                animations[0].fps = 20;
                for(int i=0;i<10;i++){
                       animations[0].frames[i] = new ImageResource("/res/Swordman/Idle/GreekBasic_Idle_0"+i+".png"); 
                }
                for(int i=0;i<8;i++){
                       animations[0].frames[i+10] = new ImageResource("/res/Swordman/Idle/GreekBasic_Idle_1"+i+".png"); 
                }

                //Attack
                animations[1] = new Animation();
                animations[1].frames =new ImageResource[8];
                animations[1].fps = 8;
                for(int i=0;i<8;i++){
                       animations[1].frames[i] = new ImageResource("/res/Swordman/Attack/GreekBasic_Attack_"+i+".png"); 
                }
                
        }

        @Override
        public void update(){

                if (isAttacking){
                        currentAnimation=1;
                        count++;
                        if(count>0.7*60){
                                Projectile.ejected=true;
                        }
                        if(count>1*60){
                                count=0;
                                isAttacking=false;
                                width=1;
                                currentAnimation=0;
                                
                        }
                }

                if(currentAnimation==1){
                        width=2.7f;
                }

                
        }
}
