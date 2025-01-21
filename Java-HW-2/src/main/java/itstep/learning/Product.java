package itstep.learning;

import java.util.LinkedHashMap;
import java.util.Map;

public class Product {
    Map<String, String> fields = new LinkedHashMap<>();

    public Product(String name)
    {
        fields.put("name", name);
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        answer.append(fields.get("name"));
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if(!entry.getKey().equals("name"))
                answer.append("\n\t").append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return answer.toString();
    }
}
