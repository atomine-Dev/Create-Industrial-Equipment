package ru.atomDev.createie.registry;

import com.simibubi.create.Create;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ru.atomDev.createie.Createie;

public class allCreativeTab {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Createie.MODID);

    // ПОХУЙ С ЭТИМ ЕЩЕ РАЗБИРАТЬСЯ НАДО БУДЕТ
    public static final RegistryObject<CreativeModeTab> CREATE_IE_CREATIVE_TAB = REGISTER.register(
            "create_ie_creative_tab",
            ()-> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.createie.base"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(()->allItems.TEST_ITEM.asStack())
                    //ОСОБЕННО С ЭТОЙ БЛЯДЬЮ, В CREATE ПОД НЕЕ ОТДЕЛЬНАЯ ФУНКЦИЯ НАПИСАНА, КРЧ БУДУ ДЕЛАТЬ ПОТОМ
                    .displayItems((params, output) -> {
                        output.accept(allItems.TEST_ITEM.get());
                    })
                    .build());


    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }

}
