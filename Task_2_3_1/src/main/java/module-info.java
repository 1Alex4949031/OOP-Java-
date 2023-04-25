module ru.nsu.seleznev.a {
  requires javafx.controls;
  requires javafx.fxml;
  requires static lombok;
  requires com.google.gson;

  opens ru.nsu.seleznev.a.jsonreader to com.google.gson;
  exports ru.nsu.seleznev.a.view;
  opens ru.nsu.seleznev.a.view to javafx.fxml;
  exports ru.nsu.seleznev.a.model;
  opens ru.nsu.seleznev.a.model to javafx.fxml;
  exports ru.nsu.seleznev.a.controller;
  opens ru.nsu.seleznev.a.controller to javafx.fxml;
  exports ru.nsu.seleznev.a;
  opens ru.nsu.seleznev.a to javafx.fxml;
}