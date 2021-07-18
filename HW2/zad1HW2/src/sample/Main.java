package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Group group = new Group();//setting the Group
        Scene scene = new Scene(group, 400, 200);//Setting the Scene

        int monthInputed = monthSetting();//getting the month as a number
        int yearInputed = yearSetting();//getting the year
        constructCalendar(monthInputed, yearInputed, group);

        primaryStage.setTitle(String.format("Calendar for the %s %d",
                Month.of(monthInputed).getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                Year.of(yearInputed).getValue()));//setting the title to match the month and year
        primaryStage.setScene(scene);//setting the scene
        primaryStage.show();//show the app

    }

    public static void main(String[] args) {
        launch(args);
    }

    private int monthSetting()
    {
        TextInputDialog monthDialog = new TextInputDialog();//creating input dialog
        monthDialog.setTitle("Month picker");//setting the title of the dialog
        monthDialog.setContentText("Enter month");//setting  the content text of the dialog
        monthDialog.setHeaderText(null);
        int month;//create int to save the number of the month
        Optional<String> monthGet = monthDialog.showAndWait();//waiting for the answer
        try {
            month = Integer.parseInt(monthGet.get());//trying to catch an error and validate
            if(month< 0 || month > 12)//validating the input
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);//creating an Alert
                alert.setTitle("Info Dialog");//setting title
                alert.setHeaderText("You entered invalid number for the month now is January by default!");//setting header text
                alert.showAndWait();//waiting to respond
                month = 1;//setting default month
            }
        }
        catch (NumberFormatException e)//cathing if it is not an INTEGER
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);//creating an Alert
            alert.setTitle("Info Dialog");//setting Title
            alert.setHeaderText("You entered different from INT the month now is January by default!");//setting header text
            alert.showAndWait();//waiting to respond
            month = 1;//setting the default month
        }
        return month;//returning the result of the function
    }
    private int yearSetting()
    {
        TextInputDialog yearDialog = new TextInputDialog();//creating TextInputDialog
        yearDialog.setTitle("Year picker");//setting title
        yearDialog.setContentText("Enter year");//setting the content text
        yearDialog.setHeaderText(null);//header text is null
        int year;//the year initialization
        Optional<String> yearGet = yearDialog.showAndWait();//waiting for the answer

            try {
                year = Integer.parseInt(yearGet.get());//trying to catch an error
            }
            catch (NumberFormatException e)//validating when an error is catched by the program
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);//creating an Alert
                alert.setTitle("Info Dialog");//setting the title
                alert.setHeaderText("You entered different from INT the year now is 2021 by default!");//setting the header text
                alert.showAndWait();
                year = 2021;//default year if the answer is not correct
            }
        return year;//return the result from the function

    }

    private void constructCalendar(int monthNeeded, int yearNeeded, Group group)//function to construct the calendar
    {
        int startDay = LocalDate.of(yearNeeded, monthNeeded, 1).getDayOfWeek().getValue();//what is the day of the week in the month
        for (int i = 1; i <= 7; i++)//for loop to set the header with the names of the week
        {
            String dayName = DayOfWeek.of(i).getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase(Locale.ROOT);//getting the name of the i day in string

                Text text = new Text((i * 50), 15, dayName);
                if (i == 6 || i == 7)
                {
                    text.setStroke(Color.RED);//if it is weekend it is going to be marked in red color
                }
                group.getChildren().add(text);
        }
        int monthDays = Month.of(monthNeeded).length(Year.isLeap(yearNeeded));//getting the number of days in the month
        int weekCounter = 2;//counting how many weeks are there in month to get a new row with different coordinates
        boolean entered = false;//boolean to help the function

        for(int j = 1; j <= monthDays; j++)//for loop for the days in the month
        {
            for(int i = 1; i <= 7; i++)//for loop for the days in the week
            {
                if(i != startDay && !entered)
                {
                    continue;//if to skip a days when our month start from a day different from Monday
                }
                else
                {
                    Text newDate = new Text(i*50, weekCounter * 20, Integer.toString(j));//creating the Text for JavaFX with j to string
                    if(j == LocalDate.now().getDayOfMonth() && Month.of(monthNeeded).getValue() == LocalDate.now().getMonthValue()
                            && Year.now().getValue() == yearNeeded)//if it is the current date in the current month
                    {
                        newDate.setStroke(Color.RED);//we are setting the color to RED
                    }
                    group.getChildren().add(newDate);//adding to the group
                    entered =true;//once entered we have found in which day our month starts
                    if(j < monthDays && i != 7) {
                        j++;//increasing only to the days in the month
                    }
                    else break;
                }
            }
            weekCounter++;//for every loop we know we have a new week
        }
    }
}
