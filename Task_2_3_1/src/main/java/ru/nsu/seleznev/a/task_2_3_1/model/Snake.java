package ru.nsu.seleznev.a.task_2_3_1.model;


import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Snake interface the implements main methods of the all snakes.
 */
public interface Snake {
  int getSnakeSize();

  Point getSnakeHead();

  List<Point> getSnakeBody();

  void drawSnake(GraphicsContext gc);

  void checkPosition();

  void movingParts();

  void moveRight();

  void moveLeft();

  void moveUp();

  void moveDown();

  boolean eatFood(Food food);

  boolean getIsAlive();

  void setIsAlive(boolean isALive);

  void snakeInit();

  void drawPoint(GraphicsContext gc, Image image, int index);
}
