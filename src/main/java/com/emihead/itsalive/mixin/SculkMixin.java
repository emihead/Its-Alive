package com.emihead.itsalive.mixin;

import com.emihead.itsalive.ItsAlive;
import com.emihead.itsalive.block.SculkToothBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin(SculkBlock.class)
public abstract class SculkMixin extends DropExperienceBlock implements BonemealableBlock, SculkBehaviour {

    protected SculkMixin(IntProvider intProvider, Properties properties) {
        super(intProvider, properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        final int maxSuccesses = randomSource.nextIntBetweenInclusive(1, 7);
        int successCounter = 0;
        for (int i = 0; i < 64 && successCounter < maxSuccesses; i++) {
            BlockPos newPos = pos.offset(0,1,0);
            for (int j = 0; j < i / 22 + 1; j++) {
                newPos = newPos.offset(
                        randomSource.nextIntBetweenInclusive(-1, 1),
                        0,
                        randomSource.nextIntBetweenInclusive(-1, 1)
                );
            }
            newPos = newPos.offset(0, randomSource.nextIntBetweenInclusive(-1, 1), 0);
            final BlockPos below = newPos.below();
            if (level.getBlockState(below).is(Blocks.SCULK)) {
                if (level.getBlockState(newPos).isAir()) {
                    level.setBlock(newPos, ItsAlive.SCULK_TENDRILS.get().defaultBlockState(), 1 | 2);
                    successCounter++;
                } else if (level.getBlockState(newPos).is(ItsAlive.SCULK_TENDRILS)) {
                    level.setBlock(newPos, ItsAlive.TALL_SCULK_TENDRILS.get().defaultBlockState(), 1 | 2);
                    successCounter++;
                }
            }
        }
    }

    @Inject(method = "canPlaceGrowth", at = @At("RETURN"), cancellable = true)
    private static void CheckForBones(LevelAccessor level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            boolean tooth;
            Iterator<BlockPos> iterator = BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 2, 4)).iterator();

            do {
                if (!iterator.hasNext()) {
                    cir.setReturnValue(true);
                    return;
                }

                BlockPos blockpos = iterator.next();
                BlockState blockstate1 = level.getBlockState(blockpos);
                tooth = (blockstate1.is(ItsAlive.SCULK_TOOTH));
            } while (!tooth);

            cir.setReturnValue(false);
        }
    }

    @Inject(method = "getRandomGrowthState", at = @At("RETURN"), cancellable = true)
    private void AddBonesTendrils(LevelAccessor level, BlockPos pos, RandomSource random, boolean isWorldGeneration, CallbackInfoReturnable<BlockState> cir) {
        if (random.nextInt(2) == 0) {
            if ((random.nextInt(3) == 0) || !(level.getFluidState(pos).isEmpty())) {
                BlockState blockState = ItsAlive.SCULK_TOOTH.get().defaultBlockState().setValue(SculkToothBlock.FACING, Direction.UP).setValue(SculkToothBlock.CONNECTION, true);
                cir.setReturnValue(blockState);
            } else {
                cir.setReturnValue(ItsAlive.SCULK_TENDRILS.get().defaultBlockState());
            }
        }
    }
}
