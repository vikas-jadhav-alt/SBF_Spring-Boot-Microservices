
#Note:
Before executing the project: make below change:

we have done this to as due long pathname-> indexing of git was not happening:

```
/test-autoconfiguration/src/main/resources/META-INF/spring/xyz.imports
```
to

```
/test-autoconfiguration/src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
```

#How to Test The App

Just right click and run as Spring Boot  App:

#Console Output
```
##### Starting Main Method

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.2.3)[0;39m

[2m2024-03-09T17:11:38.767+05:30[0;39m [32m INFO[0;39m [35m1316[0;39m [2m---[0;39m [2m[           main][0;39m [2m[0;39m[36mcom.example.demo.DemoApplication        [0;39m [2m:[0;39m Starting DemoApplication using Java 17.0.9 with PID 1316 (D:\JAVA FULL STACK NOTES\JAVA PROJECTs_ALL TYPES\JAVA TECHNOLOGIES AND FRAMEWORKS STS WORKSPACE\SBF_Spring-Boot-Microservices\SBF_CORE_CustomAutoConfigurationDemo\target\classes started by vikas in D:\JAVA FULL STACK NOTES\JAVA PROJECTs_ALL TYPES\JAVA TECHNOLOGIES AND FRAMEWORKS STS WORKSPACE\SBF_Spring-Boot-Microservices\SBF_CORE_CustomAutoConfigurationDemo)
[2m2024-03-09T17:11:38.773+05:30[0;39m [32m INFO[0;39m [35m1316[0;39m [2m---[0;39m [2m[           main][0;39m [2m[0;39m[36mcom.example.demo.DemoApplication        [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
.....Person Bean Getting Created
[2m2024-03-09T17:11:39.912+05:30[0;39m [32m INFO[0;39m [35m1316[0;39m [2m---[0;39m [2m[           main][0;39m [2m[0;39m[36mcom.example.demo.DemoApplication        [0;39m [2m:[0;39m Started DemoApplication in 2.033 seconds (process running for 3.708)
----> Welcome To CommandLineRunner <--------
1. Hello I am Person of Humankind
2. Good To See You Here
Bye !!!
##### Finishing Main Method

```


#PlayAround:

try to make the below property: true|false, in *application.properties*

```
enable.customAuto=true
```


