package com.starfish_studios.bbb;

import eu.midnightdust.lib.config.MidnightConfig;

public class BBBConfig extends MidnightConfig {
    @Entry(category = "text") public static boolean disableShiftTooltips = false;
    @Entry(category = "text") public static boolean alwaysShowFrameHitboxes = false;
    @Entry(category = "text") public static boolean disableFrameCrouchHitbox = false;
}
