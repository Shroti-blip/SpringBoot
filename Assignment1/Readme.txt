/*
*
*
*  1) in student.java we did create only setter and getter methods while using generate (alt + insert).
*    2) and in StudentEntryController we did create method like GetMapping , GetPost , DeletPost etc.
*
*   3) @Controller
      @RequestMapping("/student") we are going to write that before classname to /student will map all the methods.
*
*     4)   List<Student> studentList = new ArrayList<>();  for storing multiple data we will take
*           classname as an datatype
*
 -->
                    List<Student>
                    List is an interface in Java from the java.util package.

                    It represents an ordered collection (like an array but more flexible).

                    <Student> is a generic type, meaning this list will only hold Student objects.

                     So, List<Student> means: "a list that can store Student objects only."

                      ArrayList is a class that implements the List interface.
-->
*
*
*
*       5)     @RequestBody ---->>  It tells Spring Boot to take the JSON data from the incoming request and convert it into a Java object.
*               Why it’s needed: Because we’re receiving data (student info) from the client (e.g., Postman or frontend app).
*
*
*          6)   @ResponseBody------>> It tells Spring Boot to return the method’s result directly as the HTTP response, not as a view (like a webpage).
*               It’s useful when you are building REST APIs, not webpages.
*
*           ** 7)  If your class is annotated with @RestController, then you don’t need to write @ResponseBody — because it’s already included behind the scenes.
*
*
*               8)  @RequestBody Student stu -->> We're expecting the client (like Postman or a frontend) to send data in JSON format.

                That JSON will be automatically converted into a Java object of class Student.
*
*               9) @PathVariable tells Spring Boot to get a value directly from the URL path and pass it into your method as a parameter.
                    //(parameter) -> { logic } Lamda function logic
*

*
*
*
*
*
*
* */






