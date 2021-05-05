package com.jbgames.sandsim.particles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Sand extends Powder{

    public Sand(String type, Vector2 pos, float temperature, Vector2 velocity, float density, boolean solid) {
        super(type, pos, temperature, velocity, density, solid);
    }

    @Override
    public void render(ShapeRenderer sr) {
        sr.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        sr.rect(posToGrid().x, posToGrid().y, 1, 1);
    }
}
