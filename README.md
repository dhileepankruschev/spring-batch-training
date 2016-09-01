# springbatch

Running Spring batch using Command Line runner:

1. Mvn package

2. java -cp "target/dependency-jars/*:target/spring-batch.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner spring/batch/jobs/job-read-files.xml readMultiFileJob