package org.jenkinsci.plugins.customizebuildnow;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.*;
import jenkins.model.OptionalJobProperty;
import jenkins.model.ParameterizedJobMixIn;
import net.sf.json.JSONObject;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Allow jobs to provide alternate label to "Build Now"
 */
public class BuildNowTextProperty extends OptionalJobProperty<Job<?, ?>> {
    private final String alternateBuildNow;

    private String alternateBuildWithParams;

    private String alternateBuildButton;

    @DataBoundConstructor
    public BuildNowTextProperty(String alternateBuildNow) {
        this.alternateBuildNow = alternateBuildNow;
    }

    public String getAlternateBuildNow() {
        return alternateBuildNow;
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
    @Symbol("customizeBuildNow")
    public static final class DescriptorImpl extends OptionalJobPropertyDescriptor {


        public DescriptorImpl() {
            super(BuildNowTextProperty.class);
        }

        @Override
        public JobProperty<?> newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            return formData.optBoolean("specified") ? super.newInstance(req, formData) : null;
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return ParameterizedJobMixIn.ParameterizedJob.class.isAssignableFrom(jobType);
        }

        @Override
        @NonNull
        public String getDisplayName() {
            return "Provide alternate Labels for Build Links and Buttons";
        }
    }
}
