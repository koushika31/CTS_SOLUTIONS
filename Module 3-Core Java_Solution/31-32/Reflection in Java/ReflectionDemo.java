import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Load class by name
        Class<?> cls = Class.forName("MyClass");

        // Create instance
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Get all declared methods
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            // Print method name
            System.out.print("Method: " + method.getName());

            // Print parameter types
            System.out.print(" (Parameters: ");
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getType().getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");

            // Example: Invoke method 'sayHello' with no parameters
            if (method.getName().equals("sayHello") && params.length == 0) {
                method.invoke(obj);  // prints "Hello, reflection!"
            }

            // Example: Invoke method 'add' with parameters 5 and 7
            if (method.getName().equals("add") && params.length == 2) {
                Object result = method.invoke(obj, 5, 7);
                System.out.println("Result of add(5,7): " + result);
            }
        }
    }
}
