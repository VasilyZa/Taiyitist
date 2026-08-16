package org.bukkit.craftbukkit.v1_20_R1.inventory;

import com.google.common.base.Preconditions;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AnvilMenu;
import org.bukkit.Location;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.AnvilInventory;

public class CraftInventoryAnvil extends CraftResultInventory implements AnvilInventory {

    private final Location location;
    private AnvilMenu container;

    public CraftInventoryAnvil(Location location, Container inventory, Container resultInventory, AnvilMenu container) {
        super(inventory, resultInventory);
        this.location = location;
        this.container = container;
    }

    public CraftInventoryAnvil(InventoryHolder holder, InventoryType type) {
        this(holder, type, type.getDefaultTitle());
    }

    public CraftInventoryAnvil(InventoryHolder holder, InventoryType type, String title) {
        super(new CraftInventoryCustom.MinecraftInventory(holder, type, title),
                new CraftInventoryCustom.MinecraftInventory(holder, type, title));
        this.location = null;
        this.container = null;
    }

    /**
     * 自定义铁砧打开时由 CraftContainer 注入实际的 AnvilMenu
     */
    public void taiyitist$setContainer(AnvilMenu container) {
        this.container = container;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String getRenameText() {
        return container == null ? "" : container.itemName;
    }

    @Override
    public int getRepairCostAmount() {
        return container == null ? 0 : container.repairItemCountCost;
    }

    @Override
    public void setRepairCostAmount(int amount) {
        if (container != null) container.repairItemCountCost = amount;
    }

    @Override
    public int getRepairCost() {
        return container == null ? 0 : container.cost.get();
    }

    @Override
    public void setRepairCost(int i) {
        if (container != null) container.cost.set(i);
    }

    @Override
    public int getMaximumRepairCost() {
        return container == null ? 0 : container.bridge$maximumRepairCost();
    }

    @Override
    public void setMaximumRepairCost(int levels) {
        Preconditions.checkArgument(levels >= 0, "Maximum repair cost must be positive (or 0)");
        if (container != null) container.taiyitist$setMaximumRepairCost(levels);
    }
}
