package com.github.retroPacifist.geckolib.file;

import com.eliotlash.molang.MolangParser;
import com.github.retroPacifist.geckolib.util.JsonAnimationUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ChainedJsonException;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.builder.Animation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static java.util.Objects.requireNonNull;

@UtilityClass
public class AnimationFileLoader {
    private final Gson GSON = new Gson();

    public AnimationFile createAnimationFile(MolangParser parser, ResourceLocation location, ResourceManager manager) {
        try {
            AnimationFile file = new AnimationFile();
            JsonObject object = createJsonObject(location, manager);
            JsonAnimationUtils.getAnimations(object).forEach(entry -> {
                try {
                    String key = entry.getKey();
                    file.put(key, deserializeJsonToAnimation(JsonAnimationUtils.getAnimation(key, object), parser));
                } catch (ChainedJsonException e) {
                    e.printStackTrace();
                }
            });
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }

    private Animation deserializeJsonToAnimation(Map.Entry<String, JsonElement> entry, MolangParser parser) {
        Animation animation = new Animation();

        return animation;
    }

    private JsonObject createJsonObject(ResourceLocation location, ResourceManager manager) throws IOException {
        return GsonHelper.fromJson(GSON, getResourceAsString(location, manager), JsonObject.class);
    }

    private String getResourceAsString(ResourceLocation location, ResourceManager manager) throws IOException {
        try (InputStream stream = requireNonNull(manager.getResource(location).getInputStream()); BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            StringBuilder builder = new StringBuilder();

            @Nullable String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            return builder.toString();
        }
    }
}
