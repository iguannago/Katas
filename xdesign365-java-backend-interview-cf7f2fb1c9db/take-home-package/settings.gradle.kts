import org.apache.tools.ant.DirectoryScanner

// Workaround Gradle default excludes
DirectoryScanner.removeDefaultExclude("**/.gitignore")
DirectoryScanner.removeDefaultExclude("**/.git")
DirectoryScanner.removeDefaultExclude("**/.git/**")

rootProject.name = "take-home-package"
