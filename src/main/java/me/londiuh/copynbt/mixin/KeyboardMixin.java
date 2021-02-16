package me.londiuh.copynbt.mixin;

import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Keyboard.class)
public class KeyboardMixin {
	@ModifyVariable(method = "copyLookAt(ZZ)V", at = @At("HEAD"), ordinal = 0)
	private boolean injected(boolean bl) {
		// if hasPermissionLevel(2) returns false F3+i won't show full block/entity data
		// so I force the first func parameter to true
		return true;
	}
}
