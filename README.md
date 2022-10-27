# Customizing ApplicationContext during SpringBoot Integration Tests

## Usage of Configuration

It is possible to define an inner class annotated with @Configuration within the integration test class, however, from 
now on, the application context bootstrapped when we run tests inside the test class will only include the beans that 
defined within this configuration class. Even context component scan won't work unless it is enabled by that configuration
class, therefore, none of those beans defined via stereotype annotations won't be available either.

## Usage of TestConfiguration

The normal way to override any beans specific to the integration test class is to create an inner configuration class with
@TestConfiguration annotation, which will have those bean definition overrides, or any specific configurations, special
to that test class. Defining such a configuration class won't block normal application context configuration, so any 
configuration classes and components will be automatically discovered and loaded when the test is run.

## Usage of TestComponent

@TestComponent annotation is a stereotype annotation which can be used to define beans that are only aimed for testing
purposes. Therefore, putting that annotation on top the class alone wouldn't work. Instead, you need to explicitly tell
Spring Test infra to load that bean class when the test is run. One way to load is make use of @Import on top of the 
inner configuration class in order to specify that bean class should be explicitly listed to be loaded during test run.

## Usage of Import