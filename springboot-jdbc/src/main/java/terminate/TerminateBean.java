package terminate;

import javax.annotation.PreDestroy;

public class TerminateBean {
	
	@PreDestroy
	public void perDestroy() {
		System.out.println("TerminalBean is destroyed");
	}
}
