package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();//creating the group
        Scene scene = new Scene(group, 350, 350);//creating the scene
        drawSpiral(group, scene, Color.RED);//function to draw Spiral
        primaryStage.setTitle("Draw square shaped spiral");//setting the Title
        primaryStage.setScene(scene);//setting the scene
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
    public void drawSpiral(Group group, Scene scene, Color color)
    {
        double height = scene.getHeight();//getting the height
        double width = scene.getWidth();//getting the width
        double widthCenter = width / 2;//getting the center and the start for the spiral
        double heightCenter = height / 2;//getting the center and the start for the spiral

            for (int i = 0; i < 5 ; i++)//for loop to draw multiple times these lines with increased length
            {
                int t = (20 * i);//making the code more readable multiplying the coordinates
               Line line1 =new Line(widthCenter +t, heightCenter +t, widthCenter +t, heightCenter + 20 +t);//the first line
               Line line2 = new Line(widthCenter +t, heightCenter + 20 +t, widthCenter - 20 -t, heightCenter + 20 +t);//the second line
               Line line3 = new Line(widthCenter - 20 -t, heightCenter + 20 +t, widthCenter - 20 -t, heightCenter - 20 -t);//the third line
               Line line4 = new Line(widthCenter - 20 -t, heightCenter - 20 -t, widthCenter + 20 +t, heightCenter - 20 -t);//the fourth line
               Line line5 = new Line(widthCenter  + 20 +t, heightCenter - 20 -t, widthCenter + 20 +t, heightCenter + 20 +t);//the fifth line

               line1.setStroke(color);//setting the color for the line 1
               line2.setStroke(color);//setting the color for the line 2
               line3.setStroke(color);//setting the color for the line 3
               line4.setStroke(color);//setting the color for the line 4
               line5.setStroke(color);//setting the color for the line 5

               line1.setStrokeWidth(1);//setting the width for the line 5
               line2.setStrokeWidth(1);//setting the width for the line 5
               line3.setStrokeWidth(1);//setting the width for the line 5
               line4.setStrokeWidth(1);//setting the width for the line 5
               line5.setStrokeWidth(1);//setting the width for the line 5

               group.getChildren().add(line1);//adding the line to the group
               group.getChildren().add(line2);//adding the line to the group
               group.getChildren().add(line3);//adding the line to the group
               group.getChildren().add(line4);//adding the line to the group
               group.getChildren().add(line5);//adding the line to the group
            }
        }




}

