package org.eclipse.che.sample.ide.file;

import static com.google.common.base.Preconditions.checkState;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Container;
import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.project.ProjectServiceClient;
import org.eclipse.che.ide.resource.Path;
import org.eclipse.che.sample.shared.Constants;

@Singleton
public class NewProjectionFilePresenter implements NewProjectionFileView.ActionDelegate {
  // private static final String DEFAULT_CONTENT = " #include <${header}>";

  private final NewProjectionFileView view;
  private final ProjectServiceClient projectServiceClient;
  private final AppContext appContext;

  @Inject
  public NewProjectionFilePresenter(
      NewProjectionFileView view,
      AppContext appContext,
      ProjectServiceClient projectServiceClient) {
    this.appContext = appContext;
    this.view = view;
    this.projectServiceClient = projectServiceClient;
    this.view.setDelegate(this);
  }

  public void showDialog() {
    view.showDialog();
  }

  @Override
  public void onCancelClicked() {
    view.close();
  }

  @Override
  public void onOkClicked() {
    final String fileName = view.getName();
    view.close();
    createClass(fileName);
  }

  private void createClass(String name) {
    // String content = DEFAULT_CONTENT.replace("${header}", view.getHeader());
    createSourceFile(name, null);
  }

  private void createSourceFile(final String nameWithoutExtension, final String content) {
    Resource resource = appContext.getResource();
    if (!(resource instanceof Container)) {
      final Container parent = resource.getParent();
      checkState(parent != null, "Parent should be a container");
      resource = parent;
    }
    createFile(resource.getLocation().toString(), nameWithoutExtension, content);
  }

  private void createFile(
      final String path, final String nameWithoutExtension, final String content) {
    projectServiceClient.createFile(
        Path.valueOf(path).append(nameWithoutExtension + '.' + Constants.PROJECTION_EXT), content);
  }
}
