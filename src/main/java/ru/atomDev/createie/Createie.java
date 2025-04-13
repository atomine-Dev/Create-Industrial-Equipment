package ru.atomDev.createie;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import ru.atomDev.createie.registry.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Createie.MODID)
public class Createie {


    // Define mod id in a common place for everything to reference
    public static final String MODID = "createie";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);




    public Createie() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        allCreativeTab.register(modEventBus);
        allItems.register();


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static CreateRegistrate registrate() {
        if (!STACK_WALKER.getCallerClass().getPackageName().startsWith("ru.atomDev.createie"))
            throw new UnsupportedOperationException("Нет иди нахуй");
        return REGISTRATE;
    }

    public static Logger logger() {
        if (!STACK_WALKER.getCallerClass().getPackageName().startsWith("ru.atomDev.createie"))
            throw new UnsupportedOperationException("Нет иди нахуйX2");
        return LOGGER;
    }
    



}
