My solution for Day 3's problem is a little more intense.  My implementation can spread the instruction set across an arbitrary number of workers (see Run.java).  Interestingly, the number of unique house vists drops for any more than two workers.

Gradle wrapper scripts are included, so running `./gradlew build` or `gradle.bat build` will build the source into `build/libs`

Once you build the project, run the solution with `./run.sh` with the following arguments
- path to the input file
