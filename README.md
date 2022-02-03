Assignment: Your Own @WebRoute Annotation
Task
Your task is to create a mini-webserver that uses reflection and annotations to route browser requests to specific handler methods.

You might have already seen something similar if you've used Flask's routing mechanism, e.g. @app.route('/hello') or if you've written Java Servlet-based webapps, e.g. @WebServlet("/hello").

You will see later on that Spring does something similar with its @RestController and @GetMapping annotations.

Details
Use the built-in webserver available from Java 8 and in later version.

See the documentation of its features.
Refer to the documentation of the HttpExchange class, which encapsulates an HTTP request and response as well.
Here's a quickstart guide.
Your task is to create a custom annotation called @WebRoute which can be used to annotate methods. Methods annotated with @WebRoute("/path") will be your HTTP request handlers. They are called whenever a request accepted by the webserver matches the "/path" value in a @WebRoute annotation.

Use reflection to find the right method for an incoming request.

Here is an example:

@WebRoute("/test")
String onTest() {
    // Here goes the code to handle all requests going to localhost:8000/test
    // and to return something
}
A little step-by-step guide
Spolier alert! Only read this, if you struggle with the assignment!

create a simple Maven project in IntelliJ
open this quickstart guide, and copy-paste the Test class
read through this response very carefully!
run your code
try to experiment with changing the response variable
maybe experiment with adding different path + handler combinations, like server.createContext("/another", new AnotherMyHandler());
don't forget to try all these paths in your web browser!
add your WebRoute.java annotation to the project
create a Routes.java class with two methods (public String test1(){...} and public String test2(){...})
annotate both of these methods with your WebRoute annotation with different paths, just like in the example above!
now go back to your Test class, and try to process your Routes class, like this:
for(Method m: Routes.class.getMethods()) {
  if(m.isAnnotationPresent(WebRoute.class)) {
    /*
      Here comes your logic.
      If the given path from the HttpExchange method is
      the SAME like the WebRoute annotation's path,
      you should INVOKE this method.
    */
  }
}
you should decide about where you want to process these methods
the easy and cheap solution is, you process them right in the MyHandler class. This is not efficient, because it runs every time when a request arrives to the server! What a shame.
the good solution is, when you only process the methods once at startup, and store the path + method pairs in a HashMap! Try to figure it out, it's a way better solution.
run your code in Debug mode and inspect your Method instances to get a better insight
Extra features
Support GET, POST, etc. as well. You will need to name the parameters in your annotation, for example:

@WebRoute(method=POST, path = "/users")
String onTest() {
    // here goes the code to handle POST requests going to localhost:8000/users
}
Another feature is to extract variables from the path itself:

@WebRoute("/user/<userName>")
String onTest(String userName) {
    // here goes the code to handle all requests going to localhost:8000/user/joe
}
