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


public class EventCallbackHandlerleft implements LinuxJoystickEventCallback {
	final GpioController gpio = GpioFactory.getInstance();
	GpioPinDigitalOutput AGS2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, PinState.LOW);   // PIN NUMBER       
	GpioPinDigitalOutput AGS4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.LOW);   // PIN NUMBER
	GpioPinDigitalOutput AGS7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.LOW);   // PIN NUMBER
	
	
	
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
		AGS2.low();
		AGS3.low();
		AGS4.low();
		AGS5.low();
		AGS6.low();
		AGS7.low();
		
		
		
		
		if (ev.isButtonDown()== 2)
		{
			AGS2.high();
			System.out.println("up button pressed AGS2 set high");
		}
		
		if(ev.isButtonDown()==1)
		{
			AGS3.high();
			System.out.println("dn button pressed AGS3 set high");
				}
		if(ev.isButtonDown()==0)
		{
			AGS4.high();
			System.out.println("L button pressed AGS4 set high");
				}
		if(ev.isButtonDown()==3)
		{
			AGS5.high();
			System.out.println("R button pressed AGS5 set high");
				}
		if(ev.isButtonDown()==8)
		{
			AGS6.high();
			System.out.println("sel button pressed AGS6 set high");
				}
		if(ev.isButtonDown()==15)
		{
			AGS7.high();
			System.out.println("Ltrig button pressed AGS7 set high");
				}
		
		
			
	}
}

	


