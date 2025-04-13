package ru.atomDev.createie.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import ru.atomDev.createie.Createie;

import net.minecraft.world.item.Item;

public class allItems {
    private static final CreateRegistrate REGISTRATE = Createie.registrate();
    static {
        REGISTRATE.setCreativeTab(allCreativeTab.CREATE_IE_CREATIVE_TAB);
    }

    public static final ItemEntry<Item> TEST_ITEM = REGISTRATE.item("test_item",Item::new).register();



    public static void register(){

    }
}
