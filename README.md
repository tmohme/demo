# Steps to reproduce the problem

1. run `./gradlew dockerBuild`
2. run 'docker run demo:latest' => should work
3. run `./gradlew dockerBuildNative`
4. run 'docker run demo:latest' => fails with `org.hibernate.AnnotationException: No identifier specified for entity: com.example.DemoClass`
