public class Routes {
    @WebRoute()
    public String test() { return "This is a response";}

    @WebRoute(path = "/another")
    public String another() { return "This is another response";}

    @WebRoute(method = "POST", path = "/post")
    public void somePostMethod() {}

//    @WebRoute(path = "/<something>")
//    public String printTest(String something){
//        System.out.println(something);
//        return something;
//    }
}
