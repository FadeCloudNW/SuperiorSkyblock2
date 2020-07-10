package com.bgsoftware.superiorskyblock.utils.chunks;

import com.bgsoftware.superiorskyblock.wrappers.SBlockPosition;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Objects;

public final class ChunkPosition {

    private String worldName;
    private int x, z;

    private ChunkPosition(String worldName, int x, int z){
        this.worldName = worldName;
        this.x = x;
        this.z = z;
    }

    public Chunk loadChunk(){
        return getWorld().getChunkAt(x, z);
    }

    public World getWorld() {
        return Bukkit.getWorld(worldName);
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChunkPosition that = (ChunkPosition) o;
        return x == that.x &&
                z == that.z &&
                worldName.equals(that.worldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worldName, x, z);
    }

    @Override
    public String toString() {
        return "ChunkPosition{" +
                "world=" + worldName +
                ", x=" + x +
                ", z=" + z +
                '}';
    }

    public static ChunkPosition of(Block block){
        return of(block.getWorld().getName(), block.getX() >> 4, block.getZ() >> 4);
    }

    public static ChunkPosition of(SBlockPosition blockPosition){
        return of(blockPosition.getWorld().getName(), blockPosition.getX() >> 4, blockPosition.getZ() >> 4);
    }

    public static ChunkPosition of(World world, int x, int z){
        return of(world.getName(), x, z);
    }

    public static ChunkPosition of(String worldName, int x, int z){
        return new ChunkPosition(worldName, x, z);
    }

}
