package ru.nsu.seleznev.a.model;


import java.util.Objects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * EnemySnakeStraightUp class that implements snakeLeft behavior.
 */
public class EnemySnakeStraightUp extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeUp/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeUp/snakeTail.png")));
  private final Image headUp = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeUp/snakeHeadUp.png")));


  /**
   * EnemySnakeStraightUp constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param x          x-coordinate for initialization
   * @param y          y-coordinate for initialization
   *                   @param size       initial size of the snake
   */
  public EnemySnakeStraightUp(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that counts that next direction for the Snake.
   *
   * @param unused unused
   */
  @Override
  public void movingNext(Food unused) {
    moveUp();
  }

  /**
   * Function that draws the Snake in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  @Override
  public void drawSnake(GraphicsContext gc) {
    drawPoint(gc, headUp, 0);
    for (int i = 1; i < getSnakeBody().size() - 1; i++) {
      drawPoint(gc, body, i);
    }
    drawPoint(gc, tail, getSnakeSize() - 1);
  }
}
