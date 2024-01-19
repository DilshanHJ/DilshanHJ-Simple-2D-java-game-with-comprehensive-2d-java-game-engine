package org.test;

import org.graphics.Graphics;
import org.world.GameObject;

public class TestObject extends GameObject {
        
        
        @Override
        public void render(){
                Graphics.filledRectangle(x, y, 1, 1);
        }
}
