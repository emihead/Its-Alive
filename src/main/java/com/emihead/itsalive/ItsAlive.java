package com.emihead.itsalive;

import com.emihead.itsalive.block.SculkTendrilsBlock;
import com.emihead.itsalive.block.SculkToothBlock;
import com.emihead.itsalive.block.TallSculkTendrilsBlock;
import com.emihead.itsalive.registry.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(com.emihead.itsalive.ItsAlive.MODID)
public class ItsAlive
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "itsalive";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "itsalive" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "itsalive" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "itsalive" namespace
    // Create block
    public static final DeferredBlock<Block> SCULK_TOOTH = BLOCKS.register(
            "sculk_tooth",
            () -> new SculkToothBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> BRUSHED_SCULK_TOOTH = BLOCKS.register(
            "brushed_sculk_tooth",
            () -> new SculkToothBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> SCULK_TENDRILS = BLOCKS.register(
            "sculk_tendrils",
            () -> new SculkTendrilsBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .replaceable()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.SCULK)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<Block> TALL_SCULK_TENDRILS = BLOCKS.register(
            "tall_sculk_tendrils",
            () -> new TallSculkTendrilsBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .replaceable()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.SCULK)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<Block> ENAMEL_BRICKS = BLOCKS.register(
            "enamel_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> ENAMEL_BRICK_SLAB = BLOCKS.register(
            "enamel_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> ENAMEL_BRICK_STAIRS = BLOCKS.register(
            "enamel_brick_stairs",
            () -> new StairBlock(ENAMEL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> ENAMEL_COLUMN = BLOCKS.register(
            "enamel_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> SPINAL_COLUMN = BLOCKS.register(
            "spinal_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> BRUSHED_ENAMEL_BRICKS = BLOCKS.register(
            "brushed_enamel_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> BRUSHED_ENAMEL_BRICK_SLAB = BLOCKS.register(
            "brushed_enamel_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> BRUSHED_ENAMEL_BRICK_STAIRS = BLOCKS.register(
            "brushed_enamel_brick_stairs",
            () -> new StairBlock(BRUSHED_ENAMEL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> BRUSHED_ENAMEL_COLUMN = BLOCKS.register(
            "brushed_enamel_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .destroyTime(1.0f)
                    .explosionResistance(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)
            )
    );
    public static final DeferredBlock<Block> SCULK_THATCH = BLOCKS.register(
            "sculk_thatch",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(0.75f)
                    .explosionResistance(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WART_BLOCK)
            )
    );
    public static final DeferredBlock<Block> SCULK_THATCH_SLAB = BLOCKS.register(
            "sculk_thatch_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .destroyTime(0.75f)
                    .explosionResistance(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WART_BLOCK)
            )
    );
    public static final DeferredBlock<Block> SCULK_THATCH_STAIRS = BLOCKS.register(
            "sculk_thatch_stairs",
            () -> new StairBlock(SCULK_THATCH.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .destroyTime(0.75f)
                    .explosionResistance(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WART_BLOCK)
            )
    );

    // Creates blockitem
    public static final DeferredItem<BlockItem> SCULK_TOOTH_ITEM = ITEMS.registerSimpleBlockItem("sculk_tooth", SCULK_TOOTH);
    public static final DeferredItem<BlockItem> BRUSHED_SCULK_TOOTH_ITEM = ITEMS.registerSimpleBlockItem("brushed_sculk_tooth", BRUSHED_SCULK_TOOTH);
    public static final DeferredItem<BlockItem> SCULK_TENDRILS_ITEM = ITEMS.registerSimpleBlockItem("sculk_tendrils", SCULK_TENDRILS);
    public static final DeferredItem<BlockItem> TALL_SCULK_TENDRILS_ITEM = ITEMS.registerSimpleBlockItem("tall_sculk_tendrils", TALL_SCULK_TENDRILS);
    public static final DeferredItem<BlockItem> ENAMEL_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("enamel_bricks", ENAMEL_BRICKS);
    public static final DeferredItem<BlockItem> ENAMEL_BRICK_SLAB_ITEM = ITEMS.registerSimpleBlockItem("enamel_brick_slab", ENAMEL_BRICK_SLAB);
    public static final DeferredItem<BlockItem> ENAMEL_BRICK_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("enamel_brick_stairs", ENAMEL_BRICK_STAIRS);
    public static final DeferredItem<BlockItem> ENAMEL_COLUMN_ITEM = ITEMS.registerSimpleBlockItem("enamel_column", ENAMEL_COLUMN);
    public static final DeferredItem<BlockItem> SPINAL_COLUMN_ITEM = ITEMS.registerSimpleBlockItem("spinal_column", SPINAL_COLUMN);
    public static final DeferredItem<BlockItem> BRUSHED_ENAMEL_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("brushed_enamel_bricks", BRUSHED_ENAMEL_BRICKS);
    public static final DeferredItem<BlockItem> BRUSHED_ENAMEL_BRICK_SLAB_ITEM = ITEMS.registerSimpleBlockItem("brushed_enamel_brick_slab", BRUSHED_ENAMEL_BRICK_SLAB);
    public static final DeferredItem<BlockItem> BRUSHED_ENAMEL_BRICK_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("brushed_enamel_brick_stairs", BRUSHED_ENAMEL_BRICK_STAIRS);
    public static final DeferredItem<BlockItem> BRUSHED_ENAMEL_COLUMN_ITEM = ITEMS.registerSimpleBlockItem("brushed_enamel_column", BRUSHED_ENAMEL_COLUMN);
    public static final DeferredItem<BlockItem> SCULK_THATCH_ITEM = ITEMS.registerSimpleBlockItem("sculk_thatch", SCULK_THATCH);
    public static final DeferredItem<BlockItem> SCULK_THATCH_SLAB_ITEM = ITEMS.registerSimpleBlockItem("sculk_thatch_slab", SCULK_THATCH_SLAB);
    public static final DeferredItem<BlockItem> SCULK_THATCH_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("sculk_thatch_stairs", SCULK_THATCH_STAIRS);

    // item template in case i need it later lol
    // public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
    //        .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ItsAlive(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        SoundEvents.SOUND_EVENTS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        //NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        // LOGGER.info("It's Alive initialized");

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(SCULK_TOOTH_ITEM);
            event.accept(BRUSHED_SCULK_TOOTH_ITEM);
            event.accept(SCULK_TENDRILS_ITEM);
            event.accept(TALL_SCULK_TENDRILS_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ENAMEL_BRICKS_ITEM);
            event.accept(ENAMEL_BRICK_SLAB_ITEM);
            event.accept(ENAMEL_BRICK_STAIRS_ITEM);
            event.accept(ENAMEL_COLUMN_ITEM);
            event.accept(SPINAL_COLUMN_ITEM);
            event.accept(BRUSHED_ENAMEL_BRICKS_ITEM);
            event.accept(BRUSHED_ENAMEL_BRICK_SLAB_ITEM);
            event.accept(BRUSHED_ENAMEL_BRICK_STAIRS_ITEM);
            event.accept(BRUSHED_ENAMEL_COLUMN_ITEM);
            event.accept(SCULK_THATCH_ITEM);
            event.accept(SCULK_THATCH_SLAB_ITEM);
            event.accept(SCULK_THATCH_STAIRS_ITEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    //@SubscribeEvent
    //public void onServerStarting(ServerStartingEvent event)
    //{
    //    // Do something when the server starts
    //    LOGGER.info("HELLO from server starting");
    //}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    //@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    //public static class ClientModEvents
    //{
    //    @SubscribeEvent
    //    public static void onClientSetup(FMLClientSetupEvent event)
    //    {
    //        // Some client setup code
    //        LOGGER.info("HELLO FROM CLIENT SETUP");
    //        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    //    }
    //}
}
