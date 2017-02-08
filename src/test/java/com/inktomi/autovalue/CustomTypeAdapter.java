package com.inktomi.autovalue;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class CustomTypeAdapter implements JsonSerializer<BaseType>, JsonDeserializer<BaseType> {
    private Gson gson = new Gson();

    @Override public BaseType deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
        throws JsonParseException {

        if(typeOfT.equals(CarType.class)) {
            return CarType.typeAdapter(gson).fromJsonTree(json);
        }

        return null;
    }

    @Override public JsonElement serialize(final BaseType src, final Type typeOfSrc, final JsonSerializationContext context) {
        if(typeOfSrc.equals(CarType.class)) {
            return CarType.typeAdapter(gson).toJsonTree((CarType) src);
        }

        return null;
    }
}
