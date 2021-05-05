package com.jbgames.sandsim.gameworld;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.jbgames.sandsim.particles.Particle;
import com.jbgames.sandsim.particles.Sand;

import java.awt.*;

public class GameWorld {
    int width, height;
    private Particle[][] simGrid;
    private final Vector2 GRAVITY = new Vector2(0, 1200);

    public GameWorld(float width, float height) {
        this.width = (int)width;
        this.height = (int)height;
        simGrid = new Particle[this.height][this.width];
    }

    public void update(float delta) {
        Particle[][] tempMap = new Particle[height][width];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(simGrid[y][x]!=null) {
                    simGrid[y][x].update(delta, GRAVITY, simGrid);
                }
            }
        }
    }

    public Particle[][] getSimGrid() {
        return simGrid;
    }

    public void onClick(int screenX, int screenY, int pointer) {

        for (int i = Math.max(0, screenY - 10); i < Math.min(simGrid.length, screenY + 10); i++) {
            for (int j = Math.max(0, screenX - 10); j < Math.min(simGrid[0].length, screenX + 10); j++) {
                if (simGrid[i][j] == null) {
                    simGrid[i][j] = new Sand("Normal_SAND", new Vector2(j,i), 0, new Vector2(0,0),1, false);

                }
            }
        }
    }

    public void test() {
        for(int i = 0; i < simGrid.length; i++) {
            for(int j = 0; j < simGrid[0].length; j++) {
                System.out.print(simGrid[i][j] == null?" ":1);
            }
            System.out.println();
        }
    }

}
