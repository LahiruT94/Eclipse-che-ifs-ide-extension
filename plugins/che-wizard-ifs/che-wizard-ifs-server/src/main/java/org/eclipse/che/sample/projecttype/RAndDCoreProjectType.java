package org.eclipse.che.sample.projecttype;

import static org.eclipse.che.sample.shared.Constants.*;

import com.google.inject.Inject;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;

public class RAndDCoreProjectType extends ProjectTypeDef {
  @Inject
  public RAndDCoreProjectType() {
    super(RANDDCORE_PROJECT_TYPE_ID, "IFS R&D Core Project", true, false, true);
    addConstantDefinition(LANGUAGE, "language", PROJECTION_LANG);
  }
}
