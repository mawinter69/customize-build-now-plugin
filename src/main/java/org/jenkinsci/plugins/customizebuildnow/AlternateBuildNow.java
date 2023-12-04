package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.Util;
import hudson.model.Job;
import hudson.model.ParametersDefinitionProperty;
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
            Job<?,?> p = (Job<?, ?>) t;
            BuildNowTextProperty bt = p.getProperty(BuildNowTextProperty.class);
            Labels labels = AlternateBuildLabelConfiguration.get().getLabels();
            if (bt != null) {
                labels = bt.getLabels();
            }
            if (labels != null) {
                return Util.fixEmptyAndTrim(labels.getAlternateBuildNow());
            }
        }
        if (message == ParameterizedJobMixIn.BUILD_WITH_PARAMETERS_TEXT) {
            Job<?,?> p = (Job<?, ?>) t;
            BuildNowTextProperty bt = p.getProperty(BuildNowTextProperty.class);
            Labels labels = AlternateBuildLabelConfiguration.get().getLabels();
            if (bt != null) {
                labels = bt.getLabels();
            }
            if (labels != null) {
                return Util.fixEmptyAndTrim(labels.getAlternateBuildWithParams());
            }
        }
        if (message == ParametersDefinitionProperty.BUILD_BUTTON_TEXT) {
            Job<?,?> p = (Job<?, ?>) t;
            BuildNowTextProperty bt = p.getProperty(BuildNowTextProperty.class);
            Labels labels = AlternateBuildLabelConfiguration.get().getLabels();
            if (bt != null) {
                labels = bt.getLabels();
            }
            if (labels != null) {
                return Util.fixEmptyAndTrim(labels.getAlternateBuildButton());
            }
        }
        return null;
    }
}
