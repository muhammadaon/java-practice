import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args){


        String value = "{\"busTypeDesc\":\"Money Transfer\",\"contactName\":\"\",\"deliveryAddress\":\"\",\"fromFavorites\":false,\"image\":\"\",\"isSelected\":false,\"metadata\":\"\",\"note\":\"\"}";

        TestDTO testDTO = null;
        Gson gson = new Gson();
        testDTO = gson.fromJson(value, TestDTO.class);

        if (null != testDTO) {


            System.out.println("value of bus type desc = " + testDTO.getBusTypeDesc());
            System.out.println("value of from favorites = " + testDTO.getFromFavorites());



        }

    }

}
