package org.eclipse.che.sample.ide;

import com.google.gwt.i18n.client.Messages;

public interface ProjectionWizardLocalizationConstant extends Messages {

  @Key("ok")
  @DefaultMessage("Ok")
  String buttonOk();

  @Key("cancel")
  @DefaultMessage("Cancel")
  String buttonCancel();

  @Key("title")
  @DefaultMessage("Enter file name and included header")
  String title();

  @Key("action.description")
  @DefaultMessage("Create new Projection file")
  String createProjectionFileWithIncludedHeader();

  @Key("action.title")
  @DefaultMessage("New Projection file")
  String newProjectionFile();
}
