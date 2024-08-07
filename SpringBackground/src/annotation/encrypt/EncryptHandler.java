package annotation.encrypt;
import java.lang.reflect.Field;
import java.util.Base64;
public class EncryptHandler {
    
    // @Encrypt 발견
    public static void handleAnnotation(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            if( field.isAnnotationPresent(Encrypt.class)) {
                encryptField(obj, field);
            }
        }
    }
    // @Encrypt 처리
    private static void encryptField(Object obj, Field field) {
        field.setAccessible(true);
        // 암호화
        try {
            Object value = field.get(obj); // "1234"
            if( value instanceof String ) {
                String encryptedValue = Base64.getEncoder().encodeToString( ((String)value).getBytes() );
                field.set(obj, encryptedValue);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
