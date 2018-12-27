package org.eclipse.che.sample.ide.action;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.action.ProjectAction;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Project;
import org.eclipse.che.ide.api.selection.Selection;
import org.eclipse.che.ide.part.explorer.project.ProjectExplorerPresenter;
import org.eclipse.che.sample.ide.ProjectionWizardLocalizationConstant;
import org.eclipse.che.sample.ide.ProjectionWizardResources;
import org.eclipse.che.sample.ide.file.NewProjectionFilePresenter;

public class NewProjectionFileAction extends ProjectAction {
  private final AppContext appContext;
  private ProjectExplorerPresenter projectExplorer;
  private NewProjectionFilePresenter newProjectionFilePresenter;

  @Inject
  public NewProjectionFileAction(
      ProjectExplorerPresenter projectExplorer,
      NewProjectionFilePresenter newProjectionFilePresenter,
      ProjectionWizardLocalizationConstant constant,
      ProjectionWizardResources resources,
      AppContext appContext) {
    super(
        constant.newProjectionFile(),
        constant.createProjectionFileWithIncludedHeader(),
        resources.projectionFile());
    this.newProjectionFilePresenter = newProjectionFilePresenter;
    this.projectExplorer = projectExplorer;
    this.appContext = appContext;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    newProjectionFilePresenter.showDialog();
  }

  @Override
  public void updateProjectAction(ActionEvent e) {
    final Optional<Project> relatedProject = appContext.getResource().getRelatedProject();
    if (!relatedProject.isPresent()) {
      e.getPresentation().setEnabledAndVisible(false);
      return;
    }

    Selection<?> selection = projectExplorer.getSelection();
    if (selection == null) {
      e.getPresentation().setEnabledAndVisible(false);
      return;
    }

    e.getPresentation().setVisible(true);
    e.getPresentation().setEnabled(true);
  }
}
