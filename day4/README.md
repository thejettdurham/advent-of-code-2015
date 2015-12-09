The solution for day 4 uses a little Java 8 magic to achieve speedy parallel calculations of MD5 hashes in user-definable batch sizes.  The Apache Commons Codec library is used for the actual MD5 hashing itself.

Gradle wrapper scripts are included, so running `./gradlew build` or `gradle.bat build` will build the source into `build/libs`.

Once you build the project, run the solution with `./run.sh` with the following arguments
- the input key
- the batch size (an integer)
- the prefix string to match the hash against (optional)
