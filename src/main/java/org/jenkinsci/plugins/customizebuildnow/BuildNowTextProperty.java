package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.model.*;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import java.util.logging.Logger;

/**
 * Allow jobs to provide alternate label to "Build Now"
 * Created by Udaypal Aarkoti (uaarkoti@gmail.com) on 12/19/14.
 */
public class BuildNowTextProperty extends JobProperty<AbstractProject<?, ?>> {
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
            return AbstractProject.class.isAssignableFrom(jobType);
        }

        public String getDisplayName() {
            return "Provide alternate text for 'Build Now'";
        }
    }
}
