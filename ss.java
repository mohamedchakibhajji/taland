/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Chekib
 */


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ss extends Application
{
   @Override
   public void start(Stage primaryStage) throws InterruptedException
   {
      ImageView webviewPreviewImage = new ImageView();
      Label waitLabel = new Label("Please wait...");
      WebView webView = new WebView();
      webView.setMaxHeight(480d);
      webView.setMinHeight(480d);
      webView.setMaxWidth(640d);
      webView.setMinWidth(640d);
      webView.setZoom(0.1);

      ScrollPane scrollpane = new ScrollPane(webView);
      scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      scrollpane.setMaxWidth(0); //WORKAROUND: hide the WebView/ScrollPane
      scrollpane.setMaxHeight(0); //WORKAROUND: hide the WebView/ScrollPane
      scrollpane.setMinWidth(0); //WORKAROUND: hide the WebView/ScrollPane
      scrollpane.setMinHeight(0); //WORKAROUND: hide the WebView/ScrollPane

      //scrollpane.setVisible(false); //when WebView is invisible,  SnapShot doesn't work!

       webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() 
       {
          @Override
          public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) 
          {
              if (newState == Worker.State.SUCCEEDED) 
              {
                 //When SUCCEEDED is called, the WebPage may not has fully finished rendering!
                 //so, wait for few seceonds before making the screenshot...
                 Timeline timeline = new Timeline(new KeyFrame(
                         Duration.millis(1500),
                         ae -> takeSnapshot()));
                 timeline.play();
              }
           }

           private KeyFrame takeSnapshot()
           {
              webView.snapshot((SnapshotResult param) ->
              {
                 webviewPreviewImage.setImage(param.getImage());
                 webviewPreviewImage.setFitHeight(1366d);
                 webviewPreviewImage.setFitWidth(768d);
                 webviewPreviewImage.setPreserveRatio(true);
                 waitLabel.setVisible(false);
                 return null;
              }, null, null);
              return null;
          }
      });
      webView.getEngine().load("https://www.google.com/maps/place/korba/");

      VBox root = new VBox();
      root.setAlignment(Pos.CENTER);
      root.setSpacing(10d);
      root.getChildren().add(waitLabel);
      root.getChildren().add(scrollpane);
      root.getChildren().add(webviewPreviewImage);

      Scene scene = new Scene(root, 1366, 768);
      primaryStage.setScene(scene);
      primaryStage.show();
  }

  public static void main(String[] args)
  {
     launch(args);
  }
}
