This was a relatively straightforward multi-dimesional array problem. Part one describes a two-dimensional light array where each bulb can only be on and off.  This is easy enough to model as a two-dimesional boolean array.  Part two describes the same array, but each light can have a brightness between zero and infinity.  Given the limited input dataset, a two-dimensional integer array suffices to model this case.

The other trick was to process written instructions into something the code could interpret, but that was easy enough to do with some regular expressions to extract the ordered pairs and some basic string processing to determine the operation.

Gradle wrapper scripts are included, so running `./gradlew build` or `gradle.bat build` will build the source into `build/libs`.

Once you build the project, run the solution with `./run.sh` with the following arguments
- the input filepath
