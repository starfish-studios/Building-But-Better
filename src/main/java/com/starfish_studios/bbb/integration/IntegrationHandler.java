package com.starfish_studios.bbb.integration;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.integration.create.CreateCompat;

public class IntegrationHandler {

    public static void init() {
        if (BuildingButBetter.isModLoaded("create")) {
            CreateCompat.setup();
        }
    }
}