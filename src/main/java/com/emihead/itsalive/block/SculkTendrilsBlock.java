//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.emihead.itsalive.block;

import com.emihead.itsalive.ItsAlive;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.IShearable;
import net.neoforged.neoforge.registries.DeferredBlock;


public class SculkTendrilsBlock extends TallGrassBlock implements IShearable, BonemealableBlock {
    public SculkTendrilsBlock(BlockBehaviour.Properties pProperties) { super(pProperties); }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(Blocks.SCULK);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        BlockState blockstate = ItsAlive.TALL_SCULK_TENDRILS.get().defaultBlockState();
        BlockState blockstate1 = blockstate.setValue(TallSculkTendrilsBlock.HALF, DoubleBlockHalf.UPPER);
        BlockPos blockpos = pos.above();
        if (level.isEmptyBlock(pos.above())) {
            level.setBlock(pos, blockstate, 2);
            level.setBlock(blockpos, blockstate1, 2);
        }
    }
}
