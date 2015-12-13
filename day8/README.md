This problem was solved in a straightforward manner using pattern matching against regular expressions, but it was made difficult in that the nature of the problem made it impossible to write proper unit tests.  I could see the solution needing to be tailored to the implementation language, as I had a few unexpected collisions with the way Java was handling parsing, storing, and outputting the input strings from the file.  Using the built-in debugger in Eclipse was enormously helpful!

Gradle wrapper scripts are included, so running `./gradlew build` or `gradle.bat build` will build the source into `build/libs`.

Once you build the project, run the solution with `./run.sh` with the following arguments
- the input filepath
