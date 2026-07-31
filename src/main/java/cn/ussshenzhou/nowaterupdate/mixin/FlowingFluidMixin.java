package cn.ussshenzhou.nowaterupdate.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author USS_Shenzhou
 */
@Mixin(FlowingFluid.class)
public class FlowingFluidMixin {

    @SuppressWarnings("ConstantValue")
    @Inject(method = "canMaybePassThrough", at = @At("HEAD"), cancellable = true)
    private void noWaterUpdateDisableWaterUpdate(BlockGetter level, BlockPos sourcePos, BlockState sourceState, Direction direction, BlockPos testPos, BlockState testState, FluidState testFluidState, CallbackInfoReturnable<Boolean> cir) {
        if ((Object) this == Fluids.WATER || (Object) this == Fluids.FLOWING_WATER) {
            cir.setReturnValue(false);
        }
        //if ((Object) this instanceof WaterFluid) {
        //    cir.setReturnValue(false);
        //}
    }
}
