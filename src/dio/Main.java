package dio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws ParseException {
		Conta c = new Conta("Fulano",12345678901L, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1991"),"Algumlugarnópolis","fulano@mail.com",123456);
		c.deposito(1000.0);
		System.out.println(c.toString());
	}
}
