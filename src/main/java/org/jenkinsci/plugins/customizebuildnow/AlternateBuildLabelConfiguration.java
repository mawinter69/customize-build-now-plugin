package org.jenkinsci.plugins.customizebuildnow;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import jenkins.appearance.AppearanceCategory;
import jenkins.model.GlobalConfiguration;
import jenkins.model.GlobalConfigurationCategory;

@org.jenkinsci.Symbol("customBuildNow")
@Extension
public class AlternateBuildLabelConfiguration extends GlobalConfiguration {

  private String alternateBuildNow;

  private String alternateBuildWithParams;

  private String alternateBuildButton;

  public String getAlternateBuildNow() {
    return alternateBuildNow;
  }

  public void setAlternateBuildNow(String alternateBuildNow) {
    this.alternateBuildNow = alternateBuildNow;
  }

  public String getAlternateBuildWithParams() {
    return alternateBuildWithParams;
  }

  public void setAlternateBuildWithParams(String alternateBuildWithParams) {
    this.alternateBuildWithParams = alternateBuildWithParams;
  }

  public String getAlternateBuildButton() {
    return alternateBuildButton;
  }

  public void setAlternateBuildButton(String alternateBuildButton) {
    this.alternateBuildButton = alternateBuildButton;
  }

  public static AlternateBuildLabelConfiguration get() {
    return GlobalConfiguration.all().get(AlternateBuildLabelConfiguration.class);
  }

  @NonNull
  @Override
  public GlobalConfigurationCategory getCategory() {
    return GlobalConfigurationCategory.get(AppearanceCategory.class);
  }
}
