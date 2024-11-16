package com.example.tools.qa;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
// @ConfigurationParameter(key = Constants.FILTER_NAME_PROPERTY_NAME, value =
// "@test")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "classpath:com.example.tools.qa.steps, classpath:com.example.tools.qa.hooks")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/reports/cucumber_report.html, json:target/reports/cucumber_report.json,junit:target/reports/cucumber_report.xml, rerun:target/rerun.txt, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class TestRunner {
}
