package ru.nsu.seleznev.a.directories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.stream.Stream;

public class Directories {
  public static void copyDirectory(String sourceDirectory, String targetDirectory) throws IOException {
    Path sourcePath = Paths.get(sourceDirectory);
    Path targetPath = Paths.get(targetDirectory);

    Files.walkFileTree(sourcePath, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path targetDir = targetPath.resolve(sourcePath.relativize(dir));
        Files.createDirectories(targetDir);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.copy(file, targetPath.resolve(sourcePath.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
      }
    });
  }

  public static void deleteDirectory(String directoryPath) throws IOException {
    Path path = Paths.get(directoryPath);
    if (Files.exists(path)) {
      try (Stream<Path> pathStream = Files.walk(path)) {
        pathStream
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
      }
    }
  }

  public static void createDirectory(String directoryPath) throws IOException {
    Path path = Paths.get(directoryPath);
    Files.createDirectories(path);
  }

  public static void writeNewHtmlFile(String directoryPath, String table) throws IOException {
    Path path = Paths.get(directoryPath);
    try (FileWriter tableFile = new FileWriter(path + ".html")) {
      tableFile.write(table);
    }
  }
}
