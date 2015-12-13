This problem was solved by modeling the circuit as a map of wire names to their wiring instructions. The output values for a given wire can be calculated by recursively calculating the output of each wire in its instruction. The use of an internal wire-to-output-value cache speeds up this calculation tremendously. 

Gradle wrapper scripts are included, so running `./gradlew build` or `gradle.bat build` will build the source into `build/libs`.

Once you build the project, run the solution with `./run.sh` with the following arguments
- the input filepath
