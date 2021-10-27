//this project relies heavily on the work by the fine folks who made Pi4J possible
//as well as github user wheerdam's project https://github.com/wheerdam/linuxjoy
//im sorry, this probably isnt how to attribute but there it is 
//excuse my horrible cludged together code im just a lowly github copy paster 
// sn

package pitest;

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
import org.bbi.linuxjoy.*;



public class main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("IM ALIVE");

// test for joystick
JoyFactory.enumerate();

LinuxJoystick j = JoyFactory.get(0);
LinuxJoystick k = JoyFactory.get(1);
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




if(j != null) {
	System.out.println("found joystick");
	j.startPollingThread(5); // sleep for 5 ms between polls
	j.setCallback(new EventCallbackHandlerleft());
}
if(k != null) {
	System.out.println("found other joystick");
	k.startPollingThread(5); // sleep for 5 ms between polls
	k.setCallback(new EventCallbackHandlerright());
}



//create gpio controller instance


do {
System.out.println("blink loop");
 
try {
	TimeUnit.SECONDS.sleep(1);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}while(true);

	}

}
