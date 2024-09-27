package com.emihead.itsalive.mixin;

import com.emihead.itsalive.ItsAlive;
import com.emihead.itsalive.block.SculkToothBlock;
import com.emihead.itsalive.registry.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrushItem.class)
public abstract class BrushMixin extends Item {

    @Shadow protected abstract HitResult calculateHitResult(Player player);

    protected BrushMixin(Item.Properties properties) {
        super(properties);
    }
    @Inject(method = "useOn", at = @At("RETURN"), cancellable = true)
    public void BrushTeeth(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
            if (level.getBlockState(pos).is(ItsAlive.SCULK_TOOTH)) {
                BlockState blockState = level.getBlockState(pos);
                blockState = ItsAlive.BRUSHED_SCULK_TOOTH.get().defaultBlockState()
                        .setValue(SculkToothBlock.FACING, blockState.getValue(SculkToothBlock.FACING))
                        .setValue(SculkToothBlock.WATERLOGGED, blockState.getValue(SculkToothBlock.WATERLOGGED))
                        .setValue(SculkToothBlock.CONNECTION, blockState.getValue(SculkToothBlock.CONNECTION));
                level.setBlock(pos, blockState, 1 | 2);
                RandomSource randomsource = level.getRandom();
                level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.TOOTH_BRUSH.get(), SoundSource.BLOCKS, 1.0F, randomsource.nextFloat() * 0.4F + 0.8F);
                for (int i = 0; i < 10; i++) {
                    level.addParticle(
                            ParticleTypes.WAX_OFF,
                            (double)pos.getX() + (double)randomsource.nextFloat(),
                            (double)pos.getY() + (double)randomsource.nextFloat(),
                            (double)pos.getZ() + (double)randomsource.nextFloat(),
                            0,
                            0,
                            0
                    );
                }
            }
        }
        cir.setReturnValue(InteractionResult.CONSUME);
    }

}
