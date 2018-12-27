package org.eclipse.che.sample.ide.wizard;

import static org.eclipse.che.sample.shared.Constants.RANDDCORE_PROJECT_TYPE_ID;

import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.ide.api.wizard.WizardPage;
import org.eclipse.che.sample.ide.ProjectionWizardExtension;

public class RAndDCoreProjectWizardRegistrar implements ProjectWizardRegistrar {

  private final List<Provider<? extends WizardPage<MutableProjectConfig>>> wizardPages;

  @Inject
  public RAndDCoreProjectWizardRegistrar() {
    wizardPages = new ArrayList<>();
  }

  @NotNull
  public String getProjectTypeId() {
    return RANDDCORE_PROJECT_TYPE_ID;
  }

  @NotNull
  public String getCategory() {
    return ProjectionWizardExtension.PROJECTION_CATEGORY;
  }

  @NotNull
  public List<Provider<? extends WizardPage<MutableProjectConfig>>> getWizardPages() {
    return wizardPages;
  }
}
