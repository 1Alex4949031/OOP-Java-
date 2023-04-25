package ru.nsu.seleznev.a.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;

/**
 * Score class that implements Score section.
 */
public class Score extends BorderPane {
  @Getter
  private int score;
  private final Label scoreLabel;

  /**
   * Score constructor.
   */
  public Score() {
    scoreLabel = new Label("Score: " + score + " ");
    scoreLabel.setFont(Font.font("Arial", 20));
    scoreLabel.setTextFill(Color.GREEN);
    setStyle("-fx-border-color: green; -fx-border-width: 2px;");
    setBackground(null);
    setCenter(scoreLabel);
    setPrefSize(200, 50);
  }

  /**
   * Function that restarts the score.
   */
  public void restartScore() {
    score = 0;
    scoreLabel.setText("Score: " + score);
  }

  /**
   * Function that adds one the current score.
   */
  public void plusOneToScore() {
    score += 1;
    scoreLabel.setText("Score: " + score);
  }
}
