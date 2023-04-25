package ru.nsu.seleznev.a.task_2_3_1.model;

import javafx.scene.image.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Food class that implements the food in the field.
 */
@NoArgsConstructor
public class Food {
  @Getter
  @Setter
  private int x;
  @Getter
  @Setter
  private int y;
  @Getter
  @Setter
  private Image foodImage;
  private final String[] foods = new String[]{
      "/images/apple.png",
      "/images/berry.png",
      "/images/mango.png",
      "/images/pear.png",
  };

  /**
   * Function that returns the random String path to the food image (from foods).
   *
   * @return String path to the food
   */
  public String getRandomFood() {
    return foods[(int) (Math.random() * foods.length)];
  }
}
