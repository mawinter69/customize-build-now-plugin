package org.jenkinsci.plugins.customizebuildnow;

import hudson.Extension;
import hudson.model.AbstractItem;
import hudson.model.AbstractProject;
import hudson.util.AlternativeUiTextProvider;

/**
 * This plugin allows users to provide an alternate label to "Build Now"
 * to build a job. Sometimes is more intuitive to users to say "Deploy now"
 * instead of "Build Now"
 *
 * Created by Udaypal Aarkoti (uaarkoti@gmail.com) on 12/19/14.
 */
@Extension
public class AlternateBuildNow extends AlternativeUiTextProvider {

    @Override
    public <T> String getText(Message<T> message, T t) {
        if (message== AbstractProject.BUILD_NOW_TEXT) {
            AbstractProject i = (AbstractProject) t;

            BuildNowTextProperty bt = (BuildNowTextProperty) i.getProperty(BuildNowTextProperty.class);
            if (bt != null) {
                return bt.getAlternateBuildNow();
            }
        }
        return null;
    }
}
