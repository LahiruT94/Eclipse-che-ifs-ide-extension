package org.eclipse.che.sample.ide.file;

import org.eclipse.che.ide.api.mvp.View;

public interface NewProjectionFileView extends View<NewProjectionFileView.ActionDelegate> {

  String getName();

  // String getHeader();

  /** Show dialog. */
  void showDialog();

  /** Close dialog. */
  void close();

  interface ActionDelegate {
    /** Performs any actions appropriate in response to the user having pressed the Ok button. */
    void onOkClicked();

    /**
     * Performs any actions appropriate in response to the user having pressed the Cancel button.
     */
    void onCancelClicked();
  }
}
