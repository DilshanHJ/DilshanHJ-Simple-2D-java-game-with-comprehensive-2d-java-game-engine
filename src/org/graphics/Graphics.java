package org.graphics;

import java.awt.Font;

import org.resources.ImageResource;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {

        //Color value
        public static float red=1;
        public static float green=1;
        public static float blue=1;
        public static float alpha=1;

        //Rotation
        public static float rotation =0;



        public static void drawImage(ImageResource image, float x,float y,float width, float height){
                GL2 gl = EventListener.gl;

                Texture texture = image.getTexture();

                //Render optimisation
                if(x-width/2 -Renderer.cameraX > Renderer.unitsWide/2 ||
                x+width/2 -Renderer.cameraX < -Renderer.unitsWide/2 ||
                y-height/2 -Renderer.cameraY > Renderer.unitsTall/2 ||
                y+height/2-Renderer.cameraY < -Renderer.unitsTall/2){
                        return;
                }


                if(texture != null){
                        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture.getTextureObject());
                }

                gl.glTranslatef(x, y, 0);
                gl.glRotatef(-rotation,0,0,1);
                

                gl.glColor4f(red, green,blue, alpha);

                gl.glBegin(GL2.GL_QUADS);
                        gl.glTexCoord2f(0, 1);
                        gl.glVertex2f(-width/2, -height/2);
                        gl.glTexCoord2f(1, 1);
                        gl.glVertex2f(+width/2, -height/2);
                        gl.glTexCoord2f(1, 0);
                        gl.glVertex2f(+width/2, +height/2);
                        gl.glTexCoord2f(0, 0);
                        gl.glVertex2f(-width/2, +height/2);

                gl.glEnd();
                gl.glFlush();
                gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);

                gl.glRotatef(rotation,0,0,1);
                gl.glTranslatef(-x, -y, 0);
        }

        public static void filledRectangle(float x,float y,float width, float height){
                GL2 gl = EventListener.gl;


                gl.glTranslatef(x, y, 0);
                gl.glRotatef(-rotation,0,0,1);
                

                gl.glColor4f(red, green,blue, alpha);

                gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex2f(-width/2, -height/2);
                        gl.glVertex2f(+width/2, -height/2);
                        gl.glVertex2f(+width/2, +height/2);
                        gl.glVertex2f(-width/2, +height/2);
                gl.glEnd();
                gl.glFlush();

                gl.glRotatef(rotation,0,0,1);
                gl.glTranslatef(-x, -y, 0);
        }

        public static void drawText(String text,int x, int y){
                TextRenderer renderer = new TextRenderer(new Font("SansSefir",Font.BOLD,36));
                renderer.beginRendering(Renderer.getWindowWidth(), Renderer.getWindowHeight());
                renderer.setSmoothing(true);
                renderer.draw(text, x,y);
                renderer.endRendering();


        }

        public static void setColor(float red,float green,float blue,float alpha){
                Graphics.red=Math.max(0,Math.min(1,red));
                Graphics.green=Math.max(0,Math.min(1,green));;
                Graphics.blue=Math.max(0,Math.min(1,blue));;
                Graphics.alpha=Math.max(0,Math.min(1,alpha));;
        }

        public static void setRotation(float rotation){
                Graphics.rotation=rotation;
        }
}
