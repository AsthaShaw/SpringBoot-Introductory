# SpringBoot Introductory Project

This is my revision of Spring before I start building the Super Mummy Project!!

## Day 1

# Basics of Spring

- Application context will manage the lifecycle of the created instances
- Spring framework through component and autowired will manage the creation of these classes
- By default any bean we create in Spring is a singleton bean
- If there is no component or more than one @Component then Spring framework will throw an error
- @Component-an instance of the class is managed by Spring framework

**How does Spring Framework find component classes?**

                 Through component scanning specific packages(the packages are automatically picked up by @SpringBootApplication)-you can explicitly changing the package by mentioning the @ComponentScan(”package name”)

- Identify beans, their dependencies and wire them together(provides IOC-Inversion of Control- Previously I was creating the objects and now Spring framework is managing the creation and life cycle of objects so we are basically inversing the responsibility from us to Spring Framework)
- Spring Beans-An object managed by Spring framework
- IOC container-The container that manages the lifecycle of beans and dependencies - Types : ApplicationContext(complex), Bean Factory(simpler features-rarely used)
- Autowiring- The process of wiring in dependencies for a Spring Bean

# Value of Spring Framework

- Instead of focussing on objects, their dependencies and wiring we focus on the business logic of the application
- SpringFramework manages the lifecycle of objects -

 1. Mark components using annotations: @Component

1. Mark dependencies using @Autowired 
2. Allow Spring Framework to do its magic!

# @Primary

- When you have more than one matching components then you have to declare one as the primary one which has the highest priority.

# How is Spring JAR downloaded?

By Maven in pom.xml-downloads spring jars and transitive dependencies

Maven dependency-jars your project need(higher level)

Spring dependency-Spring Beans we need (lower level)

# Spring Framework Dependency Injection

- Constructor-based-Dependencies are set by creating the Bean using its constructor(This is recommended by Spring)as dependencies are automatically set when an object is created
- Writing Autowired on constructor injection is optional
```jsx
  @Autowired
    private GamingConsole game;
//constructor based injection
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

```

- Setter-based-Dependencies are set by calling setter methods on your beans

```jsx

//setter injection

    @Autowired
   public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
```

Field-Dependency is injected using reflection

```jsx
@Autowired
private DataService dataService;
```

# Day 2

SpringBoot is a wrapper to easily work with Spring and SpringMVC

SpringBoot helps to create SpringBoot projects fast through

- Spring Initializer
- SpringBoot Starter Projects
- SpringBoot Auto Configuration
- SpringBoot Dev Tools

Production Ready

- Logging
- Different Configuration for Different Environments - Profiles, ConfigurationProperties
- Monitoring (Spring Boot Actuator)

**IntelliJ CE does not support devTools**

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-devtools</artifactId>
   <version>3.2.4</version>
</dependency>
```

**Configuration properties and profiles** 

     great way to work with different environments-prod, dev, test. Example built using currency-service

### Simplify Deployment with SpringBoot Embedded Servers

- Just need to install Java and have the jar. No more needed for WAR

## Actuator-gets you a lot of metrics about your application and java runtime and Tomcat server

- In actuator/beans all the autoconfigured beans are there
- configprops-all the things you can configure from application.properties

## ComponentScan

What is a component scan in Spring?

In **Spring**, **component scanning** is a mechanism that allows the framework to **automatically detect and register** certain types of classes as **Spring-managed components**. Let’s dive into the details:

1. **Purpose of Component Scanning**:
    - When building a Spring application, we often create classes that serve as **beans**, such as controllers, services, repositories, and other components.
    - Instead of manually registering each bean in the Spring configuration, we can use **component scanning** to **automatically discover** these classes and add them to the Spring application context.
2. **How Component Scanning Works**:
    - We annotate our classes with specific annotations (such as **`@Component`**, **`@Service`**, **`@Repository`**, or **`@Controller`**) to indicate that they are Spring beans.
    - The **component scanning process** then searches for these annotated classes within specified packages.
    - Spring instantiates these classes and manages their lifecycle (e.g., dependency injection, initialization, and destruction).
3. **Using `@ComponentScan`**:
    - The primary annotation for component scanning is **`@ComponentScan`**.
    - We typically use it in conjunction with **`@Configuration`** (or other stereotype annotations) to define where Spring should look for components.
    - By default, **`@ComponentScan`** scans the **current package** and all its **sub-packages**.
    - Example:**Java**
        
        `@Configuration
        @ComponentScan
        public class MyAppConfig {
            // Other configuration or bean definitions
        }`
        
        AI-generated code. Review and use carefully. [More info on FAQ](https://www.bing.com/new#faq).
        
4. **Customizing Component Scanning**:
    - We can customize the behavior of component scanning by providing additional arguments to **`@ComponentScan`**.
    - For instance:
        - Specify specific **base packages** to scan: **`@ComponentScan("com.example.myapp")`**
        - Exclude certain classes or packages: **`@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyExcludedClass.class))`**
        - Use custom filters to include or exclude specific components based on criteria.
5. **Considerations**:
    - The **main application class** (annotated with **`@Configuration`** or other stereotypes) is also scanned for components.
    - The **location of the configuration class** matters; component scanning starts from its package by default.
    - If the main application class and configuration class are different, only the configuration class’s package matters.

Remember, component scanning simplifies bean registration and helps keep our Spring configuration concise and maintainable! 🌱🌼
