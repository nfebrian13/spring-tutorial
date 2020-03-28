package belajar.spring.aop;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class AuditLogAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		Object hasil = method.proceed();
		Date sekarang = new Date();
		
		System.out.println("Method " + method.getMethod().getName() + " dijalankan pada waktu " + sekarang);
		System.out.println();
		
		return hasil;
	}

}
