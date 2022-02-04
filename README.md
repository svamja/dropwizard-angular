# Dropwizard Angular Demo

Continuation of ..

http://blog.perspilling.net/blog/2013/08/21/getting-started-with-angularjs-jetty-and-dropwizard

Original Git Repo - 

https://github.com/perspilling/angularjs-dropwizard-example


Instead of AngularJS code a separate Jetty package, this repo is serving AngularJS code
via resources/assets directory.

For that below line is added to main application's initialize method:

    bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));

And, `dropwizard-assets` is added as dependency in `pom.xml`.



## Run

    mvn clean install
    java -jar target/dropwizard-angular-1.0.jar

