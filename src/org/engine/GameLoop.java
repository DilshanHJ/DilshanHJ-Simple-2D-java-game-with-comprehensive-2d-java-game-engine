package org.engine;

import org.graphics.Renderer;
import org.world.World;

public class GameLoop {
        private static boolean running =false;
        private static int targetFPS=60;
        private static int targetTime =1000000000/targetFPS;
        private static int updates=0;
        private static int MAX_UPDATES =5;
        private static long lastUpdateTime=0;

        public static void start(){
                Thread thread = new Thread(){
                        public void run(){

                                running=true;
                                int fps=0;
                                long lastFPSCheck=System.nanoTime();
                                lastUpdateTime=System.nanoTime();

                                while(running){
                                        long currentTime = System.nanoTime();
                                        while(currentTime-lastUpdateTime>targetTime){
                                                World.update();
                                                lastUpdateTime+=targetTime;
                                                updates++;

                                                if(updates>MAX_UPDATES){
                                                        break;
                                                }
                                        }

                                        Renderer.render();

                                        fps++;
                                        if(System.nanoTime()>=lastFPSCheck+1000000000){
                                                System.out.println(fps);
                                                fps=0;
                                                lastFPSCheck=System.nanoTime();
                                        }

                                        long timeTaken = System.nanoTime()-currentTime;
                                        if(timeTaken<targetTime){
                                                try {
                                                        Thread.sleep((targetTime-timeTaken)/1000000);
                                                } catch (InterruptedException e) {
                                                        e.printStackTrace();
                                                }
                                        }



                                        // long startTime=System.nanoTime();
                                        // //poll input
                                        // //update the game
                                        // World.update();
                                        // //render the game
                                        // Renderer.render();

                                        // long timeTaken = System.nanoTime() -startTime;
                                        // if(timeTaken<targetTime){
                                        //         try {
                                        //                 Thread.sleep((targetTime-timeTaken)/1000000);
                                        //         } catch (InterruptedException e) {
                                        //                 e.printStackTrace();
                                        //         }
                                        // }
                                }
                        }
                };

                thread.setName("GameLoop");
                thread.start();
        }

        public static float updateDelta(){
                return 1.0f/1000000000 * targetTime;
        }
}
