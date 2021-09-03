package com.demowebshop.configuration.filters;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureCustomFilter {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private AllureCustomFilter() {
    }

    public static AllureCustomFilter allureLogFilter() {
        return InitLogFilter.logFilter;
    }

    public AllureRestAssured withCustomTemplate() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }

    private static class InitLogFilter {
        private static final AllureCustomFilter logFilter = new AllureCustomFilter();
    }
}
