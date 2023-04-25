module ru.nsu.seleznev.a.SnakeGame {
  requires javafx.controls;
  requires javafx.fxml;
  requires static lombok;


  exports ru.nsu.seleznev.a.task_2_3_1.view;
  opens ru.nsu.seleznev.a.task_2_3_1.view to javafx.fxml;
  exports ru.nsu.seleznev.a.task_2_3_1.model;
  opens ru.nsu.seleznev.a.task_2_3_1.model to javafx.fxml;
  exports ru.nsu.seleznev.a.task_2_3_1.controller;
  opens ru.nsu.seleznev.a.task_2_3_1.controller to javafx.fxml;
  exports ru.nsu.seleznev.a.task_2_3_1;
  opens ru.nsu.seleznev.a.task_2_3_1 to javafx.fxml;
}