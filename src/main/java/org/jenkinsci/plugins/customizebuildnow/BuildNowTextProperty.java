package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.model.*;
import jenkins.model.ParameterizedJobMixIn;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Allow jobs to provide alternate label to "Build Now"
 */
public class BuildNowTextProperty extends JobProperty<Job<?, ?>> {
    public final String alternateBuildNow;

    @DataBoundConstructor
    public BuildNowTextProperty(boolean specified, String alternateBuildNow) {
        if (!specified) alternateBuildNow = null;
        this.alternateBuildNow = alternateBuildNow;
    }

    public String getAlternateBuildNow() {
        return alternateBuildNow;
    }

    public boolean isSpecified() { return alternateBuildNow!=null; }

    @Extension
    public static final class DescriptorImpl extends JobPropertyDescriptor {

        public DescriptorImpl() {
            super(BuildNowTextProperty.class);
        }

        public boolean isApplicable(Class<? extends Job> jobType) {
            return ParameterizedJobMixIn.ParameterizedJob.class.isAssignableFrom(jobType);
        }

        public String getDisplayName() {
            return "Provide alternate text for 'Build Now'";
        }
    }
}
