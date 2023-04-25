package ru.nsu.seleznev.a.task_2_3_1.model;


import java.util.Objects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * EnemySnakeStraightLeft class that implements snakeLeft behavior.
 */
public class EnemySnakeStraightLeft extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeLeft/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeLeft/snakeTail.png")));
  private final Image headLeft = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeLeft/snakeHeadLeft.png")));

  /**
   * EnemySnakeStraightLeft constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param x          x-coordinate for initialization
   * @param y          y-coordinate for initialization
   * @param size       initial size of the snake
   */
  public EnemySnakeStraightLeft(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that counts that next direction for the Snake.
   *
   * @param unused unused
   */
  @Override
  public void movingNext(Food unused) {
    moveLeft();
  }

  /**
   * Function that draws the Snake in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  @Override
  public void drawSnake(GraphicsContext gc) {
    drawPoint(gc, headLeft, 0);
    for (int i = 1; i < getSnakeBody().size() - 1; i++) {
      drawPoint(gc, body, i);
    }
    drawPoint(gc, tail, getSnakeSize() - 1);
  }
}
