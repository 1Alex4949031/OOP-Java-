package ru.nsu.seleznev.a.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * EnemySnakeEater class that implements snake,
 * that tries to eat food in the field.
 */
public class EnemySnakeEater extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeEater/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeEater/snakeTail.png")));
  private final Image headRight = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeEater/snakeHeadRight.png")));
  private final Image headLeft = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeEater/snakeHeadLeft.png")));
  private final Image headUp = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeEater/snakeHeadUp.png")));
  private final Image headDown = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeEater/snakeHeadDown.png")));
  private List<Integer> directions = new ArrayList<>();

  /**
   * Enemy Snake Eater constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param x          x-coordinate for initialization
   * @param y          y-coordinate for initialization
   * @param size       initial size of the snake
   */
  public EnemySnakeEater(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that counts next direction for snake.
   * Experiment with Random().
   *
   * @param food food to eat
   */
  @Override
  public void movingNext(Food food) {
    int xFood = food.getX();
    int yFood = food.getY();
    directions = allowedDirections();
    if (yFood - getSnakeHead().getY() > 0 && directions.contains(DOWN)) {
      moveDown();
      return;
    } else if (yFood - getSnakeHead().getY() == 0) {
      if (xFood - getSnakeHead().getX() > 0 && directions.contains(RIGHT)) {
        moveRight();
        return;
      } else if (directions.contains(LEFT)) {
        moveLeft();
        return;
      }
    } else if (directions.contains(UP)) {
      moveUp();
      return;
    }

    if (directions.isEmpty()) {
      setIsAlive(false);
    } else {
      Random rand = new Random();
      int random = rand.nextInt(directions.size());
      switch (directions.get(random)) {
        case RIGHT -> moveRight();
        case LEFT -> moveLeft();
        case UP -> moveUp();
        case DOWN -> moveDown();
      }
    }
  }


  /**
   * Function that counts the allowed directions for the snake.
   *
   * @return List of allowed directions
   */
  private List<Integer> allowedDirections() {
    List<Integer> directions = new ArrayList<>();
    if (getSnakeBody().stream().noneMatch(i -> (i != getSnakeHead())
        && ((getSnakeHead().getX() + 1) % COLUMNS == i.getX())
        && getSnakeHead().getY() == i.getY())) directions.add(RIGHT);
    if (getSnakeBody().stream().noneMatch(i -> (i != getSnakeHead())
        && ((getSnakeHead().getX() - 1) % COLUMNS == i.getX())
        && getSnakeHead().getY() == i.getY())) directions.add(LEFT);
    if (getSnakeBody().stream().noneMatch(i -> (i != getSnakeHead())
        && ((getSnakeHead().getY() - 1) % ROWS == i.getY())
        && getSnakeHead().getX() == i.getX())) directions.add(UP);
    if (getSnakeBody().stream().noneMatch(i -> (i != getSnakeHead())
        && ((getSnakeHead().getY() + 1) % ROWS == i.getY())
        && getSnakeHead().getX() == i.getX())) directions.add(DOWN);
    return directions;
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
