package com.inktomi.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Extension extends BaseClass {
    public static TypeAdapter<Extension> typeAdapter(Gson gson) {
        return new AutoValue_Extension.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Extension.Builder();
    }

    public abstract String secondField();
    public abstract BaseType type();

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setProperty(String property);
        public abstract Builder setSecondField(String secondField);
        public abstract Builder setType(BaseType type);
        public abstract Extension build();
    }
}
