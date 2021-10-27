package pitest;

import org.bbi.linuxjoy.LinuxJoystick;
import org.bbi.linuxjoy.LinuxJoystickEvent;
import org.bbi.linuxjoy.LinuxJoystickEventCallback;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinDirection;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.PinEventType;
import java.util.concurrent.TimeUnit;


public class EventCallbackHandlerright implements LinuxJoystickEventCallback {
	final GpioController gpio = GpioFactory.getInstance();

	GpioPinDigitalOutput AGS8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS9 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);   // PIN NUMBER
	
	
	
	//joystick button assignments
	// left as follows:
	// up = 2
	// dn = 1
	// L = 0
	// R = 3
	// sel = 8
	//ltrig = 15
	// right as follows:
	// a = 0
	// b = 2
	// start = 9
	// rtrig  = 15

	
	@Override
	public void callback(LinuxJoystick arg0, LinuxJoystickEvent ev) {
		
		//set pins low before 
				AGS8.low();
				AGS9.low();
				AGS10.low();
				AGS11.low();
				AGS12.low();
				AGS13.low();
				

				if (ev.isButtonDown()== 0)
				{
					AGS8.high();
					System.out.println("A button pressed AGS8 set high");
				}
				if (ev.isButtonDown()== 2)
				{
					AGS9.high();
					System.out.println("B button pressed AGS9 set high");
				}
				if (ev.isButtonDown()== 9)
				{
					AGS10.high();
					System.out.println("start button pressed AGS10 set high");
				}
				if (ev.isButtonDown()== 15)
				{
					AGS11.high();
					System.out.println("Rtrig button pressed AGS11 set high");
				}
				
				
				
			}
}

	


