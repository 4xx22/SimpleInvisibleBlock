package fr.defalt.simpleinvisibleblock;

import fr.defalt.init.ModBlocks;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = simpleinvisibleblock.MODID, useMetadata = true, acceptedMinecraftVersions = "[1.12.2]")
public class simpleinvisibleblock {
    public static final String MODID = "simpleinvisibleblock";
    @Mod.Instance
    public static simpleinvisibleblock instance;

    @SidedProxy(clientSide = "fr.defalt.simpleinvisibleblock.ClientProxy", serverSide = "fr.defalt.simpleinvisibleblock.ServerProxy")
    public static CommonProxy proxy;
    public static Logger logger;

    public simpleinvisibleblock() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        ModBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }


}
