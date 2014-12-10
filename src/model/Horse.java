package model;

import java.util.Random;

public class Horse {

	private String name;

	private double speed;
	private double strength;
	private double luck;
	private int age;
	private boolean isInjured;
	private double position;

	private HorseNames horseNames = HorseNames.getInstance();

	public Horse() {
		Random generator = new Random();
		this.isInjured = false;
		this.name = horseNames.generateName();
		this.position = 0;
		this.age = generator.nextInt(20) + 5;
		this.speed = generator.nextInt(6) + 5;
		this.strength = generator.nextInt(9) + 2;
		this.luck = generator.nextInt(9) + 2;
	}

	public double getPosition() {
		return this.position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double s) {
		this.speed = s;
	}

	public double getStrength() {
		return this.strength;
	}

	public double getLuck() {
		return this.luck;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public void gotInjured() {
		this.isInjured = true;
		this.speed = 1;
	}

	public boolean getIsInjured() {
		return this.isInjured;
	}

	@Override
	public String toString() {
		return this.name;
	}

	// ///////////////////Nowe metody, przeprowadzam całą logikę ruchu do konia:

	private double computeStrengthMuliplier(double totalDistance) {
		// Obliczamy mnożnik dystansu
		double distance = this.getPosition() / totalDistance;
		double strengthMultiplier = 1;

		if ((distance > 0.5) && (this.getStrength() < 9)) {

			if ((this.getStrength() > 6) && (distance > 0.75)) {
				strengthMultiplier = 0.7;
			}

			else if ((this.getStrength() > 4)
					&& (this.getStrength() < 6)) {
				strengthMultiplier = 0.7;
			}

			else if ((this.getStrength() < 4)) {
				strengthMultiplier = 0.5;
			}

		}
		return strengthMultiplier;
	}

	private boolean czyZlapieKontuzje() {
		// Obliczamy kontuzję:
		if ((this.getAge() > 15) && (this.getLuck() < 5)
				&& (new Random().nextInt(100) == 5)) {
			return true;
		}
		
		return false;
	}

	public void doMove(double totalDistance) {

		double strengthMultiplier = computeStrengthMuliplier(totalDistance);
		
		if(czyZlapieKontuzje())
			this.gotInjured();
		
		
		double newPosition = this.getPosition()
				+ (this.getSpeed() / 10.0) * strengthMultiplier; // TODO 1
																		// zamienic
																		// na
																		// warunek...
		this.setPosition(newPosition);

	}

}
