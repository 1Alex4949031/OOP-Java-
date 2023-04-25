package ru.nsu.seleznev.a.task_2_3_1.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * EnemySnakeStraightDown class that implements the snakeDown behavior.
 */
public class EnemySnakeStraightDown extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeDown/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeDown/snakeTail.png")));
  private final Image headDown = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeDown/snakeHeadDown.png")));


  /**
   * EnemySnakeStraightDown constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param x          x-coordinate for initialization
   * @param y          y-coordinate for initialization
   * @param size       initial size of the snake
   */
  public EnemySnakeStraightDown(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that counts next direction for snakeDown behavior.
   *
   * @param unused unused
   */
  @Override
  public void movingNext(Food unused) {
    moveDown();
  }

  /**
   * Function that draws the Snake in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  @Override
  public void drawSnake(GraphicsContext gc) {
    drawPoint(gc, headDown, 0);
    for (int i = 1; i < getSnakeBody().size() - 1; i++) {
      drawPoint(gc, body, i);
    }
    drawPoint(gc, tail, getSnakeSize() - 1);
  }
}
