package ru.nsu.seleznev.a.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * EnemySnakeRandom class that implements Random Snake behavior.
 */
public class EnemySnakeRandom extends SnakeDefault {
  private final Image body = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRandom/snakeBody.png")));
  private final Image tail = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRandom/snakeTail.png")));
  private final Image headRight = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRandom/snakeHeadRight.png")));
  private final Image headLeft = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRandom/snakeHeadLeft.png")));
  private final Image headUp = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRandom/snakeHeadUp.png")));
  private final Image headDown = new Image(Objects.requireNonNull(
      getClass().getResourceAsStream("/enemySnakeRandom/snakeHeadDown.png")));
  private List<Integer> directions = new ArrayList<>(Arrays.asList(0, 1, 2, 3));


  /**
   * EnemySnakeRandom constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   * @param x          x-coordinate for initialization
   * @param y          y-coordinate for initialization
   * @param size       initial size of the snake
   */
  public EnemySnakeRandom(int rows, int columns, int squareSize, int x, int y, int size) {
    super(rows, columns, squareSize, x, y, size);
  }

  /**
   * Function that counts next direction for Random snake behavior.
   *
   * @param unused unused
   */
  @Override
  public void movingNext(Food unused) {
    Random rand = new Random();
    if (directions.size() == 0) {
      setIsAlive(false);
      return;
    }
    int random = rand.nextInt(directions.size());
    switch (directions.get(random)) {
      case RIGHT -> moveRight();
      case LEFT -> moveLeft();
      case UP -> moveUp();
      case DOWN -> moveDown();
    }
    directions = allowedDirections();
  }

  /**
   * Function that returns the allowed directions for Snake.
   *
   * @return List of allowed directions
   */
  public List<Integer> allowedDirections() {
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
   * Function that draws the Snake in the field.
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
