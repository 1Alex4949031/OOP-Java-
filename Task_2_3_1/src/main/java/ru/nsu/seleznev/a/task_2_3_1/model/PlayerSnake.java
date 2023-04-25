package ru.nsu.seleznev.a.task_2_3_1.model;


import java.util.Objects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * PlayerSnake class that implements Player's snake.
 */
public class PlayerSnake extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/snakePlayer/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/snakePlayer/snakeTail.png")));
  private final Image headRight = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/snakePlayer/snakeHeadRight.png")));
  private final Image headLeft = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/snakePlayer/snakeHeadLeft.png")));
  private final Image headUp = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/snakePlayer/snakeHeadUp.png")));
  private final Image headDown = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/snakePlayer/snakeHeadDown.png")));

  /**
   * PlayerSnake constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   */
  public PlayerSnake(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that changes the direction of the PLayer's Snake.
   */
  public void movingNext() {
    switch (getCurrentDirection()) {
      case RIGHT -> moveRight();
      case LEFT -> moveLeft();
      case UP -> moveUp();
      case DOWN -> moveDown();
    }
  }

  /**
   * Function that draws the snake in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  @Override
  public void drawSnake(GraphicsContext gc) {
    switch (getCurrentDirection()) {
      case RIGHT -> drawPoint(gc, headRight, 0);
      case LEFT -> drawPoint(gc, headLeft, 0);
      case UP -> drawPoint(gc, headUp, 0);
      case DOWN -> drawPoint(gc, headDown, 0);
    }
    for (int i = 1; i < getSnakeBody().size() - 1; i++) {
      drawPoint(gc, body, i);
    }
    drawPoint(gc, tail, getSnakeSize() - 1);
  }
}
