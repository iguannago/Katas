plugins {
    java
    alias(libs.plugins.springboot)
}

apply(plugin = "io.spring.dependency-management")

group = "com.xdesign"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(libs.opencsv)

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations.all {
    exclude(group = "commons-logging", module = "commons-logging")
}

tasks.test {
    useJUnitPlatform()
}
