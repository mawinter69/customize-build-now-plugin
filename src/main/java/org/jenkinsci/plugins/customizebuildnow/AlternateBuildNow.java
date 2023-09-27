package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.Util;
import hudson.model.Descriptor;
import hudson.model.Job;
import hudson.model.ParametersDefinitionProperty;
import hudson.util.AlternativeUiTextProvider;
import jenkins.model.Jenkins;
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
            String linkText = null;
            if (bt != null) {
                linkText = Util.fixEmptyAndTrim(bt.getAlternateBuildNow());
            }
            if (linkText == null) {
                linkText = Util.fixEmptyAndTrim(AlternateBuildLabelConfiguration.get().getAlternateBuildNow());
            }
            return linkText;
        }
        if (message == ParameterizedJobMixIn.BUILD_WITH_PARAMETERS_TEXT) {
            Job<?,?> p = (Job) t;
            BuildNowTextProperty bt = p.getProperty(BuildNowTextProperty.class);
            String linkText = null;
            if (bt != null) {
                linkText = Util.fixEmptyAndTrim(bt.getAlternateBuildWithParams());
            }
            if (linkText == null) {
                linkText = Util.fixEmptyAndTrim(AlternateBuildLabelConfiguration.get().getAlternateBuildWithParams());
            }
            return linkText;
        }
        if (message == ParametersDefinitionProperty.BUILD_BUTTON_TEXT) {
            Job<?,?> p = (Job) t;
            BuildNowTextProperty bt = p.getProperty(BuildNowTextProperty.class);
            String buttonText = null;
            if (bt != null) {
                buttonText = Util.fixEmptyAndTrim(bt.getAlternateBuildButton());
            }
            if (buttonText == null) {
                buttonText =  Util.fixEmptyAndTrim(AlternateBuildLabelConfiguration.get().getAlternateBuildButton());
            }
            return buttonText;
        }
        return null;
    }
}
