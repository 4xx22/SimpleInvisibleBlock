package fr.defalt.init;

import fr.defalt.blocks.BlockInvi;
import fr.defalt.simpleinvisibleblock.simpleinvisibleblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= simpleinvisibleblock.MODID)
public class ModBlocks {

    static Block invisibleBlockLumi;
    static Block invisibleBlock;

    public static void init() {
        invisibleBlockLumi = new BlockInvi("invisible_block_lumi", Material.ROCK).setHardness(6000000.0f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setBlockUnbreakable().setLightOpacity(0).setLightLevel(1.0F);
        invisibleBlock = new BlockInvi("invisible_block", Material.ROCK).setHardness(6000000.0f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setBlockUnbreakable().setLightOpacity(0);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(invisibleBlockLumi);
        event.getRegistry().registerAll(invisibleBlock);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(invisibleBlockLumi).setRegistryName(invisibleBlockLumi.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(invisibleBlock).setRegistryName(invisibleBlock.getRegistryName()));

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(invisibleBlockLumi));
        registerRender(Item.getItemFromBlock(invisibleBlock));
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
    }
}