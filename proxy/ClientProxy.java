package com.dungeon_additions.da.proxy;

import com.dungeon_additions.da.animation.IAnimatedEntity;
import com.dungeon_additions.da.blocks.BlockLeaveBase;
import com.dungeon_additions.da.util.handlers.RenderHandler;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{


    @Override
    public void init() {
        RenderHandler.registerProjectileRenderers();
        RenderHandler.registerGeoEntityRenderers();
        RenderHandler.registerEntityRenderers();
    }


    @Override
    public void handleAnimationPacket(int entityId, int index) {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        if (player != null) {
            IAnimatedEntity entity = (IAnimatedEntity) player.world.getEntityByID(entityId);
            if (entity != null) {
                if (index == -1) {
                    entity.setAnimation(IAnimatedEntity.NO_ANIMATION);
                } else {
                    entity.setAnimation(entity.getAnimations()[index]);
                }
                entity.setAnimationTick(0);
            }
        }
    }

    @Override
    public void setFancyGraphics(BlockLeaveBase block, boolean isFancy) {
        block.setFancyGraphics(isFancy);
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
