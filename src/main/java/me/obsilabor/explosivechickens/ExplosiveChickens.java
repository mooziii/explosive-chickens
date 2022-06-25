package me.obsilabor.explosivechickens;

import me.obsilabor.explosivechickens.entity.ExplosiveChickenEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.ChickenEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExplosiveChickens implements ModInitializer, ClientModInitializer {
    public static final EntityType<ExplosiveChickenEntity> EXPLOSIVE_CHICKEN_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("explosivechickens", "explosive_chicken"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ExplosiveChickenEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build()
    );
    public static final Item EXPLOSIVE_CHICKEN_SPAWN_EGG = new SpawnEggItem(EXPLOSIVE_CHICKEN_ENTITY, 16731726, 16777215, new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(EXPLOSIVE_CHICKEN_ENTITY, ChickenEntity.createChickenAttributes());
        Registry.register(Registry.ITEM, new Identifier("explosivechickens", "explosive_chicken_spawn_egg"), EXPLOSIVE_CHICKEN_SPAWN_EGG);
    }

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EXPLOSIVE_CHICKEN_ENTITY, ChickenEntityRenderer::new);
    }
}
