package belajar.spring.aop;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class AuditLogAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("Audit log sebelum proceed");
		Object hasil = method.proceed();
		Date sekarang = new Date();

		System.out.println("Method " + method.getMethod().getName() + " dijalankan pada waktu " + sekarang);

		return hasil;
	}

}
