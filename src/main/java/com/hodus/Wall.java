package com.hodus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

interface Structure {
    Optional<Block> findBlockByColor(String color);
    List<Block> findBlocksByMaterial(String material);
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlocks(blocks, block -> block.getColor().equals(color)).stream().findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return new ArrayList<>(findBlocks(blocks, block -> block.getMaterial().equals(material)));
    }

    @Override
    public int count() {
        return findBlocks(blocks, block -> true).size();
    }

    private Set<Block> findBlocks(List<Block> blocks, Predicate<Block> predicate) {
        Set<Block> result = new HashSet<>();
        for (Block block : blocks) {
            if (predicate.test(block)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                result.addAll(findBlocks(((CompositeBlock) block).getBlocks(), predicate));
            }
        }
        return result;
    }
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
