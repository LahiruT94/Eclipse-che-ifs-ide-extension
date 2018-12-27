package org.eclipse.che.sample.generator;

import static org.eclipse.che.api.fs.server.WsPathUtils.resolve;
import static org.eclipse.che.sample.shared.Constants.RANDDCORE_PROJECT_TYPE_ID;

import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.eclipse.che.api.core.ConflictException;
import org.eclipse.che.api.core.NotFoundException;
import org.eclipse.che.api.core.ServerException;
import org.eclipse.che.api.fs.server.FsManager;
import org.eclipse.che.api.fs.server.WsPathUtils;
import org.eclipse.che.api.project.server.handlers.CreateProjectHandler;
import org.eclipse.che.api.project.server.type.AttributeValue;

public class ProjectionProjectHandler implements CreateProjectHandler {

  @Inject private FsManager fsManager;

  private static final String FILE_NAME = "package.json";

  @Override
  public void onCreateProject(
      String projectPath, Map<String, AttributeValue> attributes, Map<String, String> options)
      throws ConflictException, ServerException {

    try (InputStream packageJson =
            getClass().getClassLoader().getResourceAsStream("files/default_package");
        InputStream personJson =
            getClass().getClassLoader().getResourceAsStream("files/default_person")) {
      String projectWsPath = WsPathUtils.absolutize(projectPath);

      String myComponentFilesWsPath = resolve(projectWsPath, "Components");
      String myTestFilesWsPath = resolve(projectWsPath, "Database Benchmarking test of UXX");
      String myFavouriteFilesWsPath = resolve(projectWsPath, "Favourites");
      String myBuildHomeFilesWsPath = resolve(projectWsPath, "Build Home");
      String myComponent = resolve(myComponentFilesWsPath, "test_component");
      String entities = resolve(myComponentFilesWsPath, "Entities");
      String utilities = resolve(myComponentFilesWsPath, "Utilities");
      String enumerations = resolve(myComponentFilesWsPath, "Enumerations");
      String middleTier = resolve(myComponentFilesWsPath, "Middle-Tier");
      String bi = resolve(myComponentFilesWsPath, "BI");
      String reports = resolve(myComponentFilesWsPath, "Reports");
      String client = resolve(myComponentFilesWsPath, "Client");
      String fragments = resolve(client, "Fragments");
      fsManager.createDir(myTestFilesWsPath);
      fsManager.createDir(myFavouriteFilesWsPath);
      fsManager.createDir(myComponent);
      fsManager.createDir(entities);
      fsManager.createDir(utilities);
      fsManager.createDir(enumerations);
      fsManager.createDir(middleTier);
      fsManager.createDir(bi);
      fsManager.createDir(reports);
      fsManager.createDir(fragments);
      fsManager.createDir(myBuildHomeFilesWsPath);
    } catch (IOException | NotFoundException e) {
      throw new ServerException(e.getLocalizedMessage(), e);
    }
  }

  @Override
  public String getProjectType() {
    return RANDDCORE_PROJECT_TYPE_ID;
  }
}
