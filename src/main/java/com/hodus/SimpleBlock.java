package com.hodus;
import java.util.List;
public class SimpleBlock implements Block {
    private String color;
    private String material;

    SimpleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}

class SimpleCompositeBlock extends SimpleBlock implements CompositeBlock {
    private List<Block> blocks;

    SimpleCompositeBlock(String color, String material, List<Block> blocks) {
        super(color, material);
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
