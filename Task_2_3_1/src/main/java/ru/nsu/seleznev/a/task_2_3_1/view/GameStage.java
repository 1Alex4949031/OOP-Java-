package ru.nsu.seleznev.a.task_2_3_1.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.Getter;
import ru.nsu.seleznev.a.task_2_3_1.model.PlayerSnake;

/**
 * GameStage class. Presents the main field of the SnakeGame.
 */
public class GameStage {
  @Getter
  private final GraphicsContext gc;
  private static final int RIGHT = 0;
  private static final int LEFT = 1;
  private static final int UP = 2;
  private static final int DOWN = 3;


  /**
   * GameStage constructor.
   *
   * @param primaryStage primaryStage
   * @param score        score part
   * @param snake        Player snake used for handle buttons
   * @param WIDTH        WIDTH of the field
   * @param HEIGHT       HEIGHT of the filed
   */
  public GameStage(Stage primaryStage, Score score, PlayerSnake snake, int WIDTH, int HEIGHT) {
    primaryStage.setTitle("Snake");
    Group root = new Group();
    Scene scene = new Scene(root);
    BorderPane pane = new BorderPane();
    Canvas canvas = new Canvas(WIDTH, HEIGHT);
    gc = canvas.getGraphicsContext2D();
    pane.setCenter(canvas);
    pane.setRight(score);
    root.getChildren().addAll(pane);
    scene.setOnKeyPressed(event -> {
      KeyCode code = event.getCode();
      if (code == KeyCode.RIGHT || code == KeyCode.D) {
        if (snake.getCurrentDirection() != LEFT) {
          snake.setCurrentDirection(RIGHT);
        }
      } else if (code == KeyCode.LEFT || code == KeyCode.A) {
        if (snake.getCurrentDirection() != RIGHT) {
          snake.setCurrentDirection(LEFT);
        }
      } else if (code == KeyCode.UP || code == KeyCode.W) {
        if (snake.getCurrentDirection() != DOWN) {
          snake.setCurrentDirection(UP);
        }
      } else if (code == KeyCode.DOWN || code == KeyCode.S) {
        if (snake.getCurrentDirection() != UP) {
          snake.setCurrentDirection(DOWN);
        }
      }
    });
    scene.setFill(Color.web("#A2D149"));
    primaryStage.setScene(scene);
  }
}
