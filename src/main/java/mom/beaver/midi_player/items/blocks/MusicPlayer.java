package mom.beaver.midi_player.items.blocks;

import mom.beaver.midi_player.registry.RegisterSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class MusicPlayer extends BlockWithEntity {
    public static final BooleanProperty POWERED = RedstoneTorchBlock.LIT;

    public MusicPlayer (Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(POWERED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient){
            world.playSound(null, pos, RegisterSounds.FREDDY_KALAS_QUOTE_EVENT, SoundCategory.RECORDS, 1f, 1f);
        }

//        Blocks.JUKEBOX

        return ActionResult.PASS;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(POWERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    @Environment(EnvType.SERVER)
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = state.get(POWERED);
        int power = world.getReceivedRedstonePower(pos);
        if (bl != power >= 1) {
            if (!bl) {
                float pitch = ((float) power / 30) + 0.75f;
                world.playSound(null, pos, RegisterSounds.FREDDY_KALAS_QUOTE_EVENT, SoundCategory.BLOCKS, 0.5f, pitch);
            }
            world.setBlockState(pos, state.cycle(POWERED), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new JukeboxBlockEntity(pos, state);
    }
}