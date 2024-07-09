package com.dungeon_additions.da.proxy;

import com.dungeon_additions.da.Main;
import com.dungeon_additions.da.animation.AnimationMessage;
import com.dungeon_additions.da.blocks.BlockLeaveBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy{

    public void init() {

        int packetId = 0;

        Main.network.registerMessage(AnimationMessage.Handler.class, AnimationMessage.class, packetId++, Side.SERVER);

    }

    public void setFancyGraphics(BlockLeaveBase block, boolean isFancy) {
    }

    public void handleAnimationPacket(int entityId, int index) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
