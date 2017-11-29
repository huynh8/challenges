package com.example.animation;

import java.util.Scanner;

public class AnimationApplication {
    static ParticleAnimation particleAnimation = new ParticleAnimation();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter speed: ");
            int speed = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter initial location of particles: ");
            String init = scanner.nextLine();
            String[] animation = particleAnimation.animate(speed, init);
            for (String location : animation) {
                System.out.print(location);
                Thread.sleep(350);
                for (int i = 0; i < location.length(); i++) {
                    System.out.print("\b");
                }
            }
            System.out.print("Do you want to quit? ");
            String exitConfirmation = scanner.nextLine().toLowerCase();
            if (exitConfirmation.contains("y")) {
                System.exit(0);
            }
        }
    }
}
