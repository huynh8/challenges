package com.example.animation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticleAnimationTest {

    ParticleAnimation particleAnimation;

    @BeforeEach
    void setUp() {
        particleAnimation = new ParticleAnimation();
    }

    @DisplayName("given a particle that only moves right, return list of locations at each unit of time")
    @Test
    void animate_onlyRight() {
        int speed = 2;
        String init = "..R....";

        String[] locations = particleAnimation.animate(speed, init);

        assertEquals(locations.length, 4);
        assertEquals("..X....", locations[0]);
        assertEquals("....X..", locations[1]);
        assertEquals("......X", locations[2]);
        assertEquals(".......", locations[3]);
    }

    @DisplayName("given particles moving left and right, return list of locations at each unit of time")
    @Test
    void animate() {
        int speed = 3;
        String init = "RR..LRL";

        String[] locations = particleAnimation.animate(speed, init);

        assertEquals(locations.length, 4);
        assertEquals("XX..XXX", locations[0]);
        assertEquals(".X.XX..", locations[1]);
        assertEquals("X.....X", locations[2]);
        assertEquals(".......", locations[3]);
    }

    @DisplayName("given particles that move through each other return list of locations at each unit of time")
    @Test
    void animate_passThrough() {
        int speed = 2;
        String init = "LRLR.LRLR";

        String[] locations = particleAnimation.animate(speed, init);

        assertEquals(locations.length, 5);
        assertEquals("XXXX.XXXX", locations[0]);
        assertEquals("X..X.X..X", locations[1]);
        assertEquals(".X.X.X.X.", locations[2]);
        assertEquals(".X.....X.", locations[3]);
        assertEquals(".........", locations[4]);

    }

    @DisplayName("given particles that move fast, return list of locations where all particles move outside range after one step")
    @Test
    void animate_fast() {
        int speed = 10;
        String init = "RLRLRLRLRL";

        String[] locations = particleAnimation.animate(speed, init);

        assertEquals(locations.length, 2);
        assertEquals("XXXXXXXXXX", locations[0]);
        assertEquals("..........", locations[1]);
    }

    @DisplayName("given no particles, return only inital empty location")
    @Test
    void animate_empty() {
        int speed = 1;
        String init = "...";

        String[] locations = particleAnimation.animate(speed, init);

        assertEquals(locations.length, 1);
        assertEquals("...", locations[0]);
    }

    @DisplayName("given many slow particles moving left and right, return list of locations at each unit of time")
    @Test
    void animate_manyAndSlow() {
        int speed = 1;
        String init = "LRRL.LR.LRR.R.LRRL.";

        String[] locations = particleAnimation.animate(speed, init);

        assertEquals(locations.length, 19);
        assertEquals("XXXX.XX.XXX.X.XXXX.", locations[0]);
        assertEquals("..XXX..X..XX.X..XX.", locations[1]);
        assertEquals(".X.XX.X.X..XX.XX.XX", locations[2]);
        assertEquals("X.X.XX...X.XXXXX..X", locations[3]);
        assertEquals(".X..XXX...X..XX.X..", locations[4]);
        assertEquals("X..X..XX.X.XX.XX.X.", locations[5]);
        assertEquals("..X....XX..XX..XX.X", locations[6]);
        assertEquals(".X.....XXXX..X..XX.", locations[7]);
        assertEquals("X.....X..XX...X..XX", locations[8]);
        assertEquals(".....X..X.XX...X..X", locations[9]);
        assertEquals("....X..X...XX...X..", locations[10]);
        assertEquals("...X..X.....XX...X.", locations[11]);
        assertEquals("..X..X.......XX...X", locations[12]);
        assertEquals(".X..X.........XX...", locations[13]);
        assertEquals("X..X...........XX..", locations[14]);
        assertEquals("..X.............XX.", locations[15]);
        assertEquals(".X...............XX", locations[16]);
        assertEquals("X.................X", locations[17]);
        assertEquals("...................", locations[18]);

    }
}