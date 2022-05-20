package com.example.piratesandcannons;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        final double[] scene_size = new double[]{1000, 500};
        //System.out.println(System.getProperty("user.dir"));
        Group group = new Group();
        Scene scene = new Scene(group, scene_size[0], scene_size[1]);

        //Задний план
        Image backgroundimg = new Image("Background.png");
        ImageView background = new ImageView();
        background.setImage(backgroundimg);
        background.setLayoutX(0);
        background.setLayoutY(0);
        group.getChildren().add(background);

        //Вода
        Image waterimg = new Image("Water.png");
        ImageView water = new ImageView();
        water.setImage(waterimg);
        water.setLayoutX(0);
        water.setLayoutY(185);
        group.getChildren().add(water);

        //Волна вправо1
        Image waveright1img = new Image("Waveright.png");
        ImageView waveright1 = new ImageView();
        waveright1.setImage(waveright1img);
        waveright1.setLayoutX(-1000);
        waveright1.setLayoutY(190);
        group.getChildren().add(waveright1);

        //Волна влево1
        Image waveleft1img = new Image("Waveleft.png");
        ImageView waveleft1 = new ImageView();
        waveleft1.setImage(waveleft1img);
        waveleft1.setLayoutX(0);
        waveleft1.setLayoutY(250);
        group.getChildren().add(waveleft1);

        //Волна вправо2
        Image waveright2img = new Image("Waveright.png");
        ImageView waveright2 = new ImageView();
        waveright2.setImage(waveright2img);
        waveright2.setLayoutX(-1000);
        waveright2.setLayoutY(310);
        group.getChildren().add(waveright2);

        //Волна влево2
        Image waveleft2img = new Image("Waveleft.png");
        ImageView waveleft2 = new ImageView();
        waveleft2.setImage(waveleft2img);
        waveleft2.setLayoutX(0);
        waveleft2.setLayoutY(360);
        group.getChildren().add(waveleft2);

        //Волна вправо3
        Image waveright3img = new Image("Waveright.png");
        ImageView waveright3 = new ImageView();
        waveright3.setImage(waveright3img);
        waveright3.setLayoutX(-1000);
        waveright3.setLayoutY(420);
        group.getChildren().add(waveright3);

        //Пушка
        Image cannonimg = new Image("Cannon.png");
        ImageView cannon = new ImageView();
        cannon.setImage(cannonimg);
        cannon.setLayoutX(460);
        cannon.setLayoutY(400);
        group.getChildren().add(cannon);

        //Основание пушки
        Image cannongroundimg = new Image("Cannonground.png");
        ImageView cannonground = new ImageView();
        cannonground.setImage(cannongroundimg);
        cannonground.setLayoutX(440);
        cannonground.setLayoutY(460);
        group.getChildren().add(cannonground);

        //Ядро
        Image ballimg = new Image("Ballfinal.png");
        ImageView ball = new ImageView();
        group.getChildren().add(ball);

        //Корабль1
        Image ship1img = new Image("Ship1.png");
        ImageView ship1 = new ImageView();
        group.getChildren().add(ship1);

        //Корабль1 в огне
        Image ship1fireimg = new Image("Ship1fire.png");
        ImageView ship1fire = new ImageView();
        group.getChildren().add(ship1fire);

        //Корабль2
        Image ship2img = new Image("Ship2.png");
        ImageView ship2 = new ImageView();
        group.getChildren().add(ship2);

        //Корабль2 в огне
        Image ship2fireimg = new Image("Ship2fire.png");
        ImageView ship2fire = new ImageView();
        group.getChildren().add(ship2fire);

        //Жизнь11
        Image HP1_1img = new Image("HP1.png");
        ImageView HP1_1 = new ImageView();
        group.getChildren().add(HP1_1);

        //Жизнь12
        Image HP1_2img = new Image("HP1.png");
        ImageView HP1_2 = new ImageView();
        group.getChildren().add(HP1_2);

        //Жизнь13
        Image HP1_3img = new Image("HP1.png");
        ImageView HP1_3 = new ImageView();
        group.getChildren().add(HP1_3);

        //Жизнь01
        Image HP0_1img = new Image("HP0.png");
        ImageView HP0_1 = new ImageView();
        group.getChildren().add(HP0_1);

        //Жизнь01
        Image HP0_2img = new Image("HP0.png");
        ImageView HP0_2 = new ImageView();
        group.getChildren().add(HP0_2);

        //Жизнь03
        Image HP0_3img = new Image("HP0.png");
        ImageView HP0_3 = new ImageView();
        group.getChildren().add(HP0_3);

        //Основание пушки
        Image hpbarimg = new Image("HPbar.png");
        ImageView hpbar = new ImageView();
        hpbar.setImage(hpbarimg);
        hpbar.setLayoutX(150);
        hpbar.setLayoutY(420);
        group.getChildren().add(hpbar);

        Label killcount = new Label("Kills: " + 0);
        killcount.setMinSize(50, 10);
        killcount.setLayoutX(170);
        killcount.setLayoutY(440);
        group.getChildren().add(killcount);

        Label level = new Label("Level: " + 1);
        level.setMinSize(50, 10);
        level.setLayoutX(170);
        level.setLayoutY(465);
        group.getChildren().add(level);


        //Уровень не пройден
        Image gameoverimg = new Image("Gameover.png");
        ImageView gameover = new ImageView();
        group.getChildren().add(gameover);

        //Уровень пройден
        Image nextlevelimg = new Image("Nextlevel.png");
        ImageView nextlevel = new ImageView();
        group.getChildren().add(nextlevel);

        final double[] rotatespeed = new double[]{0.6};
        final boolean[] is_ballfly = new boolean[]{false};
        final double[] ballspeed = new double[2];
        final double[] cannondegree = new double[1];
        final double[] time = new double[]{-1000,0,0,0,0,0,0};
        final boolean[] is_ships_spawn = new boolean[]{false,false};
        final double[] shipspawntime = new double[]{0,0};
        final int[] lives = new int[]{3,0};
        final boolean[] HP = new boolean[]{true,true,true};
        final int[] kills = new int[]{0,3,0};
        final boolean[] is_continue = new boolean[]{true};
        final double[] shipspeed = new double[]{0.7};
        final boolean[] is_shipkilled = new boolean[]{false,false,false,false};
        final double[] killedcords = new double[2];

        //Начало игры
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        if (lives[0] > 0 & kills[0] != kills[1] & is_continue[0]){

                            //Счетчики
                            killcount.setText("Kills: " + kills[2]);

                            //Появление жизней
                            if (lives[1] == 0){
                                HP1_1.setImage(HP1_1img);
                                HP1_1.setLayoutX(700);
                                HP1_1.setLayoutY(440);

                                HP0_1.setImage(HP0_1img);
                                HP0_1.setLayoutX(700);
                                HP0_1.setLayoutY(440);

                                HP1_2.setImage(HP1_2img);
                                HP1_2.setLayoutX(790);
                                HP1_2.setLayoutY(440);

                                HP0_2.setImage(HP0_2img);
                                HP0_2.setLayoutX(790);
                                HP0_2.setLayoutY(440);

                                HP1_3.setImage(HP1_3img);
                                HP1_3.setLayoutX(880);
                                HP1_3.setLayoutY(440);

                                HP0_3.setImage(HP0_3img);
                                HP0_3.setLayoutX(880);
                                HP0_3.setLayoutY(440);

                                HP[0] = true;
                                HP[1] = true;
                                HP[2] = true;
                                lives[1] = 1;

                            }

                            //Волны
                            if (waveright1.getLayoutX() < 0){
                                waveright1.setLayoutX(waveright1.getLayoutX() + 0.15);
                            }
                            else{
                                waveright1.setLayoutX(-1000);
                            }
                            if (waveleft1.getLayoutX() > -1000){
                                waveleft1.setLayoutX(waveleft1.getLayoutX() - 0.2);
                            }
                            else{
                                waveleft1.setLayoutX(0);
                            }
                            if (waveright2.getLayoutX() < 0){
                                waveright2.setLayoutX(waveright2.getLayoutX() + 0.25);
                            }
                            else{
                                waveright2.setLayoutX(-1000);
                            }
                            if (waveleft2.getLayoutX() > -1000){
                                waveleft2.setLayoutX(waveleft2.getLayoutX() - 0.3);
                            }
                            else{
                                waveleft2.setLayoutX(0);
                            }
                            if (waveright3.getLayoutX() < 0){
                                waveright3.setLayoutX(waveright3.getLayoutX() + 0.35);
                            }
                            else{
                                waveright3.setLayoutX(-1000);
                            }

                            //Вращение пушки
                            cannon.setRotate(cannon.getRotate() + rotatespeed[0]);
                            if (cannon.getRotate() >= 28){
                                rotatespeed[0] = -0.6;
                            }
                            if (cannon.getRotate() <= -30){
                                rotatespeed[0] = 0.6;
                            }

                            //Появление корабля 1
                            if (!is_ships_spawn[0]){
                                ship1.setImage(ship1img);
                                ship1.setLayoutX(1000);
                                ship1.setLayoutY(150);

                                //Ждет время для появления
                                if (time[1] == time[2]){
                                    time[2] =  (Math.random() * 10000) + 3000;
                                }

                                if (shipspawntime[1] + time[1] < System.currentTimeMillis() & time[5] + time[1] < System.currentTimeMillis()){
                                    is_ships_spawn[0] = true;
                                    shipspawntime[0] = System.currentTimeMillis();
                                    time[1] = time[2];
                                }
                            }
                            else{
                                ship1.setLayoutX(ship1.getLayoutX() - shipspeed[0]);
                                //Вышел за границу
                                if (ship1.getLayoutX() < -60){
                                    is_ships_spawn[0] = false;
                                    time[5] = System.currentTimeMillis();
                                    //Уменьшение жизней
                                    if (HP[2]){
                                        HP1_1.setLayoutX(1000);
                                        HP1_1.setLayoutY(1000);
                                        HP[2] = false;
                                    }
                                    else if (HP[1]){
                                        HP1_2.setLayoutX(1000);
                                        HP1_2.setLayoutY(1000);
                                        HP[1] = false;
                                    }
                                    else{
                                        HP1_3.setLayoutX(1000);
                                        HP1_3.setLayoutY(1000);
                                        HP[0] = false;
                                    }
                                    lives[0] --;
                                    kills[0] ++;
                                }
                            }

                            //Появление горящего корабля1
                            if (is_shipkilled[0]){
                                if (is_shipkilled[2]){
                                    ship1fire.setImage(ship1fireimg);
                                    ship1fire.setLayoutX(killedcords[0]);
                                    ship1fire.setLayoutY(150);
                                    is_shipkilled[2] = false;
                                }
                                if (time[5] + 1000 > System.currentTimeMillis()){
                                    ship1fire.setLayoutX(ship1fire.getLayoutX() - shipspeed[0]);
                                }
                                else{
                                    ship1fire.setLayoutX(1000);
                                    ship1fire.setLayoutY(1000);
                                    is_shipkilled[0] = false;
                                }
                            }

                            //Появление корабля 2
                            if (!is_ships_spawn[1]){
                                ship2.setImage(ship2img);
                                ship2.setLayoutX(1000);
                                ship2.setLayoutY(150);

                                //Ждет время для появления
                                if (time[3] == time[4]){
                                    time[4] =  (Math.random() * 10000) + 3000;
                                }

                                if (shipspawntime[0] + time[1] < System.currentTimeMillis() & time[6] + time[1] < System.currentTimeMillis()){
                                    is_ships_spawn[1] = true;
                                    shipspawntime[1] = System.currentTimeMillis();
                                    time[3] = time[4];
                                }
                            }
                            else{
                                ship2.setLayoutX(ship2.getLayoutX() - shipspeed[0]);
                                //Вышел за границу
                                if (ship2.getLayoutX() < -60){
                                    is_ships_spawn[1] = false;
                                    time[6] = System.currentTimeMillis();
                                    //Уменьшение жизней
                                    if (HP[2]){
                                        HP1_1.setLayoutX(1000);
                                        HP1_1.setLayoutY(1000);
                                        HP[2] = false;

                                    }
                                    else if (HP[1]){
                                        HP1_2.setLayoutX(1000);
                                        HP1_2.setLayoutY(1000);
                                        HP[1] = false;
                                    }
                                    else{
                                        HP1_3.setLayoutX(1000);
                                        HP1_3.setLayoutY(1000);
                                        HP[0] = false;
                                    }
                                    lives[0] --;
                                    kills[0] ++;
                                }
                            }

                            //Появление горящего корабля2
                            if (is_shipkilled[1]){
                                if (is_shipkilled[3]){
                                    ship2fire.setImage(ship2fireimg);
                                    ship2fire.setLayoutX(killedcords[1]);
                                    ship2fire.setLayoutY(150);
                                    is_shipkilled[3] = false;
                                }
                                if (time[6] + 1000 > System.currentTimeMillis()){
                                    ship2fire.setLayoutX(ship2fire.getLayoutX() - shipspeed[0]);
                                }
                                else{
                                    ship2fire.setLayoutX(1000);
                                    ship2fire.setLayoutY(1000);
                                    is_shipkilled[1] = false;
                                }
                            }

                            //Выстрел
                            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (mouseEvent.getSceneX() > 400 & mouseEvent.getSceneX() < 600 &
                                            mouseEvent.getSceneY() > 300 & mouseEvent.getSceneY() < 500){
                                        if (time[0] + 1000 <= System.currentTimeMillis() & !is_ballfly[0]){
                                            time[0] = System.currentTimeMillis();
                                            ball.setImage(ballimg);
                                            ball.setScaleX(1);
                                            ball.setScaleY(1);
                                            cannondegree[0] = cannon.getRotate();

                                            //Расчет скорости
                                            if (cannon.getRotate() >= 0){
                                                ball.setLayoutX(480 + 115 * Math.sin(Math.toRadians(cannondegree[0])));
                                                ball.setLayoutY(430 - 85 * Math.cos(Math.toRadians(cannondegree[0])));
                                                ballspeed[0] = 1 * Math.sin(Math.toRadians(cannondegree[0]));
                                                ballspeed[1] = 1 * Math.cos(Math.toRadians(cannondegree[0]));
                                            }
                                            else{
                                                ball.setLayoutX(480 - 115 * Math.sin(Math.toRadians(Math.abs(cannon.getRotate()))));
                                                ball.setLayoutY(430 - 85 * Math.cos(Math.toRadians(Math.abs(cannon.getRotate()))));
                                                ballspeed[0] = 1 * Math.sin(Math.toRadians(Math.abs(cannon.getRotate())));
                                                ballspeed[1] = 1 * Math.cos(Math.toRadians(Math.abs(cannon.getRotate())));
                                            }
                                            is_ballfly[0] = true;
                                        }
                                    }
                                }
                            });
                            if (is_ballfly[0]){
                                if (cannondegree[0] >= 0){
                                    ball.setLayoutX(ball.getLayoutX() + ballspeed[0]);
                                    ball.setLayoutY(ball.getLayoutY() - ballspeed[1]);
                                }
                                else{
                                    ball.setLayoutX(ball.getLayoutX() - ballspeed[0]);
                                    ball.setLayoutY(ball.getLayoutY() - ballspeed[1]);
                                }
                                ball.setScaleX(ball.getScaleX() - 0.003);
                                ball.setScaleY(ball.getScaleY() - 0.003);

                                //Если вылетело за пределы
                                if (ball.getLayoutX() - 20 * (1 - ball.getScaleX()) < -40 | ball.getLayoutY() - 20 * (1 - ball.getScaleY()) < 110){
                                    is_ballfly[0] = false;
                                    ball.setLayoutX(1000);
                                    ball.setLayoutY(1000);
                                }

                                //Если плывет корабль
                                else if (is_ships_spawn[0] | is_ships_spawn[1]){
                                    if (ball.getLayoutY() + 20 * (1 - ball.getScaleY()) <= 210 & ball.getLayoutY() + 20 * (1 - ball.getScaleY()) >= 110){
                                        if (ball.getLayoutX() - 20 * (1 - ball.getScaleX()) >= ship1.getLayoutX() - 40 &
                                                ball.getLayoutX() + 20 * (1 - ball.getScaleX()) <= ship1.getLayoutX() + 60){
                                            killedcords[0] = ship1.getLayoutX();
                                            is_ships_spawn[0] = false;
                                            is_ballfly[0] = false;
                                            ball.setLayoutX(1000);
                                            ball.setLayoutY(1000);
                                            time[5] = System.currentTimeMillis();
                                            is_shipkilled[0] = true;
                                            is_shipkilled[2] = true;
                                            kills[0] ++;
                                            kills[2] ++;
                                            killcount.setText("Kills: " + kills[2]);
                                        }
                                        else if (ball.getLayoutX() - 20 * (1 -ball.getScaleX()) >= ship2.getLayoutX() - 40 &
                                                ball.getLayoutX() + 20 * (1 - ball.getScaleX()) <= ship2.getLayoutX() + 60){
                                            killedcords[1] = ship2.getLayoutX();
                                            is_ships_spawn[1] = false;
                                            is_ballfly[0] = false;
                                            ball.setLayoutX(1000);
                                            ball.setLayoutY(1000);
                                            time[6] = System.currentTimeMillis();
                                            is_shipkilled[1] = true;
                                            is_shipkilled[3] = true;
                                            kills[0] ++;
                                            kills[2] ++;
                                            killcount.setText("Kills: " + kills[2]);
                                        }
                                    }
                                }
                            }
                        }
                        //Уровень окончен
                        else{
                            is_continue[0] = false;

                            //Не пройден
                            if (lives[0] <= 0){
                                gameover.setImage(gameoverimg);
                                gameover.setLayoutX(0);
                                gameover.setLayoutY(0);
                            }

                            //Пройден
                            else{
                                nextlevel.setImage(nextlevelimg);
                                nextlevel.setLayoutX(0);
                                nextlevel.setLayoutY(0);
                            }
                            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    ship1.setLayoutX(1000);
                                    ship1.setLayoutY(1000);
                                    ship2.setLayoutX(1000);
                                    ship2.setLayoutY(1000);
                                    is_ships_spawn[0] = false;
                                    is_ships_spawn[1] = false;
                                    ball.setLayoutX(1000);
                                    ball.setLayoutY(1000);
                                    is_ballfly[0] = false;
                                    cannon.setRotate(0);
                                    time[0] = -1000;
                                    time[1] = 0;
                                    time[2] = 0;
                                    time[3] = 0;
                                    time[4] = 0;
                                    time[5] = 0;
                                    time[6] = 0;
                                    shipspawntime[0] = 0;
                                    shipspawntime[1] = 0;
                                    kills[0] = 0;
                                    if (lives[0] <= 0){
                                        kills[1] = 3;
                                        shipspeed[0] = 0.7;
                                        level.setText("Level: " + 1);
                                        kills[2] = 0;
                                        gameover.setLayoutX(1000);
                                        gameover.setLayoutY(1000);

                                    }
                                    else{
                                        kills[1] ++;
                                        shipspeed[0] += 0.5;
                                        level.setText("Level: " + (kills[1] - 2));
                                        nextlevel.setLayoutX(1000);
                                        nextlevel.setLayoutY(1000);
                                    }
                                    lives[1] = 0;
                                    lives[0] = 3;
                                    is_continue[0] = true;
                                }
                            });

                        }
                    }
                };
                timer.start();
            }
        });

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Pirates and cannons game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}