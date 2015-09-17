package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.model.Job;
import hudson.util.AlternativeUiTextProvider;
import jenkins.model.ParameterizedJobMixIn;

/**
 * This plugin allows users to provide an alternate label to "Build Now"
 * to build a job. Sometimes is more intuitive to users to say "Deploy now"
 * instead of "Build Now"
 */
@Extension
public class AlternateBuildNow extends AlternativeUiTextProvider {

    @Override
    public <T> String getText(Message<T> message, T t) {
        if (message == ParameterizedJobMixIn.BUILD_NOW_TEXT) {
            Job<?,?> p = (Job) t;
            BuildNowTextProperty bt = p.getProperty(BuildNowTextProperty.class);
            if (bt != null) {
                return bt.getAlternateBuildNow();
            }
        }
        return null;
    }
}
