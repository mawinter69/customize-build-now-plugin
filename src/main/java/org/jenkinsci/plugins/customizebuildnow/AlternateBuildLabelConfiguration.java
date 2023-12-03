package org.jenkinsci.plugins.customizebuildnow;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import jenkins.appearance.AppearanceCategory;
import jenkins.model.GlobalConfiguration;
import jenkins.model.GlobalConfigurationCategory;
import net.sf.json.JSONObject;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.StaplerRequest;

@Symbol("customizeBuildNow")
@Extension
public class AlternateBuildLabelConfiguration extends GlobalConfiguration {

  public AlternateBuildLabelConfiguration() {
    load();
  }

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

  @Override
  public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
    super.configure(req, json);
    save();
    return true;
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
