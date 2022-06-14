# Udemy Spring MVC Tutorial
This repo is for referencing back on Spring topics learned in the spring tutorial I learned on https://www.udemy.com/course/spring-hibernate-tutorial/

## Index of Topics
> [MVC Overview and Configuration](#1.1)
>> + [MVC Overview](#1.2)
>> + [MVC Configuration](#1.3)

> [Environment Overview](#2.1)
>> + [Spring MVC Configuration in intellij](#2.2)
>> + [Docker Configuration](#2.3)

> [Controllers](#3.1)
>> + [@RequestMapping annotation](#3.2)
>> + [Accessing query parameters in the controller and view](#3.3)
>> + [Accessing the query parameters in the controller with @RequestParam](#3.4)
>> + [Nesting of @RequestMapping in the class to achieve URL Nesting](#3.5)
 
---

### MVC Overview and Configuration <a id='1.1'></a>

> #### MVC Overview <a id='1.2'></a>
>> + MVC is a web application for building web apps in Java
>> + Based on Model view controller
>> + The **DispatcherServlet** acts as a front controller like it provides a single entry point for a client request to Spring MVC web application and forwards request to Spring MVC controllers for proccessing.
>> + The **DispatcherServlet** is an actual **Servlet** (it inherits from the **HttpServlet** base class).
>> The **handler method** is a method in a java class that **handles** incoming HTTP requests.
>> The **controller class** is a java class that contains these **handler** methods.

>> Components in Spring MVC Architecture
>> + **DispatcherServlet** ( Front Controller )
>> + Handler Mapping
>> + Controller
>> + ViewResolver
>> + View Engine
>> <img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/pic8.png?raw=true">

---

> #### MVC Configuration <a id='1.3'></a>
>> Configuration of the **WEB-INF/web.xml**
>>> Step 1: Configure Spring MVC Dispatcher Servlet
>>>> The `<servlet>` tag is used to create the servlet along with the `<servlet-class>` in order to create a servlet of type **org.springframework.web.servlet.DispatcherServlet**

>>> Step 2: Setup URL mapping for the Spring MVC Dispatcher servlet
>>>> The `<servlet-mapping>` tag is used in order to setup the url mapping of `/` in this case all routes will be routed to the dispatcher servlet.

>> **web.xml**
>> ```
>> <web-app>
>>
>>  <!--  STEP 1: Configure Spring MVC Dispatcher Servlet  -->
>>  <servlet>
>>    <servlet-name>dispatcher</servlet-name>
>>    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
>> 
>>  <!-- Initial parameters passed to the dispatcher servlet -->
>>  <init-param>
>>    <param-name>contextConfigLocation</param-name>
>>    <param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
>>  </init-param>
>> 
>>    <load-on-startup>1</load-on-startup>
>>  </servlet>
>> 
>>  <!--  STEP 2: Set up URL mapping for Spring MVC Dispatcher Servlet  -->
>>  <servlet-mapping>
>>    <servlet-name>dispatcher</servlet-name>
>>    <url-pattern>/</url-pattern>
>>  </servlet-mapping>
>>
>> </web-app>
>> ```

>> Configuration of the **WEB-INF/spring-mvc-demo-servlet.xml**
>>> Step 3: Add support for component scanning
>>>> The `<context:component-scan>` tag is used to tell spring to use component scanning while specifiying the base package to scan recursively.

>>> Step 4: Add support for conversion, formatting and validation support
>>>> The `<mvc:annotation-driven/>` tag is used to tell spring to provide support for converstion, formatting and validation.

>>> Step 5:
>>>> Define the **Spring view resolver** with the `<bean>` annotation of class `org.springframework.web.servlet.view.InternalResourceViewResolver`.

>> **spring-mvc-demo-servlet.xml**
>> ```
>> <beans>
>>
>>  <!-- STEP 3: Add support for component scanning -->
>>  <context:component-scan base-package="com.luv2code.springdemo" />
>>
>>  <!-- STEP 4: Add support for conversion, formatting and validation support -->
>>  <mvc:annotation-driven/>
>>
>>  <!-- STEP 5: Define Spring MVC view resolver -->
>>  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
>>    <property name="prefix" value="/WEB-INF/view/" />
>>    <property name="suffix" value=".jsp" />
>>  </bean>
>> 
>> </beans>
>> ```

---


### Environment Overview <a id='2.1'></a>
> I chose to use the intellij IDE instead of the suggested eclipse IDE for the tutorial which meant there was additional configuration I had to do in order to follow the tutorial.

> The `lib` directory contains all the library files needed for Spring. The tutorial chose to go this route instead of using maven.  

> Specific **version** numbers of the technologies used
>> + JDK 11
>> + Spring version 5.3.8
>> + Tomcat Version 9

>> #### Spring MVC Configuration in intellij <a id='2.2'></a>
>>> 1. Create an empty project
>>> 2. Download the library files to the `lib` directory at the root of the project structure
>>> 3. Create a `web facet` directory called web
>>> 4. Configure artificats to be of type `Web application: Exploded`

>> #### Docker Configuration <a id='2.3'></a>
>>> 1. Pull the tomcat image with `docker pull tomcat`.
>>> 2. Then I installed the Intellij Docker plugin
>>> 3. Create a new docker image
>>>> <img src="https://github.com/TrestenPool/Udemy_Spring_MVC/blob/main/screenshots/pic1.png?raw=true">

>>>>> + **Bind Ports** 127.0.0.1:8080 to the container port of 8080
>>>>> + **Bind Mounts** local path of `/home/tpool/Playground/Udemy/Spring/Git_Notes/spring_mvc_demo/out/artifacts/spring_mvc_demo_Web_exploded` to the container path of `/usr/local/tomcat/webapps/spring`
>>>>> + Now everytime you build **artifacts** for the projects it will be automatically copied over to the webapps directory of the tomcat container.

---

### Creating Controllers <a id='3.1'></a>

> #### @RequestMapping annotation <a id='3.2'></a>
>> In order to declare a class file as a controller class you must place the `@Controller` annotation at the top of the class

>> Then in order to define the routes you must use the `@RequestMapping` annotation to tell the spring dispatcher servlet to route all request from the following route to the specified method.

>> ```
>> @Controller
>>  public class SpringApp {
>>  
>>    @RequestMapping(value="/index", method = RequestMethod.GET)
>>    public String showPage() {
>>      return "index";
>>    }
>> 
>>    // alternate way, you don't have define the method type
>>    @RequestMapping("/processForm")
>>    public String otherPage(){
>>      return "process";
>>    }
>>  }
>>  ```

---

### Accessing parameters in the controller and view <a id='3.3'></a>
> In order to manipulate the model, we must first accept the request into the parameters of the request mapping for the route with `HttpServletRequest request`. And also take in the model with `Model model` in our case.

> To get the query parameter in the model we have the method `request.getParameter()` with the name of the parameter in string format passed through as the argument.

> ```
>   @RequestMapping("/processFormVersionTwo")
>    public String processFormTwo(HttpServletRequest request, Model model){
>        // gets the parameter studentName from the request of the form
>        String theName = request.getParameter("studentName");
>
>        // convert the name to all caps
>        theName = theName.toUpperCase();
>
>        // create the message
>        String result = "YO! " + theName;
>
>        // adds data to the model
>        model.addAttribute("message", result);
>
>        // render the page, passes "message" with the value of result to the view
>        return "helloWorld";
>    }
>    ```

> At the end of the controller function for the request we are just returning the "helloWorld" view without having to pass in the model explicitily, this is because spring will pass the model to the view automatically for us so we can just reference the model in the view with `${message}` or whatever we named the attribute in the controller method.

> If we just wanted to access the parameter in the view without manipulating it in the controller, we can access the query parameter in the view by `${param.studentName}`

---

### Accessing parameters in the controller with @RequestParam <a id='3.4'></a>
> Instead of taking in the `HttpServletRequest request` argument in the method parameters and calling `request.getParameter()` to access the query parameter, we can instead use the annotation `@RequestParam()`.

> ```
>    // Using the @RequestParam instead
>    @RequestMapping("/processFormVersionTwo")
>    public String processFormTwo(@RequestParam("studentName") String theName, Model model){
> ```

---

### Nesting of @RequestMapping in the class to achieve url nesting <a id='3.5'></a>
> if we wanted to create a url structure of everything a dog can do like eat, sleep, restroom. We can nest them under the /dog url to make it clean and organized. So in theory if we wanted for the dog to eat it would go to the url /dog/eat, and similiarily if you wanted the dog to sleep, you would go to the url /dog/sleep.

> In order to achive this in spring we would create a class called DogController, and at the beginning of defining the class we would put the `@RequestMapping("/dog")` and each of the methods describing eat, sleep and restroom with the corresponding mapping like `@RequestMapping("/eat")`, etc..

---
