package com.example.animation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticleAnimation {
    public String[] animate(int speed, String init) {

        List<Particle> particles = new ArrayList<>();

        StringBuilder currentLocationsBuilder = new StringBuilder();
        StringBuilder emptyParticleBuilder = new StringBuilder();
        for (int i = 0; i < init.length(); i++) {
            if (init.charAt(i) == 'R') {
                Particle particle = Particle.builder().position(i).movingRight(true).build();
                particles.add(particle);
                currentLocationsBuilder.append('X');
            } else if (init.charAt(i) == 'L') {
                Particle particle = Particle.builder().position(i).movingRight(false).build();
                particles.add(particle);
                currentLocationsBuilder.append('X');
            } else {
                currentLocationsBuilder.append('.');
            }
            emptyParticleBuilder.append('.');
        }

        String currentLocations = currentLocationsBuilder.toString();
        String emptyParticleLocation = emptyParticleBuilder.toString();

        List<String> locationsList = new ArrayList<>();
        locationsList.add(currentLocations);
        while (!particles.isEmpty()) {
            currentLocationsBuilder.setLength(0);
            currentLocationsBuilder.append(emptyParticleLocation);
            Iterator<Particle> particleIterator = particles.iterator();
            while (particleIterator.hasNext()) {
                Particle particle = particleIterator.next();
                if (particle.isMovingRight()) {
                    particle.setPosition(particle.getPosition() + speed);
                } else {
                    particle.setPosition(particle.getPosition() - speed);
                }

                if (particle.getPosition() >= 0 && particle.getPosition() < currentLocationsBuilder.length()) {
                    currentLocationsBuilder.setCharAt(particle.getPosition(), 'X');
                } else {
                    particleIterator.remove();
                }
            }
            currentLocations = currentLocationsBuilder.toString();
            locationsList.add(currentLocations);
        }

        return locationsList.toArray(new String[0]);
    }
}
