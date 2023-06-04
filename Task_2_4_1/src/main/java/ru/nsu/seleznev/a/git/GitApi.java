package ru.nsu.seleznev.a.git;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.sql.Date;
import java.time.LocalDate;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.filter.CommitTimeRevFilter;
import ru.nsu.seleznev.a.DSL;
import ru.nsu.seleznev.a.parser.Parser;

public class GitApi {
  public void cloneRepository(String studentId) throws IOException {
    File file = new File("./DSL/config/ID" + studentId + ".groovy");
    if (!file.exists()) {
      throw new FileNotFoundException("No such student!");
    }
    DSL dslConfig = (DSL) Parser.parseConfiguration(file, DSL.class);
    File gitFolder = new File("./DSL/git/ID" + studentId);
    try {
      Git.cloneRepository()
          .setURI(String.valueOf(dslConfig.getStudent().getRepoURL()))
          .setDirectory(gitFolder)
          .call();
    } catch (GitAPIException e) {
      throw new RuntimeException("Something goes wrong with cloning repository!");
    }
    System.out.println("\nRepository was cloned successfully!\n");
  }

  public static void cloneRepositoryDsl(String studentName, URL studentUrl) throws FileAlreadyExistsException {
    File gitFolder = new File("./git/" + studentName);
    if (gitFolder.exists()) {
      throw new FileAlreadyExistsException("File is already exists!");
    }
    try {
      Git.cloneRepository()
          .setURI(String.valueOf(studentUrl))
          .setDirectory(gitFolder)
          .call();
    } catch (GitAPIException e) {
      throw new RuntimeException("Something goes wrong with cloning repository!");
    }
  }

  public static boolean checkCommitsInPeriod(File projectDir, LocalDate date) throws IOException, GitAPIException {
    try (Git git = Git.open(projectDir)) {
      var revFilter = CommitTimeRevFilter.between(Date.valueOf(date.minusWeeks(1)), Date.valueOf(date));
      var commits = git.log().setRevFilter(revFilter).call();
      return commits.iterator().hasNext();
    }
  }
}
