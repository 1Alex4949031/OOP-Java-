package ru.nsu.seleznev.a.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MenuController class. Presents the controller for Menu fxml.
 */
@NoArgsConstructor
public class MenuController implements Initializable {
  @FXML
  Stage menuStage;
  @FXML
  Button startButton;
  @FXML
  Button exitButton;
  @Setter
  private Stage primaryStage;
  @Setter
  private Timeline timeline;

  /**
   * Function that initializes buttons in the Menu Stage.
   *
   * @param location  The location used to resolve relative paths for the root object, or
   *                  {@code null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if
   *                  the root object was not localized.
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    startButton.setOnAction(event -> {
      primaryStage.show();
      timeline.play();
      menuStage.close();
    });
    exitButton.setOnAction(event -> Platform.exit());
  }
}
