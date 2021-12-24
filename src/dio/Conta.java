package dio;

import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

public class Conta extends Pessoa {
	private static Integer ID_SIZE = 7;
	private @Getter @Setter Integer agencia;
	private Integer id;
	private @Getter Double saldo;

	public Conta() {
		super();
		this.saldo = 0.0;
		setId();
	}

	public Conta(Integer agencia) {
		super();
		this.agencia = agencia;
		this.saldo = 0.0;
		setId();
	}

	public Conta(String nome, Long cpf, Date nascimento, String endereco, String email, Integer agencia) {
		super(nome, cpf, nascimento, endereco, email);
		this.agencia = agencia;
		this.saldo = 0.0;
		setId();
	}

	private void setId() {
		String id = "";
		for (int i = 0; i < ID_SIZE; i++) {
			id += Math.abs(new Random().nextInt() % 9);
		}
		this.id = Integer.valueOf(id);
	}

	public String getId() {
		String id = String.valueOf(this.id);
		if (id.length() < ID_SIZE)
			id = "0".repeat(ID_SIZE - id.length()) + id;
		Matcher m = Pattern.compile("((\\d{3})*)(\\d{1})").matcher(id);
		if (m.find()) {
			String id_f = m.group(1);
			int g = m.groupCount();
			for(int i=2;i<g;i++) {
				id_f += "."+m.group(i);
			}
			return id_f + "-" + m.group(g);
		}
		return null;
	}

	public void deposito(Double valor) {
		this.saldo += valor;
	}

	public void saque(Double valor) {
		if (valor > this.saldo)
			System.out.println("Valor de saque indisponível, favor, verifique seu saldo.");
		else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso.");
		}
	}

	public void tranferência(Conta cliente, Double valor) {
		if (valor > this.saldo)
			System.out.println("Valor para tranferência indisponível, favor, verifique seu saldo.");
		else {
			this.saldo -= valor;
			cliente.deposito(valor);
			System.out.println("Transferência realizada com sucesso.");
		}
	}
	public String toString() {
		return "Cliente:\n"+super.toString()+"\nAgência: "+this.agencia+"\nNúmero da Conta: "+getId()+"\nSaldo atual: R$ "+ String.format("%,.2f", this.saldo);
	}
}
