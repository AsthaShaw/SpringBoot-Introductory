# SpringBoot Introductory Project

This is my revision of Spring before I start building the Super Mummy Project!!

## Day 1

# Basics of Spring

- Application context will manage the lifecycle of the created instances
- Spring framework through component and autowired will manage the creation of these classes
- By default any bean we create in Spring is a singleton bean
- If there is no component or more than one @Component then Spring framework will throw an error
- @Component-is a class managed by Spring framework

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
