package org.jenkinsci.plugins.customizebuildnow;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class Labels extends AbstractDescribableImpl<Labels> {

  private String alternateBuildNow;

  private String alternateBuildWithParams;

  private String alternateBuildButton;

  private String alternateBuildHistory;

  @DataBoundConstructor
  public Labels() {
  }

  public String getAlternateBuildHistory() {
    return alternateBuildHistory;
  }

  @DataBoundSetter
  public void setAlternateBuildHistory(String alternateBuildHistory) {
    this.alternateBuildHistory = alternateBuildHistory;
  }

  public String getAlternateBuildNow() {
    return alternateBuildNow;
  }

  @DataBoundSetter
  public void setAlternateBuildNow(String alternateBuildNow) {
    this.alternateBuildNow = alternateBuildNow;
  }

  public String getAlternateBuildWithParams() {
    return alternateBuildWithParams;
  }

  @DataBoundSetter
  public void setAlternateBuildWithParams(String alternateBuildWithParams) {
    this.alternateBuildWithParams = alternateBuildWithParams;
  }

  public String getAlternateBuildButton() {
    return alternateBuildButton;
  }

  @DataBoundSetter
  public void setAlternateBuildButton(String alternateBuildButton) {
    this.alternateBuildButton = alternateBuildButton;
  }

  @Extension
  public static class DescriptorImpl extends Descriptor<Labels> {

    @NonNull
    @Override
    public String getDisplayName() {
      return "";
    }
  }
}
