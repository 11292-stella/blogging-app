package exception;

public class BlogPostNotFoundException extends Exception{
    public BlogPostNotFoundException(String message){
        super(message);
    }
}
