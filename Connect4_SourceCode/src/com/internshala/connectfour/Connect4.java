package com.internshala.connectfour;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Connect4 extends Application {

    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane  rootGridPane=loader.load();
        controller=loader.getController();
        controller.createPlayGround();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane=(Pane)rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene=new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    private MenuBar createMenu()
    {
        Menu fileMenu=new Menu("File");
        MenuItem newGame=new MenuItem("New");
        newGame.setOnAction(event->controller.resetGame());

        MenuItem resetGame=new MenuItem("Reset");
        resetGame.setOnAction(event->controller.resetGame());

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();

        MenuItem quitGame=new MenuItem("Quit");
        quitGame.setOnAction(event->quitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,quitGame);


        Menu helpMenu=new Menu("Help");
        MenuItem aboutGame=new MenuItem("About Connect4");
        aboutGame.setOnAction(event->aboutConnect4());

        SeparatorMenuItem separatorMenuItem1=new SeparatorMenuItem();
        MenuItem aboutMe=new MenuItem("About Me");
        aboutMe.setOnAction(event->aboutMe());

        helpMenu.getItems().addAll(aboutGame,separatorMenuItem1,aboutMe);



        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }
    private void quitGame()
    {
        Platform.exit();
        System.exit(0);
    }
    private void aboutConnect4()
    {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which "
                + "the players first choose a color and then take turns dropping colored "
                + "discs from the top into a seven-column, "
                + "six-row vertically suspended grid. The pieces fall straight down, occupying the next "
                + "available space within the column. The objective of the game is to be the first to form a"
                + " horizontal, vertical, or diagonal line of four of one's own discs. "
                + "Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }
    private void aboutMe()
    {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Prafful Saraogi");
        alert.setContentText("I love to spend my time with coding and creating fascinating games.Conect4"
                + " is one of my created Games");
        alert.show();
    }
}
