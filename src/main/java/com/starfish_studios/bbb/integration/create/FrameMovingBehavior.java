package com.starfish_studios.bbb.integration.create;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.behaviour.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.starfish_studios.bbb.block.FrameBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class FrameMovingBehavior implements MovementBehaviour {


    @Override
    public void startMoving(MovementContext context) {
//        if (context.state.getValue(FrameBlock.FACING) == Direction.NORTH) return;
//        if (context.state.getValue(FrameBlock.FACING) == Direction.SOUTH) return;
//        if (context.state.getValue(FrameBlock.FACING) == Direction.EAST) return;
//        if (context.state.getValue(FrameBlock.FACING) == Direction.WEST) return;

        Direction facing = context.state.getValue(FrameBlock.FACING);
        Contraption contraption = context.contraption;
        StructureTemplate.StructureBlockInfo state = contraption.getBlocks().get(context.localPos);

        if (state != null) {
        contraption.getBlocks().put(context.localPos, new StructureTemplate.StructureBlockInfo(state.pos(), context.state.setValue(FrameBlock.FACING, facing), state.nbt()));
        }
    }


}

