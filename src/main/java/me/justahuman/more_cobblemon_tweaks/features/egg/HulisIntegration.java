package me.justahuman.more_cobblemon_tweaks.features.egg;

import me.justahuman.more_cobblemon_tweaks.features.LoreEnhancements;
import me.justahuman.more_cobblemon_tweaks.utils.Utils;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.util.Formatting.AQUA;
import static net.minecraft.util.Formatting.GREEN;
import static net.minecraft.util.Formatting.WHITE;

public class HulisIntegration extends EnhancedEggLore {
    public static final String POLYMER_ID = "huliscobblebreeding:pokemonegg";

    protected final NbtCompound customData;
    protected final NbtCompound ivs;

    public HulisIntegration(NbtCompound nbt) {
        super(nbt);
        this.customData = nbt.getCompound(Utils.POLYMER_NBT_TAG);
        this.ivs = customData.get("IVs") instanceof NbtCompound compound ? compound : null;
    }

    @Override
    public boolean isShiny() {
        return Utils.get(customData, "shiny", false);
    }

    @Override
    public String getGender() {
        return Utils.get(customData, "Gender", "NONE");
    }

    @Override
    public List<Text> getHatchProgress() {
        final int cycles = Utils.get(customData, "currentEggCycle", -1);
        final double steps = Utils.get(customData, "stepsLeftInCycle", -1d);
        List<Text> lines = new ArrayList<>();
        if (cycles != -1) {
            lines.add(LoreEnhancements.translate("egg.hulis.hatch_progress.cycles").formatted(GREEN)
                    .append(Text.literal(String.valueOf(cycles)).formatted(WHITE)));
        }
        if (steps != -1) {
            lines.add(LoreEnhancements.translate("egg.hulis.hatch_progress.steps").formatted(AQUA)
                    .append(Text.literal(String.valueOf(Math.round(steps))).formatted(WHITE)));
        }
        return lines;
    }

    @Override
    public String getNature() {
        return Utils.get(customData, "Nature", "");
    }

    @Override
    public String getAbility() {
        NbtCompound ability = customData.get("Ability") instanceof NbtCompound compound ? compound : null;
        return Utils.get(ability, "AbilityName", "");
    }

    @Override
    public String getForm() {
        return Utils.get(customData, "FormId", "");
    }

    @Override
    public boolean hasIVs() {
        return ivs != null;
    }

    @Override
    public short getHpIV() {
        return Utils.get(ivs, "hp", (short) -1);
    }

    @Override
    public short getAtkIV() {
        return Utils.get(ivs, "attack", (short) -1);
    }

    @Override
    public short getDefIV() {
        return Utils.get(ivs, "defence", (short) -1);
    }

    @Override
    public short getSpAtkIV() {
        return Utils.get(ivs, "special_attack", (short) -1);
    }

    @Override
    public short getSpDefIV() {
        return Utils.get(ivs, "special_defence", (short) -1);
    }

    @Override
    public short getSpeedIV() {
        return Utils.get(ivs, "speed", (short) -1);
    }
}