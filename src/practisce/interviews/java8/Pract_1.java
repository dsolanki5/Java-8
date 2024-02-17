package practisce.interviews.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Pract_1 {
	
	public static final String SPANISH_LC_CC_CODES[] = {
            "es-BO", "es-GT", "es-CL", "es-CO", "es-PE", "es-PR", "es-PY", "es-EC",
            "es-UY", "es-ES", "es-VE", "es-MX", "es-AR"
    };

    public static void main(String[] args) {
        // Existing map
        Map<String, String> existingMap = new HashMap();
        existingMap.put("key1", "value1");
        existingMap.put("key2", "value2");

        // Add keys from the array to the existing map
        existingMap.putAll(Arrays.stream(SPANISH_LC_CC_CODES)
                .collect(Collectors.toMap(key -> key, value -> "doc-id")));

        // Print the updated map
        //existingMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        existingMap.forEach((x,y) -> System.out.println(x+" - "+y));
    }

}
