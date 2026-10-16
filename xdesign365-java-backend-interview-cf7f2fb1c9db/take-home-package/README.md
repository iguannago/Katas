# Take home interview packager

A standalone Gradle project which packages a project into a ZIP archive along with a local Git repository containing a
single commit.
The following Gradle properties control which files are included in the ZIP archive

| Property                |Description|
|:------------------------|-----------|
| `takeHomeProjectDir`    | The root directory of the project to package, containing the files to add to the ZIP archive |`../`|
| `takeHomeProjectFiles`  | A list of files and directories in the project root directory to include in the ZIP archive. The filenames should be specified as a single string, with commas separating each item. 
| `takeHomePackageFileName`| The name of the generated ZIP archive |

Default values for each property are defined in the `gradle.properties` file for this project. These can be overridden when calling 
Gradle.

To create the ZIP archive run the command:

```commandline
./gradlew zipRepo
```

This command performs the following tasks:

1. Syncs the files specified in `takeHomeProjectFiles` to the `build/git-repo` directory.
2. Initializes a new Git repository.
3. Commits all the files to the Git repository.
4. Packages the Git repository into a ZIP archive in the `build/package` directory.

If you run the command again, the original Git repository is discarded and a new one created in its place.
This allows us to easily maintain a Git repository with a single commit in its history. 

If you want to delete the `build` directory, simply run the `clean` command:

```commandline
./gradlew clean
```

## Note
If you encounter an error when running Gradle, similar to:

> Cannot change default excludes during the build. They were changed from [**/#*#, **/%*%, **/*~, **/.#*, **/.DS_Store, **/._*, **/.bzr, **/.bzr/**, **/.bzrignore, **/.cvsignore, **/.gitattributes, **/.gitmodules, **/.hg, **/.hg/**, **/.hgignore, **/.hgsub, **/.hgsubstate, **/.hgtags, **/.svn, **/.svn/**, **/CVS, **/CVS/**, **/SCCS, **/SCCS/**, **/vssver.scc] to [**/#*#, **/%*%, **/*~, **/.#*, **/.DS_Store, **/._*, **/.bzr, **/.bzr/**, **/.bzrignore, **/.cvsignore, **/.git, **/.git/**, **/.gitattributes, **/.gitignore, **/.gitmodules, **/.hg, **/.hg/**, **/.hgignore, **/.hgsub, **/.hgsubstate, **/.hgtags, **/.svn, **/.svn/**, **/CVS, **/CVS/**, **/SCCS, **/SCCS/**, **/vssver.scc]. Configure default excludes in the settings script instead.Cannot change default excludes during the build. They were changed from [**/#*#, **/%*%, **/*~, **/.#*, **/.DS_Store, **/._*, **/.bzr, **/.bzr/**, **/.bzrignore, **/.cvsignore, **/.gitattributes, **/.gitmodules, **/.hg, **/.hg/**, **/.hgignore, **/.hgsub, **/.hgsubstate, **/.hgtags, **/.svn, **/.svn/**, **/CVS, **/CVS/**, **/SCCS, **/SCCS/**, **/vssver.scc] to [**/#*#, **/%*%, **/*~, **/.#*, **/.DS_Store, **/._*, **/.bzr, **/.bzr/**, **/.bzrignore, **/.cvsignore, **/.git, **/.git/**, **/.gitattributes, **/.gitignore, **/.gitmodules, **/.hg, **/.hg/**, **/.hgignore, **/.hgsub, **/.hgsubstate, **/.hgtags, **/.svn, **/.svn/**, **/CVS, **/CVS/**, **/SCCS, **/SCCS/**, **/vssver.scc]. Configure default excludes in the settings script instead.

try stopping the Gradle daemon and running the command again:

```commandline
./gradlew --stop
```

Alternatively, don't use the Gradle daemon to run the build:

```commandline
./gradlew --no-daemon zipRepo
```
