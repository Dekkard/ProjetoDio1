package dio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

public class Pessoa {
	private @Getter @Setter String nome;
	private @Setter Long cpf;
	private @Getter @Setter Date nascimento;
	private @Getter @Setter String endereco;
	private @Getter @Setter String email;
	
	public Pessoa(){}

	public Pessoa(String nome, Long cpf, Date nascimento, String endereco, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.email = email;
	}
	public String getCpf() {
		String id = String.valueOf(this.cpf);
		if (id.length() < 11)
			id = "0".repeat(11 - id.length()) + id;
		Matcher m = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})").matcher(id);
		if (m.find()) {
			return m.group(1) + "." + m.group(2) + "." + m.group(3) + "-" + m.group(4);
		}
		return null;
	}
	public String toString() {
		return "Nome: "+this.nome+"\nCPF: "+getCpf()+"\nData de Nascimento: "+new SimpleDateFormat("dd/MM/yyyy").format(nascimento)+"\nEndereço: "+this.endereco+"\nE-mail: "+this.email;
	}
}
