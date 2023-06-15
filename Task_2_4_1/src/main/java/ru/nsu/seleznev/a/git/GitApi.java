package ru.nsu.seleznev.a.git;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.filter.CommitTimeRevFilter;
import ru.nsu.seleznev.a.DSL;
import ru.nsu.seleznev.a.parser.Parser;

/**
 * GitApi class.
 */
public class GitApi {
  /**
   * Function that clones the repository.
   *
   * @param studentId student's id
   * @throws FileNotFoundException exception
   */
  public void cloneRepository(String studentId)
      throws FileNotFoundException {
    File file = new File("./DSL/config/ID" + studentId + ".groovy");
    if (!file.exists()) {
      throw new FileNotFoundException("No such student!");
    }
    DSL dslConfig = (DSL) Parser.parseConfiguration(file, DSL.class);
    File gitFolder = new File("./DSL/git/ID" + studentId);
    try (Git ignored = Git.cloneRepository()
        .setURI(String.valueOf(dslConfig.getStudent().getRepoUrl()))
        .setDirectory(gitFolder)
        .call()) {
      System.out.println("\nRepository was cloned successfully!\n");
    } catch (GitAPIException e) {
      throw new RuntimeException("Something goes wrong with cloning repository!");
    }
  }

  /**
   * Function that checks commits in fixed period.
   * Period: [date - 7 days, date].
   *
   * @param projectDir project directory
   * @param date date
   * @return true if commits were made in period, false otherwise
   * @throws GitAPIException git api exception
   */
  public static boolean checkCommitsInPeriod(File projectDir, LocalDate date)
      throws GitAPIException {
    try (Git git = Git.open(projectDir)) {
      var revFilter = CommitTimeRevFilter.between(
          Date.valueOf(date.minusWeeks(1)), Date.valueOf(date));
      var commits = git.log().setRevFilter(revFilter).call();
      return commits.iterator().hasNext();
    } catch (IOException e) {
      throw new RuntimeException("Git opening failed!");
    }
  }
}
