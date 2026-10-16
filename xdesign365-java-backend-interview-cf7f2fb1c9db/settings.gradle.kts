dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            plugin("springboot", "org.springframework.boot").version("3.2.1")
            library("opencsv", "com.opencsv:opencsv:5.9")
        }
    }
}

rootProject.name = "nutrition-search"
