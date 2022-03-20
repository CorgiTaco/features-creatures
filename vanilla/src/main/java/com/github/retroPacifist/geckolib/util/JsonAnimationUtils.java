package com.github.retroPacifist.geckolib.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;
import net.minecraft.server.ChainedJsonException;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class JsonAnimationUtils {

    public Map.Entry<String, JsonElement> getAnimation(String name, JsonObject object) throws ChainedJsonException {
        return new AbstractMap.SimpleEntry<>(name, getObjectByKey(getAnimations(object), name));
    }

    public static Set<Map.Entry<String, JsonElement>> getAnimations(JsonObject json) {
        return getObjectListAsArray(json.getAsJsonObject("animations"));
    }

    public static Set<Map.Entry<String, JsonElement>> getObjectListAsArray(JsonObject json) {
        return json.entrySet();
    }

    private JsonElement getObjectByKey(Set<Map.Entry<String, JsonElement>> set, String key) throws ChainedJsonException {
        return set.stream().filter(x -> x.getKey().equals(key)).findFirst().orElseThrow(() -> new ChainedJsonException("Could not find key: '%s'".formatted(key))).getValue();
    }
}
