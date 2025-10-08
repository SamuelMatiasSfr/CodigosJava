package com.gpjecc.blogspot.chuvagame;

import java.rmi.Naming;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class SimpleGame extends ApplicationAdapter {
  
   private Music rainMusic;
   private SpriteBatch batch;
   private OrthographicCamera camera;   
   private BitmapFont font;
   private Array<Gota> gotas;
   private Balde balde;
   
   private long lastDropTime;

   @Override
   public void create() {
      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/rain.mp3"));
      rainMusic.setLooping(true);
      rainMusic.play();

      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
      batch = new SpriteBatch();

		font = new BitmapFont();
		font.setColor(Color.YELLOW);
		font.setScale(2);

      balde = new Balde();
      gotas = new Array<Gota>();
      solicitarSpawnGota();
   }

   private void solicitarSpawnGota() {
      try{
         InterfaceRetornarGota objeto = (InterfaceRetornarGota) Naming.lookup("rmi:///ServidorRetornarGota");
         String posicoes = objeto.retornarGota();
         gotas.add(new Gota(posicoes));
         lastDropTime = TimeUtils.nanoTime();
      }catch (Exception e) {
         System.err.println("Exceção cliente: " + e.toString());
         e.printStackTrace();
      }     
   }

   @Override
   public void render() {
      Gdx.gl.glClearColor(0, 0, 0.2f, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      camera.update();
      batch.setProjectionMatrix(camera.combined);

      batch.begin();
      batch.draw(balde.getImage(), balde.getCorpo().x, balde.getCorpo().y);
      for(Gota gota: gotas) {
         Rectangle corpoGota = gota.getCorpo();
         batch.draw(gota.getImage(), corpoGota.x, corpoGota.y);
      }
      font.draw(batch, "Pontos = " + balde.getPontos(), 650, 460);
      font.draw(batch, "Vidas = " + balde.getVidas(), 650, 430);
      batch.end();

      if(Gdx.input.isTouched()) {
         Vector3 touchPos = new Vector3();
         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
         camera.unproject(touchPos);
         balde.mudarPosicao(touchPos);
      }

      balde.andar();
      balde.limitar();

      if(TimeUtils.nanoTime() - lastDropTime > 1000000000) solicitarSpawnGota();

      Iterator<Gota> iter = gotas.iterator();      
      while(iter.hasNext()) {
         Gota gota = iter.next(); 
         Rectangle corpoGota = gota.getCorpo();        
         gota.andar();

         if(gota.podeSumir()){
            balde.setVidas(balde.getVidas() - 1);
            iter.remove();

            if(balde.getVidas() <= 0){
               Gdx.app.exit();
				   System.exit(-1);
            }

         }

         if(corpoGota.overlaps(balde.getCorpo())) {
            balde.setPontos(balde.getPontos() + 1);
            gota.getSom().play();
            iter.remove();
         }

      }

   }

   @Override
   public void dispose() {
      balde.dispose();
      for(Gota gota : gotas){
         gota.dispose();
      }
      rainMusic.dispose();
      batch.dispose();
   }

}