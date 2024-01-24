package mom.beaver.midi_player.registry;

import mom.beaver.midi_player.MidiPlayer;
import mom.beaver.midi_player.items.blocks.MusicPlayer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class RegisterItems {
    public static final MusicPlayer MUSIC_PLAYER_BLOCK = new MusicPlayer(FabricBlockSettings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASS).strength(2.0f, 6.0f).burnable());

    public static Map<String, Item> block_items = new HashMap<>();

    public static void bootstrap() {
        Item[] music_items = {
                registerItemAndBlock("music_player", MUSIC_PLAYER_BLOCK, new FabricItemSettings().rarity(Rarity.UNCOMMON)),
        };

        Registry.register(Registries.ITEM_GROUP, new Identifier(MidiPlayer.MOD_ID, "music_items"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(MUSIC_PLAYER_BLOCK))
                        .displayName(Text.translatable("Music Items"))
                        .entries((context, entries) -> {
                            for (Item item : music_items) {
                                entries.add(item);
                            }
                        }).build()
        );
    }

    private static Item registerItem(String ID, Item item) {
        Registry.register(Registries.ITEM, new Identifier(MidiPlayer.MOD_ID, ID), item);
        return item;
    }

    private static Block registerBlock(String ID, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(MidiPlayer.MOD_ID, ID), block);
        return block;
    }

    private static Item registerItemAndBlock(String ID, Block block, FabricItemSettings itemSettings) {
        Item item = new BlockItem(block, itemSettings);
        block_items.put(ID, item);
        Registry.register(Registries.BLOCK, new Identifier(MidiPlayer.MOD_ID, ID), block);
        Registry.register(Registries.ITEM, new Identifier(MidiPlayer.MOD_ID, ID), item);
        return item;
    }
}