package org.engine;

import org.graphics.Renderer;
import org.test.Projectile;
import org.test.Swordman;
import org.world.Indicator;
import org.world.World;
import org.world.tiles.BackgroundTile;


public class Main {
        public static void main(String[] args) {
                Renderer.init();
                GameLoop.start();

                //Test Code
                for (int i = -30; i < +30; i++) {
                        BackgroundTile bacground = new BackgroundTile();
                        bacground.x = i * bacground.width;
                        World.addObject(bacground);               
                }
                World.addObject(new Projectile());
                World.addObject(new Swordman());
                World.addObject(new Indicator());

                
        }
}
