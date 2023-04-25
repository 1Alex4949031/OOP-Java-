package ru.nsu.seleznev.a;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.nsu.seleznev.a.controller.MenuController;
import ru.nsu.seleznev.a.controller.RestartController;
import ru.nsu.seleznev.a.jsonreader.GsonParser;
import ru.nsu.seleznev.a.jsonreader.JsonValues;
import ru.nsu.seleznev.a.model.EnemySnakeEater;
import ru.nsu.seleznev.a.model.EnemySnakeRandom;
import ru.nsu.seleznev.a.model.EnemySnakeStraightDown;
import ru.nsu.seleznev.a.model.EnemySnakeStraightLeft;
import ru.nsu.seleznev.a.model.EnemySnakeStraightRight;
import ru.nsu.seleznev.a.model.EnemySnakeStraightUp;
import ru.nsu.seleznev.a.model.Food;
import ru.nsu.seleznev.a.model.PlayerSnake;
import ru.nsu.seleznev.a.model.Point;
import ru.nsu.seleznev.a.model.SnakeDefault;
import ru.nsu.seleznev.a.view.Background;
import ru.nsu.seleznev.a.view.GameStage;
import ru.nsu.seleznev.a.view.Score;

/**
 * SnakeGame class that implements the SnakeGame.
 * Main class of the game.
 */
public class SnakeGame extends Application {
  private static int ROWS;
  private static int COLUMNS;
  private static int SQUARE_SIZE;
  private final PlayerSnake snake = new PlayerSnake(ROWS, COLUMNS, SQUARE_SIZE, 5, 5, 3);
  private Background bg;
  private Stage gameOverStage;
  private final List<SnakeDefault> enemySnakes = new ArrayList<>();
  private final Score score = new Score();
  private GameStage game;
  private final Timeline timeline = new Timeline(
      new KeyFrame(Duration.millis(70), event -> run(game.getGc())));
  private final Food food = new Food();
  private RestartController restartController;

  /**
   * Function that starts the application and initializes all the necessary parts of application.
   *
   * @param primaryStage the primary stage for this application, onto which
   *                     the application scene can be set.
   *                     Applications may create other stages, if needed, but they will not be
   *                     primary stages.
   * @throws Exception exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    GsonParser gson = new GsonParser();
    JsonValues values = gson.parse();
    ROWS = values.getRows();
    COLUMNS = values.getColumns();
    int width = values.getWidth();
    int height = values.getHeight();
    SQUARE_SIZE = width / ROWS;
    game = new GameStage(primaryStage, score, snake, width, height);
    // RestartScene
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RestartScene.fxml"));
    restartController = new RestartController(this, timeline);
    loader.setController(restartController);
    gameOverStage = loader.load();
    // Menu
    FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/Menu.fxml"));
    MenuController menuController = new MenuController();
    menuController.setPrimaryStage(primaryStage);
    menuController.setTimeline(timeline);
    loaderMenu.setController(menuController);
    Stage menuStage = loaderMenu.load();
    menuStage.show();
    bg = new Background(ROWS, COLUMNS, SQUARE_SIZE);
    timeline.setCycleCount(Animation.INDEFINITE);
    addEnemySnakes();
    initialState();
  }

  /**
   * Function that dumps current state of the Game.
   */
  public void initialState() {
    score.restartScore();
    snake.restartSnake();
    enemySnakes.forEach(SnakeDefault::restartSnake);
    enemySnakes.forEach(SnakeDefault::snakeInit);
    snake.snakeInit();
    snake.moveRight();
    generateFood();
    bg.drawBackground(game.getGc());
    enemySnakes.forEach(i -> {
      if (i.getIsAlive()) {
        i.drawSnake(game.getGc());
      }
    });
    snake.drawSnake(game.getGc());
    drawFood(game.getGc());
  }

  /**
   * Function that implements the main cycle of the Game.
   *
   * @param gc GraphicsContext for Canvas
   */
  private void run(GraphicsContext gc) {
    if (!snake.getIsAlive()) {
      restartController.setScoreSection("Score: " + score.getScore());
      gameOverStage.show();
      timeline.stop();
      return;
    }
    bg.drawBackground(gc);
    enemySnakes.forEach(sn -> {
      if (sn.getIsAlive()) {
        sn.drawSnake(gc);
      }
    });
    snake.drawSnake(gc);
    drawFood(gc);
    checkGameOver();
    checkIntersectionWithPlayer();
    checkIntersectionBetweenEnemies();
    enemySnakesCycle();
    playerSnakeCycle();
    if (snake.eatFood(food)) {
      score.plusOneToScore();
      generateFood();
    }
    enemySnakes.forEach(sn -> {
      if (sn.eatFood(food) && sn.getIsAlive()) {
        generateFood();
      }
    });
  }

  /**
   * PlayerSnake one tick cycle.
   */
  private void playerSnakeCycle() {
    snake.movingParts();
    snake.movingNext();
    snake.checkPosition();
    checkCollision();
  }

  /**
   * Enemies snakes one tick cycles.
   */
  private void enemySnakesCycle() {
    enemySnakes.forEach(sn -> {
      if (sn.getIsAlive()) {
        sn.movingParts();
        sn.movingNext(food);
        sn.checkPosition();
      }
    });
  }


