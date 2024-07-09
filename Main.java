package com.dungeon_additions.da;


import com.dungeon_additions.da.blocks.BlockLeaveBase;
import com.dungeon_additions.da.init.ModEntities;
import com.dungeon_additions.da.proxy.CommonProxy;
import com.dungeon_additions.da.util.ModReference;
import com.dungeon_additions.da.util.handlers.SoundsHandler;
import com.dungeon_additions.da.util.handlers.StructureHandler;
import com.dungeon_additions.da.world.ModWorldGen;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ModReference.MOD_ID, name = ModReference.NAME, version = ModReference.VERSION)
public class Main {


    @SidedProxy(clientSide = ModReference.CLIENT_PROXY_CLASS, serverSide = ModReference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper network;


    public static <MSG extends IMessage> void sendMSGToAll(MSG message) {

      //  for(EntityPlayerMP playerMP : Minecraft.getMinecraft().) {
          //  sendNonLocal(message, playerMP);
      //  }
        //network.sendToAll(message);
    }


    public static <MSG extends IMessage> void sendNonLocal(MSG message, EntityPlayerMP playerMP) {
        network.sendTo(message, playerMP);
    }
    @Mod.Instance
    public static Main instance;

    public Main() {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.init();
        ModEntities.registerEntities();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 1);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        SoundsHandler.registerSounds();
        StructureHandler.handleStructureRegistries();

    }
}
