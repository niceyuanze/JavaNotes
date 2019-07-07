package fastjsontest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;

public class FastJsonTest {
    public static void main(String[] args) {


        School school = new School(new EnglishTeacher());
        System.out.println(JSON.toJSONString(school,SerializerFeature.WriteClassName));
        School schoolreverse = JSON.parseObject("{\"@type\":\"fastjsontest.School\",\"teacher\":{\"@type\":\"fastjsontest.EnglishTeacher\"}}",School.class);
        System.out.println(schoolreverse.getTeacher().myName());
    }
}
