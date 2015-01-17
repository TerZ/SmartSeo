package test;

import java.util.logging.Logger;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class GPIOControl {

	private Logger logger = Logger.getLogger("GPIOControlLogger");

	private GpioController gpio;
	private GpioPinDigitalOutput powerButton;
	private GpioPinDigitalOutput oneCupButton;
	private GpioPinDigitalOutput twoCupButton;

	private GPIOControl() {
		System.out.println("Constructor");
		gpio = GpioFactory.getInstance();
		powerButton = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07,
				"powerButton", PinState.LOW);
		oneCupButton = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14,
				"oneCupButton", PinState.LOW);
		twoCupButton = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11,
				"twoCupButton", PinState.LOW);
	}

	public void pushPowerButton() {
		// push the power button
		powerButton.high();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// release the power button
		powerButton.low();
	}

	public void pushOneCupButton() {
		// push the one cup button
		oneCupButton.high();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// release the one cup button
		oneCupButton.low();
	}

	public void pushTwoCupButton() {
		// push the two cup button
		twoCupButton.high();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// release the two cup button
		twoCupButton.low();
	}
}
