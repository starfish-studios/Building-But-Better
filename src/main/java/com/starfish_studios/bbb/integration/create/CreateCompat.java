package com.starfish_studios.bbb.integration.create;

import com.simibubi.create.AllMovementBehaviours;
import com.starfish_studios.bbb.registry.BBBTags;

public class CreateCompat {
    public static void setup() {

        FrameMovingBehavior frameMovingBehavior = new FrameMovingBehavior();
        AllMovementBehaviours.registerBehaviourProvider(state -> {
            if (state.is(BBBTags.BBBBlockTags.FRAMES)) {
                return frameMovingBehavior;
            }
            return null;
        });
    }
}