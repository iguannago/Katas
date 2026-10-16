val takeHomeGroup = "Take home"
val takeHomeProjectDir: String by project
val takeHomeProjectFiles: String by project
val takeHomePackageFileName: String by project

// The Gradle Sync task does not work as advertised (see https://github.com/gradle/gradle/issues/1349)
// Therefore, we must delete the .git folder created when the Git repo is initialized
val deleteGitRepo = tasks.register<Delete>("deleteGitRepo") {
    description = "Deletes any pre-existing Git repo."
    group = takeHomeGroup

    delete(layout.buildDirectory.dir("git-repo/.git"))
}

val syncProject = tasks.register<Sync>("syncProject") {
    description = "Syncs the required project files for the take home exercise."
    group = takeHomeGroup
    dependsOn(deleteGitRepo)

    from(takeHomeProjectDir) {
        include(takeHomeProjectFiles.split(","))
    }
    into(layout.buildDirectory.dir("git-repo"))
}

val initGitRepo = tasks.register<Exec>("initGitRepo") {
    description = "Initialises a new Git repository."
    group = takeHomeGroup
    dependsOn(syncProject)

    workingDir = syncProject.get().destinationDir
    commandLine("git", "init", "--initial-branch=main")
}

val addToGit = tasks.register<Exec>("addToGitIndex") {
    description = "Adds project files to the Git index."
    group = takeHomeGroup
    dependsOn(initGitRepo)

    workingDir = syncProject.get().destinationDir
    commandLine("git", "add", "--all")
}

val commitToGit = tasks.register<Exec>("commitToGit") {
    description = "Commits the project files to Git."
    group = takeHomeGroup
    dependsOn(addToGit)

    workingDir = syncProject.get().destinationDir
    commandLine("git", "commit", "--author=\"xDesign <>\"", "-m", "Initial commit")
}

tasks.register<Zip>("zipRepo") {
    description = "Packages the Git repository in a Zip archive."
    group = takeHomeGroup
    dependsOn(commitToGit)

    archiveFileName = takeHomePackageFileName
    destinationDirectory = layout.buildDirectory.dir("package")
    from(syncProject.get().destinationDir)
}

tasks.register<Delete>("clean") {
    description = "Deletes the build directory."
    group = takeHomeGroup

    delete(layout.buildDirectory)
}
