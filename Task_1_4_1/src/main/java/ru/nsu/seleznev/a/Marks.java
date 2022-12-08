package ru.nsu.seleznev.a;

/**
 * Enum implementation for correct mark values.
 */
public enum Marks {
  EXCELLENT("Отлично"),
  GOOD("Хорошо"),
  SATISFACTORY("Удовлетворительно"),
  BAD("Неудовлетворительно"),
  GOODCREDIT("Зачет"),
  BADCREDIT("Незачет");

  private final String value;

  /**
   * Constructor for marks enum.
   *
   * @param value value of the mark
   */
  Marks(String value) {
    this.value = value;
  }

  /**
   * Function that returns value of the mark.
   *
   * @return value of the mark
   */
  public String getMark() {
    return value;
  }
}
