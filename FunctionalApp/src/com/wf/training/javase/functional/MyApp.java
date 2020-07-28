package com.wf.training.javase.functional;

class GreetingBase{
	/*public void conveyMessage(String message) {
		// convey on console
		System.out.println(message);
		if() {} // console
		if() {} // email
		if() {} // sms
	}*/
	
	// add a new method to convey message over email
	
	// single method to support all dest
	// allows to inject any new functionality
	public void conveyMessage(String message, Greeting greeting) {
		greeting.sendGreeting(message);
	}
}

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingBase greeting = new GreetingBase();
		// greeting.conveyMessage("Hello All");
		
		Greeting greetEmail = new EmailGreeting();
		greeting.conveyMessage("Hello All", greetEmail);
		
		Greeting greetSms = new SmsGreeting();
		greeting.conveyMessage("Hello All", greetSms);
		
		// anonymous class
		greeting.conveyMessage("Hello All", new Greeting() {
			
			@Override
			public void sendGreeting(String message) {
				// TODO Auto-generated method stub
				System.out.println("Send over Twitter : " + message);
			}
		});
		
		// to inject new functionality we need to create a new class implementation
		// inherited with Greeting interface
		
		// Technically new functionality is wrapped in a object
		// requires overheads
		
		// we want pure functionality to be injected
		/*greeting.conveyMessage("Hello All", 
			public void sendGreeting(String message) {
				// TODO Auto-generated method stub
				System.out.println("Send over Twitter : " + message);
			}
		);*/
		
		// <refrences> = <object> //already
		// we might need something from lang
		// a new datatype from lang that can refer to function
		// <refrence> = <function>
		// lang provided this feature in interface
		/*Greeting greetTwitter = public void sendGreeting(String message) {
					// TODO Auto-generated method stub
					System.out.println("Send over Twitter : " + message);
				}*/
		// syntax to define pure functionality would change (lambdas expression)
		/*Greeting greetNetwork = message -> {
			// TODO Auto-generated method stub
			System.out.println("Send over Network : " + message);
		};*/
		
		// Simplified
		Greeting greetNetwork = message -> 	System.out.println("Send over Network : " + message);
				
		 greeting.conveyMessage("Hello All", greetNetwork);
		
		// inject functionality directly
		 greeting.conveyMessage("Hello All", message -> System.out.println("Send over Custom : " + message));
		
	}

}
