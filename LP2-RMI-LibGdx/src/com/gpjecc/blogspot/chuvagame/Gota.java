package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Gota {

    private Texture gotaImage;
    private Sound gotaSound;
    private Rectangle corpoGota;

    public Gota(String posicoes){
        gotaImage = new Texture(Gdx.files.internal("assets/droplet.png"));
        gotaSound = Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
        corpoGota = new Rectangle();
        String result[] = posicoes.split(",");
        corpoGota.x = Float.parseFloat(result[0]);
        corpoGota.y = Float.parseFloat(result[1]);
        corpoGota.width = 64;
        corpoGota.height = 64;
    }

    public void andar(){
        corpoGota.y -= 200 * Gdx.graphics.getDeltaTime();
    }

    public boolean podeSumir(){
        if(corpoGota.y + 64 < 0){
            return true;
        }else{
            return false;
        }
    }

    public Rectangle getCorpo(){
        return corpoGota;
    }

    public Sound getSom(){
        return gotaSound;
    }

    public Texture getImage(){
        return gotaImage;
    }

    public void dispose() {
        gotaImage.dispose();
        gotaSound.dispose();
    }

}
