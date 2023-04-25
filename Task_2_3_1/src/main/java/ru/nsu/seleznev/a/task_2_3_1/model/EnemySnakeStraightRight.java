package ru.nsu.seleznev.a.task_2_3_1.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * EnemySnakeStraightRight class that implements snakeLeft behavior.
 */
public class EnemySnakeStraightRight extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRight/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRight/snakeTail.png")));
  private final Image headRight = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRight/snakeHeadRight.png")));

  /**
   * EnemySnakeStraightRight constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param x          x-coordinate for initialization
   * @param y          y-coordinate for initialization
   * @param size       initial size of the snake
   */
  public EnemySnakeStraightRight(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that counts that next direction for the Snake.
   *
   * @param unused unused
   */
  @Override
  public void movingNext(Food unused) {
    moveRight();
  }

  /**
   * Function that draws the Snake in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  @Override
  public void drawSnake(GraphicsContext gc) {
    drawPoint(gc, headRight, 0);
    for (int i = 1; i < getSnakeBody().size() - 1; i++) {
      drawPoint(gc, body, i);
    }
    drawPoint(gc, tail, getSnakeSize() - 1);
  }
}
