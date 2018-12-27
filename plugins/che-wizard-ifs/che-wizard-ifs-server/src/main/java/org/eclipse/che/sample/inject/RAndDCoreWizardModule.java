package org.eclipse.che.sample.inject;

import static com.google.inject.multibindings.Multibinder.newSetBinder;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.eclipse.che.api.project.server.handlers.ProjectHandler;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;
import org.eclipse.che.sample.generator.ProjectionProjectHandler;
import org.eclipse.che.sample.projecttype.RAndDCoreProjectType;

@DynaModule
public class RAndDCoreWizardModule extends AbstractModule {
  @Override
  protected void configure() {
    Multibinder<ProjectTypeDef> projectTypeMultibinder =
        newSetBinder(binder(), ProjectTypeDef.class);
    projectTypeMultibinder.addBinding().to(RAndDCoreProjectType.class);

    Multibinder<ProjectHandler> projectHandlerMultibinder =
        newSetBinder(binder(), ProjectHandler.class);
    projectHandlerMultibinder.addBinding().to(ProjectionProjectHandler.class);
  }
}
