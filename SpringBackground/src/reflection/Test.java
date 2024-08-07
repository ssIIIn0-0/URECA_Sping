package reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> userClass = Class.forName("reflection.Book");
        
//      // class 이름
      System.out.println(userClass.getName());
//      
//      // field
      Field[] fields = userClass.getDeclaredFields();
      for (Field field : fields) {
          System.out.println(field.getName() + " / " + field.getType());
      }
//      
//      // method
      Method[] methods = userClass.getDeclaredMethods();
      for (Method method : methods) {
          System.out.println(method.getName() + " / " + method.getReturnType());
      }
//      
      // constructor
      Constructor<?>[] constructors = userClass.getDeclaredConstructors();
      for (Constructor constructor : constructors) {
          System.out.println(constructor.getName() + " / " + constructor.getParameterCount());
      }
        
        
        //// Class 의 객체 생성, 제어
//        Constructor<?> constructor = userClass.getDeclaredConstructor(String.class, String.class);
//        Object obj = constructor.newInstance("홍길동", "1234");
//        System.out.println(obj);
//        
//        // 객체의 field
//        Field username = userClass.getDeclaredField("username");
//        System.out.println(username.canAccess(obj));  // private 이면 false
//        
//        username.setAccessible(true);
//        System.out.println(username.canAccess(obj));
//        
//        System.out.println(obj);
//        // setter
//        username.set(obj, "이길동");
//        System.out.println(obj);
//        
//        // 메소드 호출
//        Method getPassword = userClass.getDeclaredMethod("getPassword");
//        String password = (String) getPassword.invoke(obj);
//        System.out.println(password);
//        
//        Method setPassword = userClass.getDeclaredMethod("setPassword", String.class);
//        setPassword.invoke(obj, "5678");
//        System.out.println(obj);
        
    }
}