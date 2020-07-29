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


class Sample{
	public static void staticRes(String str) {
		System.out.println("Static resource conveying message : " + str);
	}
	public void instanceRes(String str) {
		System.out.println("Instance resource conveying message : " + str);
	}
}

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingBase greeting = new GreetingBase();
		// greeting.conveyMessage("Hello All");
		
		Greeting greetEmail = new EmailGreeting();
		// greeting.conveyMessage("Hello All", greetEmail);
		greeting.conveyMessage("Hello All", new EmailGreeting());
		
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
		
		// any method from any class can be used for reference 
		 // method refrence
		 Greeting thirdParty = Sample :: staticRes;
		 // greeting.conveyMessage("Hello All", thirdParty);
		 greeting.conveyMessage("Hello All", Sample :: staticRes);
		 Sample S1 = new Sample();
		 greeting.conveyMessage("Hello All", S1 :: instanceRes);
		 // greeting.conveyMessage("Hello All", Sample :: new);
		 
	}

}
