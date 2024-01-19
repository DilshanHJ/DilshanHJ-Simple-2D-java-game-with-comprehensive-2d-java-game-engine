package org.world.tiles;

import org.graphics.Animation;
import org.resources.ImageResource;
import org.world.Tile;

public class GrassTile extends Tile{
        
        
        public GrassTile(){
                animations = new Animation[1];
                animations[0]=new Animation();
                animations[0].frames = new ImageResource[1];
                animations[0].frames[0] = new ImageResource("/res/GrassTile.png");

        } 
}
