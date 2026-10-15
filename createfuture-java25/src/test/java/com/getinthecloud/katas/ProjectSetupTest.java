package com.getinthecloud.katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectSetupTest {

    @Test
    void runsOnJava25OrLater() {
        assertTrue(Runtime.version().feature() >= 25, "Run Maven and its tests with JDK 25 or later");
    }
}
