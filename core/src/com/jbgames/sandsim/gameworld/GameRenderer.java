package com.jbgames.sandsim.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jbgames.sandsim.particles.Particle;

public class GameRenderer {

    private GameWorld world;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld world) {
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Particle[][] simGrid = world.getSimGrid();
        for (int y = 0; y < simGrid.length; y++) {
            for (int x = 0; x < simGrid[0].length; x++) {
                if (simGrid[y][x] != null) {
                    simGrid[y][x].render(shapeRenderer);
                }
            }
        }
        shapeRenderer.end();
    }
}