  /**
   * Functions that checks the GameOver state.
   */
  private void checkGameOver() {
    enemySnakes.forEach(sn -> {
      if (sn.getIsAlive() && sn.getSnakeBody().stream().anyMatch(
          point -> point.getPointY() == snake.getSnakeHead().getPointY()
              && point.getPointX() == snake.getSnakeHead().getPointX())) {
        snake.setIsAlive(false);
      }
    });
  }

  /**
   * Function that checks the intersection between enemies.
   */
  private void checkIntersectionBetweenEnemies() {
    enemySnakes.forEach(sni -> enemySnakes.forEach(snj -> {
      if (sni != snj && sni.getIsAlive() && snj.getIsAlive()) {
        if (sni.getSnakeHead().getPointY() == snj.getSnakeHead().getPointY()
            && sni.getSnakeHead().getPointX() == snj.getSnakeHead().getPointX()) {
          sni.setIsAlive(false);
          snj.setIsAlive(false);
        }
        if (sni.getSnakeBody().stream().anyMatch(i -> i != sni.getSnakeHead()
            && i.getPointY() == snj.getSnakeHead().getPointY()
            && i.getPointX() == snj.getSnakeHead().getPointX())) {
          snj.setIsAlive(false);
        }
      }
    }));
  }

  /**
   * Function that checks the intersection between enemies and Player's Snake.
   */
  private void checkIntersectionWithPlayer() {
    enemySnakes.forEach(sn -> {
      if (sn.getIsAlive() && snake.getSnakeBody().stream().anyMatch(i -> i != snake.getSnakeHead()
          && i.getPointY() == sn.getSnakeHead().getPointY()
          && i.getPointX() == sn.getSnakeHead().getPointX())) {
        sn.setIsAlive(false);
      }
    });
  }

  /**
   * Function that checks the intersection between that parts of the Player's Snake.
   */
  private void checkCollision() {
    if (snake.getSnakeBody().stream().anyMatch(i -> i != snake.getSnakeHead()
        && snake.getSnakeHead().getPointX() == i.getPointX()
        && snake.getSnakeHead().getPointY() == i.getPointY())) {
      snake.setIsAlive(false);
    }
  }

  /**
   * Function that generates the food in the field.
   */
  private void generateFood() {
    int randomX = 0;
    int randomY = 0;
    int count = 0;
    int totalSnakesSize = getTotalSnakesSizes();
    while (count != snake.getSnakeSize() + totalSnakesSize) {
      count = 0;
      randomX = (int) (Math.random() * COLUMNS);
      randomY = (int) (Math.random() * ROWS);
      for (Point i : snake.getSnakeBody()) {
        if (i.getPointY() == randomY && i.getPointX() == randomX) {
          break;
        } else {
          count += 1;
        }
      }
      for (var sn : enemySnakes) {
        if (sn.getIsAlive()) {
          for (Point i : sn.getSnakeBody()) {
            if (i.getPointY() == randomY && i.getPointX() == randomX) {
              break;
            } else {
              count += 1;
            }
          }
        } else {
          count += sn.getSnakeSize();
        }
      }
    }

    Image image = new Image(Objects.requireNonNull(
        getClass().getResourceAsStream(food.getRandomFood())));
    food.setFoodImage(image);
    food.setFoodX(randomX);
    food.setFoodY(randomY);
  }

  /**
   * Function that draws the food in the field.
   *
   * @param gc GraphicsContext for Canvas
   */
  private void drawFood(GraphicsContext gc) {
    gc.drawImage(food.getFoodImage(), food.getFoodX() * SQUARE_SIZE,
        food.getFoodY() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
  }

  /**
   * Function that adds enemies in the Game.
   */
  private void addEnemySnakes() {
    enemySnakes.add(new EnemySnakeEater(ROWS, COLUMNS, SQUARE_SIZE, 25, 25, 3));
    enemySnakes.add(new EnemySnakeRandom(ROWS, COLUMNS, SQUARE_SIZE, 31, 31, 3));
    enemySnakes.add(new EnemySnakeStraightLeft(ROWS, COLUMNS, SQUARE_SIZE, 10, 0, 10));
    enemySnakes.add(new EnemySnakeStraightLeft(ROWS, COLUMNS, SQUARE_SIZE, 39, 39, 6));
    enemySnakes.add(new EnemySnakeStraightLeft(ROWS, COLUMNS, SQUARE_SIZE, 5, 10, 12));
    enemySnakes.add(new EnemySnakeStraightRight(ROWS, COLUMNS, SQUARE_SIZE, 15, 21, 5));
    enemySnakes.add(new EnemySnakeStraightRight(ROWS, COLUMNS, SQUARE_SIZE, 39, 5, 10));
    enemySnakes.add(new EnemySnakeStraightUp(ROWS, COLUMNS, SQUARE_SIZE, 27, 4, 4));
    enemySnakes.add(new EnemySnakeStraightUp(ROWS, COLUMNS, SQUARE_SIZE, 5, 25, 4));
    enemySnakes.add(new EnemySnakeStraightDown(ROWS, COLUMNS, SQUARE_SIZE, 17, 37, 4));
    enemySnakes.add(new EnemySnakeStraightDown(ROWS, COLUMNS, SQUARE_SIZE, 39, 18, 4));
  }

  /**
   * Function that counts total sun of all snakes parts in the field.
   *
   * @return total sum of all snake sizes.
   */
  private int getTotalSnakesSizes() {
    int totalSize = 0;
    for (var sn : enemySnakes) {
      totalSize += sn.getSnakeSize();
    }
    return totalSize;
  }

  /**
   * Function that launch() the application.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    launch();
  }
}
