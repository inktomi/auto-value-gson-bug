package com.inktomi.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class CarType extends BaseType {
    public static TypeAdapter<CarType> typeAdapter(Gson gson) {
        return new AutoValue_CarType.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_CarType.Builder();
    }

    public abstract String color();

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setFoo(String foo);
        public abstract Builder setColor(String color);
        public abstract CarType build();
    }
}
