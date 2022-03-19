package com.example.monkeybross;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.*;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class HelloApplication extends Application {
    @Override
    public void start(Stage theStage) {
        theStage.setTitle( "MONKEY BROSS" );

        //arrayList
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<Rectangle> rects = new ArrayList<Rectangle>();


        //generali per java fx
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        int index=0;

        //player e entità
        Player player = new Player("prova",100,100,20,50,50);

        //elementi mappa
        String terrain = "Tile/RPG Nature Tileset.png";
        TileGenerator map = new TileGenerator(terrain,20,20,32,32,512,512);

        //canvas
        Canvas canvas = new Canvas( 1080, 720 );
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();


        //carica mappa e hitbox tile
        map.loadTile();
        for (int i = 0; i<map.getCounter();i++){
            rects.add(map.getP(i));
        }

        //input
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();

                        if ( !input.contains(code) )
                            input.add( code );
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove( code );
                    }
                });

        // Loop e animazione
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {

                //controllo input
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                if(input.contains("LEFT")){
                    player.moveLeft();
                }
                if(input.contains("RIGHT")){
                    player.moveRight();
                }
                if(input.contains("UP")){
                    player.moveUp();
                }
                if(input.contains("DOWN")){
                    player.moveDown();
                }

                //lvl1



                gc.fillRect(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeigth());
                map.draw(gc);

                player.load(rects,player);



            }

        }.start();
        theStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}