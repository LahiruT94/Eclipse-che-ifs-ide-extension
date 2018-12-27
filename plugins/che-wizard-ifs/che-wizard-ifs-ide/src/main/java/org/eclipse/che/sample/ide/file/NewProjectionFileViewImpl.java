package org.eclipse.che.sample.ide.file;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.eclipse.che.ide.ui.window.Window;
import org.eclipse.che.sample.ide.ProjectionWizardLocalizationConstant;

public class NewProjectionFileViewImpl extends Window implements NewProjectionFileView {
  final Button btnOk;
  @UiField TextBox nameField;
  // @UiField TextBox headerField;
  private NewProjectionFileView.ActionDelegate delegate;

  @Inject
  public NewProjectionFileViewImpl(
      NewProjectionFileViewImpl.NewJavaSourceFileViewImplUiBinder uiBinder,
      ProjectionWizardLocalizationConstant constant) {
    setTitle(constant.title());

    addFooterButton(constant.buttonCancel(), "dialog-cancel", event -> delegate.onCancelClicked());
    btnOk = addFooterButton(constant.buttonOk(), "dialog-ok", event -> delegate.onOkClicked());

    Widget widget = uiBinder.createAndBindUi(this);
    this.setWidget(widget);
  }

  @Override
  public String getName() {
    return nameField.getText();
  }

  /*@Override
  public String getHeader() {
    return headerField.getText();
  }*/

  @Override
  public void close() {
    hide();
  }

  @Override
  public void showDialog() {
    show(nameField);
  }

  @Override
  protected void onShow() {
    nameField.setText("");
    // headerField.setText("");
  }

  @Override
  public void setDelegate(NewProjectionFileView.ActionDelegate delegate) {
    this.delegate = delegate;
  }

  interface NewJavaSourceFileViewImplUiBinder extends UiBinder<Widget, NewProjectionFileViewImpl> {}
}
