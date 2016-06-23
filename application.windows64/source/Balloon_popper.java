import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Balloon_popper extends PApplet {

/*
  HIGH SCORES:
  STEVE - 58
  STEVE - 54
  STEVE - 45
  WILL - 21

*/
PImage Pop;
PImage img;
PImage pic;
PImage bal;
PImage Hot;
PImage Bil;
public void setup(){
  
 img = loadImage("picturefogae.png");
 pic = loadImage("Cloud.png");
 bal = loadImage("Balloon.png");
 Hot = loadImage("Hot air balloon.png");
 Pop = loadImage("Balloonppr.png");
 Bil = loadImage("Bill.png");
 frameRate(60);
}
 float cloudX = 0;
 float cloudY = 200;
 float X = 225;
 int Y = 0;
 int lives = 2;
 int scene = 0;
 int score = 0;
 float balX = random(0, 380);
 int balY = 0;
 public void balloon(){
    image(bal, balX, balY);
    image(Hot, balX, 0);
 }
public void character(){
  image(img, mouseX, 290); 
  
}
public void score(){
 noStroke();
  image(Bil, 0, 320); 
  fill(0);
  textSize(20);
  text("Score:"+score, 45, 375);
  text("Lives:"+lives, 280, 375 );
}
public void scene0(){
  scene = 0;
   background(70, 150, 200);
  image(pic, cloudX+50, cloudY-50);
  image(pic, cloudX+250, cloudY-100);
  image(pic, cloudX+100, cloudY+50);
  image(pic, cloudX+290, cloudY+110);
if(cloudX <= 400){
  cloudX += 2;
}else if(cloudX >= 400){
  cloudX -= 690;
}
   image(bal, X, Y);
  image(bal, X-100, Y-250);
  image(bal, X+100, Y-100);
  image(bal, X-200, Y-100);
  image(Hot, X, 0);
  image(Hot, X-100, 0);
  image(Hot, X+100, 0);
  image(Hot, X-200, 0);
if(Y < 650){
  Y+=5;
}else if(Y >= 650){
  Y-=650;
}
  noStroke();
  fill(255, 255, 255);
  rectMode(CENTER);
  rect(200, 200, 150, 100, 10);
  fill(0);
  textSize(35);
  text("PLAY", 157, 215);
  image(img, mouseX, mouseY);
  image(Pop, 5, 20);
}
public void tutorialScreen(){
 scene = 1;
 background(70, 150, 200);
  image(pic, cloudX+50, cloudY-50);
  image(pic, cloudX+250, cloudY-100);
  image(pic, cloudX+100, cloudY+50);
  image(pic, cloudX+290, cloudY+110);
  if(cloudX <= 400){
  cloudX += 2;
}else if(cloudX >= 400){
  cloudX -= 690;
} 
   image(bal, X, Y);
  image(bal, X-100, Y-250);
  image(bal, X+100, Y-100);
  image(bal, X-200, Y-100);
  image(Hot, X, 0);
  image(Hot, X-100, 0);
  image(Hot, X+100, 0);
  image(Hot, X-200, 0);
if(Y < 650){
  Y+=5;
}else if(Y >= 650){
  Y-=650;
}
  fill(0, 0, 0, 130);
  rectMode(CENTER);
  rect(200, 200, 350, 350, 60);
  fill(255, 0, 0);
  rect(300, 300, 100, 50, 10);
  fill(255);
  textSize(25);
  text("HOW TO PLAY", 50, 80);
  textSize(15);
  text("Drag the mouse side to side", 50, 100);
  text("to pop the balloons with the spike.", 50, 120);
  text("SPIKE", 109, 255);
  text("BALLOON", 75, 219);
  fill(0, 0, 0);
  textSize(25);
  text("PLAY",270 ,310 );
  image(bal, 145, 200);
  image(img, 150, 240);
  if(mousePressed && mouseX >= 250 && mouseX <= 350 && mouseY >= 275 && mouseY <= 325){
   scene+=1; 
  }
  image(img, mouseX, mouseY);
}
public void draw(){
if(scene == 0){
  scene0();
  if(mousePressed && mouseX >= 75 && mouseX <= 275 && mouseY >= 150 && mouseY <= 250){
    scene+=1;
  }
}else if(scene == 1){
  tutorialScreen();
}else if(scene == 2){
   background(70, 150, 200);
  image(pic, cloudX+50, cloudY-50);
  image(pic, cloudX+250, cloudY-100);
  image(pic, cloudX+100, cloudY+50);
  image(pic, cloudX+290, cloudY+110);
   if(cloudX <= 400){
  cloudX += 2;
}else if(cloudX >= 400){
  cloudX -= 690;
} 
  score();
  if(balY >= 290){
    balY-=290;
    score -= 1;
    lives -= 1;
  }else if(balY+30 >= 290 && balX+30 >= mouseX && balX-50 <= mouseX){
    score+=1;
    balY-=290;
    balX = random(0, 390);
  }else if(lives <= 0){
    rectMode(CORNER);
    fill(0, 0, 0, 130);
    rect(30, 30, 340, 340, 60);
    fill(255);
    rectMode(CENTER);
    rect(200, 200, 150, 100, 20);
    fill(0);
    textSize(25);
    text("RESET", 165, 210);
    if(mousePressed && scene ==2 && mouseX >= 75 && mouseX <= 275 && mouseY >= 150 && mouseY <= 250){
      scene = 2;
      lives = 2;
      score = 0;
    } }else{
   balY+=8.6f; 
  
  }if(score >= 30){
    balY += 8.7f;
  }if(score >= 40){
  balY += 8.8f;
}if(score >= 50){
  balY += 8.9f;
}if(score >= 60){
  balY += 9;
}
if(score == 15 || score == 35){
      lives = 2;
}
  rectMode(CORNER);
  
  balloon();
  character();
}
}
  public void settings() {  size(400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Balloon_popper" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
