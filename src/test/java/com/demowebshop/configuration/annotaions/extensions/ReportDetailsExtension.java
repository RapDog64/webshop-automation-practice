package com.demowebshop.configuration.annotaions.extensions;

import com.demowebshop.configuration.report.AttachmentManager;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class ReportDetailsExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (context.getExecutionException().isPresent()) {
            AttachmentManager.screenshotAs("Screenshot of the failed test");
            AttachmentManager.pageSource();
        }
    }
}
