package com.example.monkeybross;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


import java.util.ArrayList;

public class Player {

    private int life;
    private int lvl;
    private String name;
    private int atk;
    private double posX;
    private double posY;
    private double speedUp = 3;
    private double speedDown = 3;
    private double speedRight = 3;
    private double speedLeft = 3;
    private double width=20;
    private double heigth=50;
    private boolean crash = false;

    boolean crashU = false;
    boolean crashD = false;
    boolean crashL = false;
    boolean crashR = false;

    public Player(String name, int life, int lvl, int atk, double posX, double posY){
        this.name = name;
        this.life=life;
        this.lvl = lvl;
        this.atk = atk;
        this.posX=posX;
        this.posY = posY;
    }

    public int getAtk() {
        return atk;
    }

    public int getLife() {
        return life;
    }

    public int getLvl() {
        return lvl;
    }

    public String getName() {
        return name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getSpeedUp() {
        return speedUp;
    }

    public double getSpeedDown() {
        return speedDown;
    }

    public double getSpeedLeft() {
        return speedLeft;
    }

    public double getSpeedRight() {
        return speedRight;
    }

    public void setSpeedDown(double speedDown) {
        this.speedDown = speedDown;
    }

    public void setSpeedLeft(double speedLeft) {
        this.speedLeft = speedLeft;
    }

    public void setSpeedRight(double speedRight) {
        this.speedRight = speedRight;
    }

    public void setSpeedUp(double speedUp) {
        this.speedUp = speedUp;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void moveLeft(){
        posX-=speedLeft;}

    public void moveRight(){
        posX+=speedRight;
    }

    public void moveUp(){
        posY-=speedUp;
    }

    public void moveDown(){
        posY+=speedDown;
    }

    public void load(ArrayList<Rectangle> p, Player entity) {


        for (int i = 0; i < p.size(); i++) {

            double myLeft = entity.getPosX();
            double myRight = entity.getPosX() + entity.getWidth();
            double myTop = entity.getPosY();
            double myBottom = entity.getPosY() + entity.getHeigth();
            double otherLeft = p.get(i).getX();
            double otherRight = p.get(i).getX() + p.get(i).getWidth();
            double otherTop = p.get(i).getY();
            double otherBottom = p.get(i).getY() + p.get(i).getHeigth();
            if ((myBottom < otherTop) || (myTop > otherBottom) || (myRight < otherLeft) || (myLeft > otherRight)) {
                crashL = false;
                crashU = false;
                crash = false;
                crashR = false;
                crashD = false;


            }else{
                if(myTop > otherBottom){
                    crashU = true;
                }
                if(myBottom > otherTop){
                    crashD=true;
                }

                if(myRight > otherLeft){
                    crashR = true;
                }
                if(myLeft < otherRight){
                    crashL = true;
                }
                crash=true;
                System.out.println(crash);
            }
            if(crash==true){

                if(crashD == true){
                    entity.posY -= entity.speedDown;
                }
                if(crashL == true){
                    entity.posX += entity.speedRight;
                }
            }

        }



    }

}
