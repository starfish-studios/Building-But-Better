package com.starfish_studios.building_but_better.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.IntFunction;

public class BlockBlock extends AbstractBlockBlock implements Equipable {
    public static final MapCodec<BlockBlock> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(BlockBlock.Types.CODEC.fieldOf("type")
                            .forGetter(e -> e.type),propertiesCodec())
                    .apply(instance, BlockBlock::new));
    @Override
    protected MapCodec<BlockBlock> codec() {
        return CODEC;
    }

    public static final int MAX = RotationSegment.getMaxSegmentIndex();
    private static final int ROTATIONS = MAX + 1;
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);

    public BlockBlock(Types type, Properties properties) {
        super(type, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ROTATION, 0));
    }


    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return Shapes.empty();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(ROTATION, RotationSegment.convertToSegment(blockPlaceContext.getRotation()));
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(ROTATION, rotation.rotate(blockState.getValue(ROTATION), ROTATIONS));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.setValue(ROTATION, mirror.mirror(blockState.getValue(ROTATION), ROTATIONS));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
    }


    public enum Types implements StringRepresentable
    {
        STONE(0,"stone"),
        BLACKSTONE(1, "blackstone"),
        DEEPSLATE(2, "deepslate"),
        NETHER_BRICK(3, "nether_brick"),
        SANDSTONE(4, "sandstone"),
        RED_SANDSTONE(5, "red_sandstone"),
        QUARTZ(6, "quartz");

        public static final IntFunction<Types> BY_ID = ByIdMap.continuous(Types::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        public static final Codec<Types> CODEC = StringRepresentable.fromValues(Types::values);
        private final int id;
        private final String name;

        Types(final int id, final String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public static Types byId(int id) {
            return BY_ID.apply(id);
        }

        public String getSerializedName() {
            return this.name;
        }
    }

}
