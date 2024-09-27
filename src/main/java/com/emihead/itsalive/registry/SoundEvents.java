package com.emihead.itsalive.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "itsalive");

    // All vanilla sounds use variable range events.
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOTH_BRUSH = SOUND_EVENTS.register(
            "block.tooth_brush", // must match the resource location on the next line
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("itsalive", "block.tooth_brush"))
    );
}