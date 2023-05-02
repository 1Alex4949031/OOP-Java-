package ru.nsu.seleznev.a.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.nsu.seleznev.a.SnakeGame;

/**
 * RestartController class. Presents the controller for RestartScene fxml
 */
public class RestartController implements Initializable {
  @FXML
  Stage gameOverStage;
  @FXML
  ImageView imageView;
  @FXML
  Text scoreSection;
  private final SnakeGame game;
  private final Timeline timeline;

  /**
   * RestartController constructor.
   *
   * @param game     game need to be restarted
   * @param timeline timeline of the game
   */
  public RestartController(SnakeGame game, Timeline timeline) {
    this.game = game;
    this.timeline = timeline;
  }

  /**
   * Function that sets the Score Text for RestartScene.
   *
   * @param score score of the Game
   */
  public void setScoreSection(String score) {
    scoreSection.setText(score);
  }

  /**
   * Function that handles the click on image.
   *
   * @throws IOException connected with restarting the game
   */
  @FXML
  public void handleImageClick() throws IOException {
    gameOverStage.close();
    game.initialState();
    timeline.play();
  }

  /**
   * Function that initializes Restart Scene fxml.
   *
   * @param location  The location used to resolve relative paths for the root object, or
   *                  {@code null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if
   *                  the root object was not localized.
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    scoreSection.setText("If u see text, it's a trouble)");
    imageView.setOnMouseClicked(event -> {
      try {
        handleImageClick();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
