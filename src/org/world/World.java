package org.world;

import java.util.concurrent.ConcurrentLinkedQueue;



public class World {

        private static ConcurrentLinkedQueue<Tile> tiles = new ConcurrentLinkedQueue<Tile>();
        private static ConcurrentLinkedQueue<GameObject> gameObjects = new ConcurrentLinkedQueue<GameObject>();


        public static void update(){
                
                //update all the gameobjects in the world
                for(GameObject go:gameObjects){
                        go.update();
                }        
        }

        public static void render(){
                //render all the tiles
                for(Tile tile:tiles){
                        tile.render();
                }
                //render all the objects in the world
                for(GameObject go:gameObjects){
                        go.render();
                }
        }

        public static void addObject(GameObject go){
                gameObjects.offer(go);
        }

        public static void addTile(Tile tile){
                tiles.offer(tile);
        }
}
