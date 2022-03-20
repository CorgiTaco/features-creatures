package com.github.retroPacifist.geckolib.file;

import com.eliotlash.molang.MolangParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import lombok.experimental.UtilityClass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@UtilityClass
public class AnimationFileLoader {
    private final Gson GSON = new Gson();

    public AnimationFile createAnimationFile(MolangParser parser, ResourceLocation location, ResourceManager manager) {
        try {
            AnimationFile file = new AnimationFile();

            JsonObject jsonObject = createJsonObject(location, manager);

            Set<Map.Entry<String, JsonElement>> set = jsonObject.getAsJsonObject("animations").entrySet();

            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
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
