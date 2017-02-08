package com.inktomi.autovalue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtensionTest {

    @Test
    public void testFieldsSet() {
        CarType car = CarType.builder().setFoo("foo").setColor("blue").build();
        Extension test = Extension.builder().setProperty("property").setSecondField("second").setType(car).build();

        assertThat(test.type()).isInstanceOf(CarType.class);
        assertThat(test.property()).isEqualTo("property");
        assertThat(test.secondField()).isEqualTo("second");
    }

    @Test
    public void testFieldsSet_afterAutoValueGson() {
        CarType car = CarType.builder().setFoo("foo").setColor("blue").build();
        Extension test = Extension.builder().setProperty("property").setSecondField("second").setType(car).build();

        Gson gson = new GsonBuilder()
                         .registerTypeAdapterFactory(CustomTypeAdapterFactory.create())
                         .create();

        String json = gson.toJson(test);

        // This is the json returned, note the empty "type" parameter
        // {"property":"property","secondField":"second","type":{}}

        Extension reformed = gson.fromJson(json, Extension.class);

        assertThat(reformed.type()).isInstanceOf(CarType.class);
        assertThat(reformed.property()).isEqualTo("property");
        assertThat(reformed.secondField()).isEqualTo("second");
    }
}
