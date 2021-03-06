package logic;

import java.util.Random;

public class Horse {

	private String name;

	private double speed;
	private double stamina;
	private double luck;
	private int age;
	
	private boolean isInjured;
	private double position;

	public Horse(String n) {
		Random generator = new Random();
		this.isInjured = false;
		this.name = n;
		this.position = 0;
		this.age = generator.nextInt(20) + 5;
		this.speed = generator.nextInt(6) + 5;
		this.stamina = generator.nextInt(9) + 2;
		this.luck = generator.nextInt(9) + 2;
	}

	public double getPosition() {
		return this.position;
	}

	public double getSpeed() {
		return this.speed;
	}

	public double getStamina() {
		return this.stamina;
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

	public boolean getIsInjured() {
		return this.isInjured;
	}

	@Override
	public String toString() {
		return this.name;
	}
	

	private void gotInjured() {
		this.isInjured = true;
		this.speed = 1;
	}

	// ///////////////////Nowe metody, przeprowadzam całą logikę ruchu do konia:

	private double computeStaminaMuliplier(double totalDistance) {
		// Obliczamy mnożnik dystansu
		double distance = this.getPosition() / totalDistance;
		double staminaMultiplier = 1;

		if ((distance > 0.5) && (this.getStamina() < 9)) {

			if ((this.getStamina() > 6) && (distance > 0.75)) {
				staminaMultiplier = 0.7;
			}

			else if ((this.getStamina() > 4)
					&& (this.getStamina() < 6)) {
				staminaMultiplier = 0.7;
			}

			else if ((this.getStamina() < 4)) {
				staminaMultiplier = 0.5;
			}

		}
		return staminaMultiplier;
	}

	private boolean ifGetInjured() {
		if ((this.getAge() > 15) && (this.getLuck() < 5)
				&& (new Random().nextInt(100) == 5)) {
			return true;
		}
		
		return false;
	}

	public void doMove(double totalDistance) {

		double staminaMultiplier = computeStaminaMuliplier(totalDistance);
		
		if(ifGetInjured())
			this.gotInjured();
		
		
		double newPosition = this.getPosition()
				+ (this.getSpeed() / 10.0) * staminaMultiplier; // TODO 1
																		// zamienic
																		// na
																		// warunek...
		this.position = newPosition;

	}
}
