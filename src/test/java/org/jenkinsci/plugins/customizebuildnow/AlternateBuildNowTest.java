package org.jenkinsci.plugins.customizebuildnow;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import hudson.model.FreeStyleProject;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test Build Now Label Change
 * Created by Udaypal Aarkoti (uaarkoti@gmail.com) on 12/19/14.
 */
public class AlternateBuildNowTest {
    @Rule
    public JenkinsRule rule = new JenkinsRule();

    @Test
    public void testBuildNowChange() throws Exception {
        FreeStyleProject p = rule.createFreeStyleProject();
        p.addProperty(new BuildNowTextProperty(true, "Deploy Now"));
        //rule.interactiveBreak();

        JenkinsRule.WebClient wc = rule.createWebClient();
        HtmlPage html = wc.getPage(p);
        assertNotNull(html.getAnchorByText("Deploy Now"));

        FreeStyleProject p2 = rule.configRoundtrip(p);

        BuildNowTextProperty textProperty = p2.getProperty(BuildNowTextProperty.class);
        assertEquals(textProperty.getAlternateBuildNow(), "Deploy Now");

    }

    @Test
    public void testBuildNowUnChanged() throws Exception {
        FreeStyleProject p = rule.createFreeStyleProject();
        p.addProperty(new BuildNowTextProperty(false, "Deploy Now"));
        //rule.interactiveBreak();

        JenkinsRule.WebClient wc = rule.createWebClient();
        HtmlPage html = wc.getPage(p);
        assertNotNull(html.getAnchorByText("Build Now"));
    }
}