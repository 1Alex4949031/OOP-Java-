package ru.nsu.seleznev.a.view;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Background class for the SnakeGame field.
 */
public class Background {
  private static int ROWS;
  private static int COLUMNS;
  private static int SQUARE_SIZE;

  /**
   * Background constructor.
   *
   * @param rows       ROWS
   * @param columns    COLUMNS
   * @param squareSize SQUARE SIZE
   */
  public Background(int rows, int columns, int squareSize) {
    ROWS = rows;
    COLUMNS = columns;
    SQUARE_SIZE = squareSize;
  }

  /**
   * Function that draws the Background for the SnakeGame field.
   *
   * @param gc GraphicsContext for Canvas.
   */
  public void drawBackground(GraphicsContext gc) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if ((i + j) % 2 == 0) {
          gc.setFill(Color.web("AAD751"));
        } else {
          gc.setFill(Color.web("A2D149"));
        }
        gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
      }
    }
  }
}
