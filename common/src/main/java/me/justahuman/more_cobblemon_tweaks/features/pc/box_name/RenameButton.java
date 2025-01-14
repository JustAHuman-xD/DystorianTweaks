package me.justahuman.more_cobblemon_tweaks.features.pc.box_name;

import me.justahuman.more_cobblemon_tweaks.features.PcEnhancements;
import me.justahuman.more_cobblemon_tweaks.features.pc.search.SearchButton;
import me.justahuman.more_cobblemon_tweaks.features.pc.search.SearchWidget;
import me.justahuman.more_cobblemon_tweaks.features.pc.wallpaper.WallpaperButton;
import me.justahuman.more_cobblemon_tweaks.utils.CustomButton;
import me.justahuman.more_cobblemon_tweaks.utils.Textures;
import me.justahuman.more_cobblemon_tweaks.utils.Utils;
import net.minecraft.client.gui.components.Renderable;

import java.util.Set;

public class RenameButton extends CustomButton {
    public RenameButton(int x, int y, Set<Renderable> siblings) {
        super(x, y, Textures.RENAME_BUTTON_WIDTH, Textures.BUTTON_HEIGHT, Textures.RENAME_BUTTON_TEXTURE, siblings);
        setTooltip(PcEnhancements.tooltip("custom_pc_box_names.tooltip"));
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        handleSibling(RenameWidget.class, widget -> widget.setVisible(true));
        handleSibling(ConfirmButton.class, button -> button.setVisible(true));
        handleSibling(CancelButton.class, button -> button.setVisible(true));

        setVisible(false);
        handleSibling(WallpaperButton.class, button -> button.setVisible(false));
        handleSibling(SearchButton.class, button -> button.setVisible(false));
        handleSibling(SearchWidget.class, widget -> {
            widget.setVisible(false);
            Utils.search = null;
        });
    }
}