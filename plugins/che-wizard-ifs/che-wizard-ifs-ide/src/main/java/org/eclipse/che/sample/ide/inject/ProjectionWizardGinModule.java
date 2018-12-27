/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.inject;

import static org.eclipse.che.sample.shared.Constants.PROJECTION_EXT;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.sample.ide.ProjectionWizardResources;
import org.eclipse.che.sample.ide.file.NewProjectionFileView;
import org.eclipse.che.sample.ide.file.NewProjectionFileViewImpl;
import org.eclipse.che.sample.ide.wizard.*;

/** @author Vitalii Parfonov */
@ExtensionGinModule
public class ProjectionWizardGinModule extends AbstractGinModule {

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    GinMultibinder.newSetBinder(binder(), ProjectWizardRegistrar.class)
        .addBinding()
        .to(RAndDCoreProjectWizardRegistrar.class);
    bind(NewProjectionFileView.class).to(NewProjectionFileViewImpl.class).in(Singleton.class);
  }

  @Provides
  @Singleton
  @Named("ProjectionFileType")
  protected FileType provideProjectionFile() {
    return new FileType(ProjectionWizardResources.INSTANCE.projectionFile(), PROJECTION_EXT);
  }
}
