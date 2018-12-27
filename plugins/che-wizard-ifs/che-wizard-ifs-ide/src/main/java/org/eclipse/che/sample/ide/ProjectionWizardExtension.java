package org.eclipse.che.sample.ide;

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_FILE_NEW;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.constraints.Constraints;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.sample.ide.action.NewProjectionFileAction;

@Extension(title = "Projection Wizard")
public class ProjectionWizardExtension {

  public static String PROJECTION_CATEGORY = "IFS";

  @Inject
  public ProjectionWizardExtension(
      FileTypeRegistry fileTypeRegistry, @Named("ProjectionFileType") FileType projectionFile) {
    fileTypeRegistry.registerFileType(projectionFile);
  }

  @Inject
  private void prepareActions(
      NewProjectionFileAction newProjectionFileAction, ActionManager actionManager) {

    DefaultActionGroup newFileGroup = (DefaultActionGroup) actionManager.getAction(GROUP_FILE_NEW);

    actionManager.registerAction("newFileAction", newProjectionFileAction);
    newFileGroup.add(newProjectionFileAction, Constraints.FIRST);
  }
}
