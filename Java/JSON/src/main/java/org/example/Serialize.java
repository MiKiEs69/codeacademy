package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.Map;

public class Serialize {

    static class IOStreams {

        public void serialize(Property property) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("property.bin"))) {
                oos.writeObject(property);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void deserialize() {
            Property property;

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("property.bin"))) {
                property = (Property) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }



    }

    static class Json {
            private final ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File("property.json");

            Json(){
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
            }

        public void serialize(Property property) {
            try {
                mapper.writeValue(jsonFile, property);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void deserialize() {
            try {
                mapper.readValue(jsonFile, Property.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        public Map<String, String> deMap() {
                try {
                    return mapper.readValue(jsonFile, Map.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        Property property1 = new Property(
                new Adress("Sauletekio al.", Adress.Country.LIETUVA, "45612"),
                new Person("Antanas", "Kurlys"),
                "living quarters");

        new Serialize.IOStreams().serialize(property1);
        new Serialize.IOStreams().deserialize();

        new Serialize.Json().serialize(property1);

        var propertyMap = new Serialize.Json().deMap();
        new Serialize.Json().deserialize();

        System.out.println(propertyMap);


//        System.out.println(adress2);
//
    }
}
