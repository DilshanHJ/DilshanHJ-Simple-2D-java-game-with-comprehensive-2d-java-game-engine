package org.world.tiles;

import org.graphics.Animation;
import org.resources.ImageResource;
import org.world.Tile;

public class BackgroundTile extends Tile{
        public BackgroundTile(){
                animations = new Animation[1];
                animations[0]=new Animation();
                animations[0].frames = new ImageResource[1];
                animations[0].frames[0] = new ImageResource("/res/Background.png");
                width=24;
                height=12;
                y=3;
        }

}
