# Pairing exercise

You will be implementing a movie service where the data set is contained in a large static file that in production would
be modified on disk each time a new movie is released.

The movie data is contained in the `movies.json` resource, and each movie contains a title and a set of genres (and
potentially some other data too!):

```json
[
  {
    "title": "Avengers: Age of Ultron",
    "genres": [
      "Action"
    ]
  },
  {
    "title": "The Avengers",
    "genres": [
      "Superhero"
    ]
  },
  // ...
]
```

Note that there may be duplicates in the data set, and there is no guarantee that all fields will be set to non-null
values.

You will be implementing the `MovieDatabase` interface.  The interface itself documents the expected return values and
behaviours for each of its methods - starting with the `findByTitle(name)` method, and progressing through the methods
in the interface.  As this is a large project, you may find that you do not have time to finish all of the methods.

###Setup
Run the following command from the `exercise` folder of this project to download the Maven Wrapper.

`mvn -N io.takari:maven:wrapper -Dmaven=3.3.9`

This should generate 2 files in the root directory (_mvnw_ and _mvnw.cmd_), and _.mvn_ directory with the Maven Wrapper Java Library and properties file.   