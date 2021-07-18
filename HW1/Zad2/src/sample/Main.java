package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Group group = new Group();//creating new group
        Scene scene = new Scene(group, 700, 700);//setting the scene


        //Drawing the first line, just the idea
        /*Line line = new Line(0, 0, 800, 250);
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(1);
        group.getChildren().add(line);*/

        //I am going to show with different colors every single drawing from the corner
        drawFromLeftUpperCorner(group, scene, Color.CYAN);
        drawFromLeftDownCorner(group, scene, Color.RED);
        drawFromRightDownCorner(group, scene, Color.ORANGE);
        drawFromRightUpperCorner(group, scene, Color.BLUEVIOLET);

        primaryStage.setTitle("Canvas demo");//The name of the stage
        primaryStage.setScene(scene);//setting the scene
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    private void drawFromLeftUpperCorner(Group group, Scene scene, Color color)
    {
        double width = scene.getWidth();//getting the scene width
        double height = scene.getHeight();//getting the scene height

        //setting the X, Y coordinates in two-dimensional
        double startX, startY, endX, endY;
        startX= 0;//the start point X-coordinate
        startY = 0;//the start point Y-coordinate
        endX = 0;//the end point X-coordinate
        endY = height;//the end point Y-coordinate

        //we are moving both the start and final X or Y coordinates to draw a single Line and then using the
        // while, we are going to draw multiple ones.

        while(endX != width && startY != height)//looping while we hit the restrictions
        {
            Line line = new Line(startX, startY, endX, endY );//drawing a single Line
            line.setStroke(color);//setting the Color
            line.setStrokeWidth(1);//setting the width
            group.getChildren().add(line);//Adding the Line

            startY += 20;//moving the start Y 20px
            endX+=20;//moving the end X 20px
        }

    }

    private void drawFromLeftDownCorner(Group group, Scene scene, Color color)
    {
        double width = scene.getWidth();//getting the scene width
        double height = scene.getHeight();//getting the scene height

        double startX, startY, endX, endY;
        startX= 0;//the start point X-coordinate
        startY = height;//the start point Y-coordinate
        endX = width;//the end point X-coordinate
        endY = height;//the end point Y-coordinate

        while(startX != width && endY != 0)//looping while we hit the restrictions
        {
            Line line = new Line(startX, startY, endX, endY );//drawing a single Line
            line.setStroke(color);//setting the Color
            line.setStrokeWidth(1);//setting the width
            group.getChildren().add(line);//Adding the Line

            endY -= 20;//moving the end Y 20px
            startX+=20;//moving the start X 20px
        }

    }

    private void drawFromRightDownCorner(Group group, Scene scene, Color color)
    {
        double width = scene.getWidth();//getting the scene width
        double height = scene.getHeight();//getting the scene height

        double startX, startY, endX, endY;
        startX= width;//the start point X-coordinate
        startY = height;//the start point Y-coordinate
        endX = width;//the end point X-coordinate
        endY = 0;//the end point Y-coordinate

        while(startY != 0 && endX != 0)//looping while we hit the restrictions
        {
            Line line = new Line(startX, startY, endX, endY );//drawing a single Line
            line.setStroke(color);//setting the Color
            line.setStrokeWidth(1);//setting the width
            group.getChildren().add(line);//Adding the Line

            startY -= 20; //moving the start Y 20px
            endX-=20;//moving the end X 20px
        }

    }

    private void drawFromRightUpperCorner(Group group, Scene scene, Color color)
    {
        double width = scene.getWidth();//getting the scene width
        double height = scene.getHeight();//getting the scene height

        double startX, startY, endX, endY;
        startX= width;//the start point X-coordinate
        startY = 0;//the start point Y-coordinate
        endX = 0;//the end point X-coordinate
        endY = 0;//the end point Y-coordinate

        while(startX != 0 && endY != height)//looping while we hit the restrictions
        {
            Line line = new Line(startX, startY, endX, endY );//drawing a single Line
            line.setStroke(color);//setting the Color
            line.setStrokeWidth(1);//setting the width to 1
            group.getChildren().add(line);//Adding the Line

            endY += 20;//moving the end Y 20px
            startX-=20;//moving the start X 20px
        }

    }
}

