package com.example.person;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Persons Application
 */
public class PersonsApplication extends Application<PersonsConfig> {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            new PersonsApplication().run(new String[]{"server", "config.yml"});
        } else {
            new PersonsApplication().run(args);
        }
    }

    @Override
    public void initialize(Bootstrap<PersonsConfig> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    @Override
    public void run(PersonsConfig configuration,
                    Environment environment) 
    {

        final PersonService service = new PersonService();

        final PersonsResource resource = new PersonsResource(service);
        environment.jersey().register(resource);

    }
}

