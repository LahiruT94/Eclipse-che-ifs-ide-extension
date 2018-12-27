package org.eclipse.che.sample.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

public interface ProjectionWizardResources extends ClientBundle {
  ProjectionWizardResources INSTANCE = GWT.create(ProjectionWizardResources.class);

  @Source("svg/c_file.svg")
  SVGResource projectionFile();

  @Source("svg/category.svg")
  SVGResource category();
}
