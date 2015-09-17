package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.model.*;
import jenkins.model.ParameterizedJobMixIn;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Allow jobs to provide alternate label to "Build Now"
 */
public class BuildNowTextProperty extends JobProperty<Job<?, ?>> {
    public final String alternateBuildNow;

    @DataBoundConstructor
    public BuildNowTextProperty(String alternateBuildNow) {
        this.alternateBuildNow = alternateBuildNow;
    }

    public String getAlternateBuildNow() {
        return alternateBuildNow;
    }

    @Extension
    public static final class DescriptorImpl extends JobPropertyDescriptor {

        public DescriptorImpl() {
            super(BuildNowTextProperty.class);
        }

        @Override
        public JobProperty<?> newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            return formData.optBoolean("specified") ? super.newInstance(req, formData) : null;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return ParameterizedJobMixIn.ParameterizedJob.class.isAssignableFrom(jobType);
        }

        @Override
        public String getDisplayName() {
            return "Provide alternate text for 'Build Now'";
        }
    }
}
