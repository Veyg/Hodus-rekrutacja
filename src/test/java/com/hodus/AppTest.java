package com.hodus;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void testFindBlockByColor() {
        Block redBlock = new SimpleBlock("red", "wood");
        Block blueBlock = new SimpleBlock("blue", "steel");
        CompositeBlock compositeBlock = new SimpleCompositeBlock("green", "plastic", Arrays.asList(redBlock, blueBlock));
        Wall wall = new Wall(Arrays.asList(redBlock, compositeBlock));

        Optional<Block> foundBlock = wall.findBlockByColor("red");
        assertTrue(foundBlock.isPresent());
        assertEquals("red", foundBlock.get().getColor());

        Optional<Block> notFoundBlock = wall.findBlockByColor("yellow");
        assertFalse(notFoundBlock.isPresent());
    }

    @Test
    void testFindBlocksByMaterial() {
        Block woodBlock = new SimpleBlock("red", "wood");
        Block steelBlock = new SimpleBlock("blue", "steel");
        CompositeBlock compositeBlock = new SimpleCompositeBlock("green", "plastic", Arrays.asList(woodBlock, steelBlock));
        Wall wall = new Wall(Arrays.asList(woodBlock, compositeBlock));

        List<Block> woodBlocks = wall.findBlocksByMaterial("wood");
        assertEquals(1, woodBlocks.size());
        assertEquals("wood", woodBlocks.get(0).getMaterial());
    }

    @Test
    void testCount() {
        Block block1 = new SimpleBlock("red", "wood");
        Block block2 = new SimpleBlock("blue", "steel");
        CompositeBlock compositeBlock = new SimpleCompositeBlock("green", "plastic", Arrays.asList(block1, block2));
        Wall wall = new Wall(Arrays.asList(block1, compositeBlock));

        assertEquals(3, wall.count());
    }
}
