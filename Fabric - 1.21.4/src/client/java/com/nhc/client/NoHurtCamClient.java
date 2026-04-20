package com.nhc.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class NoHurtCamClient implements ClientModInitializer {

	public static boolean toggledOn = true;

	@Override
	public void onInitializeClient() {
		System.out.println("[NoHurtCam] Enabled");

		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			dispatcher.register(literal("nohurtcam")
					.executes(context -> {
						toggledOn = !toggledOn;
						String status = toggledOn ? "§aENABLED" : "§cDISABLED";
						context.getSource().sendFeedback(
								Text.literal("§e[NoHurtCam] §f" + status)
						);
						return 1;
					})
			);
		});
	}
}