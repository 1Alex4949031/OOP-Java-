package ru.nsu.seleznev.a.model;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract SnakeDefault class that implements tha default behavior.
 */
public abstract class SnakeDefault implements Snake {

  @Getter
  @Setter
  private int currentDirection;

  @Getter
  private final List<Point> snakeBody = new ArrayList<>();
  @Getter
  @Setter
  private Point snakeHead;

  private final int initX;
  private final int initY;
  private final int size;
  private boolean isAlive = true;
  /**
   * The next fields I made are public for code beauty.
   * I know that sometimes it's bad, but it's really unused to make
   * getters and setters for directions and values from Json.
   */
  public static final int RIGHT = 0;
  public static final int LEFT = 1;
  public static final int UP = 2;
  public static final int DOWN = 3;
  public static int ROWS;
  public static int COLUMNS;
  public static int SQUARE_SIZE;

  /**
   * SnakeDefault constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param initX      x-coordinate for initialization
   * @param initY      y-coordinate for initialization
   * @param size       size of initialization
   */
  public SnakeDefault(int rows, int columns, int squareSize, int initX, int initY, int size) {
    ROWS = rows;
    COLUMNS = columns;
    SQUARE_SIZE = squareSize;
    this.initX = initX;
    this.initY = initY;
    this.size = size;
  }


  /**
   * Function that restarts the data of the Snake for initial.
   */
  public void restartSnake() {
    isAlive = true;
    snakeHead = null;
    snakeBody.clear();
  }

  /**
   * Function that returns the size of the Snake.
   *
   * @return size of the Snake
   */
  @Override
  public int getSnakeSize() {
    return snakeBody.size();
  }


  /**
   * Function that draws that Snake in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  @Override
  public void drawSnake(GraphicsContext gc) {
    gc.setFill(Color.web("4674E9"));
    gc.fillRoundRect(
        snakeHead.getPointX() * SQUARE_SIZE,
        snakeHead.getPointY() * SQUARE_SIZE,
        SQUARE_SIZE - 1, SQUARE_SIZE - 1,
        35, 35);
    gc.setFill(Color.web("FFFFFF"));
    for (int i = 1; i < snakeBody.size() - 1; i++) {
      gc.fillRoundRect(
          snakeBody.get(i).getPointX() * SQUARE_SIZE,
          snakeBody.get(i).getPointY() * SQUARE_SIZE,
          SQUARE_SIZE - 1, SQUARE_SIZE - 1,
          20, 20);
    }
    gc.setFill(Color.web("4674E9"));
    gc.fillRoundRect(
        snakeBody.get(snakeBody.size() - 1).getPointX() * SQUARE_SIZE,
        snakeBody.get(snakeBody.size() - 1).getPointY() * SQUARE_SIZE,
        SQUARE_SIZE - 1, SQUARE_SIZE - 1,
        35, 35);

  }

  /**
   * Function that initializes the Snake.
   */
  @Override
  public void snakeInit() {
    if (size <= 0) {
      throw new IllegalArgumentException("Check the initial size of the Snake!");
    }
    for (int i = 0; i < size; i++) {
      snakeBody.add(new Point(initX, initY));
    }
    snakeHead = snakeBody.get(0);
  }

  /**
   * Function that checks that correctness of the position of the Snake.
   */
  @Override
  public void checkPosition() {
    for (Point i : snakeBody) {
      if (i.getPointX() >= COLUMNS) {
        i.setPointX(0);
      }
      if (i.getPointX() < 0) {
        i.setPointX(COLUMNS - 1);
      }
      if (i.getPointY() >= ROWS) {
        i.setPointY(0);
      }
      if (i.getPointY() < 0) {
        i.setPointY(ROWS - 1);
      }
    }
  }

  /**
   * Function that moves the parts of the Snake.
   */
  @Override
  public void movingParts() {
    for (int i = snakeBody.size() - 1; i >= 1; i--) {
      snakeBody.get(i).setPointX(snakeBody.get(i - 1).getPointX());
      snakeBody.get(i).setPointY(snakeBody.get(i - 1).getPointY());
    }
  }

  /**
   * Function that sets the direction of the Snake (Right)
   * and change the position of the SnakeHead.
   */
  @Override
  public void moveRight() {
    currentDirection = 0;
    snakeHead.setPointX(snakeHead.getPointX() + 1);
  }

  /**
   * Function that sets the direction of the Snake (Left)
   * and change the position of the SnakeHead.
   */
  @Override
  public void moveLeft() {
    currentDirection = 1;
    snakeHead.setPointX(snakeHead.getPointX() - 1);
  }

  /**
   * Function that sets the direction of the Snake (Up)
   * and change the position of the SnakeHead.
   */
  @Override
  public void moveUp() {
    currentDirection = 2;
    snakeHead.setPointY(snakeHead.getPointY() - 1);
  }

  /**
   * Function that sets the direction of the Snake (Down)
   * and change the position of the SnakeHead.
   */

  @Override
  public void moveDown() {
    currentDirection = 3;
    snakeHead.setPointY(snakeHead.getPointY() + 1);
  }

  /**
   * Function that returns true if snakeHead is on food, false otherwise.
   *
   * @param food food that can be eaten.
   * @return true if snake eats the food, false otherwise
   */
  @Override
  public boolean eatFood(Food food) {
    if (snakeHead.getPointX() == food.getFoodX()
        && snakeHead.getPointY() == food.getFoodY()) {
      snakeBody.add(new Point(-1, -1));
      return true;
    }
    return false;
  }

  /**
   * Function that sets if the snake is alive or not.
   *
   * @param isAlive true if snake is alive, false otherwise
   */
  @Override
  public void setIsAlive(boolean isAlive) {
    this.isAlive = isAlive;
  }

  /**
   * Function that checks if the snake is alive or not.
   *
   * @return true if snake is alive, false otherwise
   */
  @Override
  public boolean getIsAlive() {
    return isAlive;
  }

  /**
   * Function that draws the one Point of the Snake.
   *
   * @param gc    GraphicsContext for Canvas
   * @param image image need to be drawn.
   * @param index index of Point
   */
  @Override
  public void drawPoint(GraphicsContext gc, Image image, int index) {
    gc.drawImage(image, getSnakeBody().get(index).getPointX() * SQUARE_SIZE,
        getSnakeBody().get(index).getPointY() * SQUARE_SIZE,
        SQUARE_SIZE, SQUARE_SIZE);
  }


  /**
   * Function that counts next direction for snake.
   * moveDown() is default direction.
   *
   * @param unused unused
   */
  public void movingNext(Food unused) {
    moveDown();
  }
}
