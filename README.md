# Spring Core Examples

## Customizing ApplicationContext during SpringBoot Integration Tests

### Usage of Configuration

It is possible to define an inner class annotated with @Configuration within the integration test class, however, from 
now on, the application context bootstrapped when we run tests inside the test class will only include the beans that 
defined within this configuration class. Even context component scan won't work unless it is enabled by that configuration
class, therefore, none of those beans defined via stereotype annotations won't be available either.

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/BarTest.kt#L12-L17

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/FooTest.kt#L15-L22

### Usage of TestConfiguration

The normal way to override any beans specific to the integration test class is to create an inner configuration class with
@TestConfiguration annotation, which will have those bean definition overrides, or any specific configurations, special
to that test class. Defining such a configuration class won't block normal application context configuration, so any 
configuration classes and components will be automatically discovered and loaded when the test is run.

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/FooTest.kt#L23-L29

If your test configuration class annotated with @TestConfiguration is defined as a top level class, then it won't be 
included in the application context automatically. Instead, it must be added explicitly either via @Import on top of a
configuration class you just added specific for this test class, or via @ContextConfiguration annotation as a bean class.

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/config/BarConfig.kt#L7-L13

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/Bar3Test.kt#L15-L20

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/Bar2Test.kt#L14-L17

### Usage of Configuration & TestConfiguration in Base Test Classes

If the configuration class with @Configuration annotation is defined within the BaseTest class, it will be discovered when
test case within the SubTest class is run, but if there is an overriden bean definition within that configuration class
it won't take effect.

https://github.com/ksevindik/spring-core-examples/blob/c8aa999af9fbe83b508b25d26e421e544ef61b40/src/test/kotlin/com/example/springcore/test/BaseTest.kt#L9
https://github.com/ksevindik/spring-core-examples/blob/c8aa999af9fbe83b508b25d26e421e544ef61b40/src/test/kotlin/com/example/springcore/test/SubTest.kt#L9

For the bean definition override to work, you must create a config class within the SubTest, and
annotate both config classes either with @Configuration or @TestConfiguration. However, be aware of that if you annotate them
with @Configuration, then the above limitation will be in act. Therefore, it is better to go with the @TestConfiguration.
You need to import the config class within BaseTest if both SubTest and BaseTest config classes are marked with
@TestConfiguration.

https://github.com/ksevindik/spring-core-examples/blob/c8aa999af9fbe83b508b25d26e421e544ef61b40/src/test/kotlin/com/example/springcore/test/Base2Test.kt#L9
https://github.com/ksevindik/spring-core-examples/blob/c8aa999af9fbe83b508b25d26e421e544ef61b40/src/test/kotlin/com/example/springcore/test/Sub2Test.kt#L12

### Usage of TestComponent

@TestComponent annotation is a stereotype annotation which can be used to define beans that are only aimed for testing
purposes. Therefore, putting that annotation on top the class alone wouldn't work. Instead, you need to explicitly tell
Spring Test infra to load that bean class when the test is run.

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/model/Bat.kt#L5-L7

One way to load is make use of @Import on top of the inner configuration class in order to specify that bean class should 
be explicitly listed to be loaded during test run. The other way is to specify that bean class via @ContextConfiguration 
annotation on top of the test class.

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/Bar3Test.kt#L15-L20

https://github.com/ksevindik/spring-core-examples/blob/2bd0797b8055a5ff957dfccd55caf2e4a2ef0f9f/src/test/kotlin/com/example/springcore/test/Bar2Test.kt#L14-L17


The whole benefit of using either @TestComponent or @TestConfiguration outside a test class is to make those test components
and configurations available for other test classes as well. Otherwise, you just only make use of @TestConfiguration
annotation within an inner configuration class.

### Usage of Import

The role of @Import annotation is to import any Spring ApplicationContext configuration class or component class into the
ApplicationContext of the test being run.

## Customization of Liveness and Readiness Probes

By default, liveness and readiness probes only include livenessState and readinessState components which doesn't do anything
useful. It might be useful to add other components into those probes so that status of the application should be queried better.
You can achieve this by adding following properties into the application.properties file.

https://github.com/ksevindik/spring-core-examples/blob/f6b6b52f93d9e0a89bcb2f0e670f6604d7d80c5d/src/main/resources/application.properties#L7-L9