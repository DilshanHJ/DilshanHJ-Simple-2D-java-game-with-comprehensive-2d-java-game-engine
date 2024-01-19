package org.graphics;

import org.inputs.KeyInput;
import org.inputs.MouseInput;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
//import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {
        
        private static GLProfile profile=null;
        private static GLWindow window=null;
        public static int screenWidth= 1920;
        public static int screenHeight =1080;

        public static float unitsWide=10;
        public static float unitsTall=0;

        public static float cameraX=0;
        public static float cameraY=0;
        
        public static void init(){
                GLProfile.initSingleton();
                profile = GLProfile.get(GLProfile.GL2);
                GLCapabilities capabilities = new GLCapabilities(profile);

                Renderer.window =GLWindow.create(capabilities);
                window.setSize(Renderer.screenWidth, Renderer.screenHeight);
                window.setResizable(false);
                window.setFullscreen(true);
                window.addGLEventListener(new EventListener());
                window.addMouseListener(new MouseInput());
                window.addKeyListener(new KeyInput());
                window.setVisible(true);
                // FPSAnimator animator = new FPSAnimator(window, 30);
                // animator.start();
        }

        public static int getWindowWidth(){
                return window.getWidth();
        }

        public static int getWindowHeight(){
                return window.getHeight();
        }

        public static GLProfile getProfile(){
                return Renderer.profile;
        }

        public static void render(){
                if(window==null){
                        return;
                }
                window.display();
        }

}
