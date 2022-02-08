package model;

public class Cadastro{
private int Id_cliente;
private String Nome;
private String Cpf;
private String Email;
private String Telefone;


public int getId_cliente() {
	return Id_cliente;
}
public void setId_cliente(int id_cliente) {
	Id_cliente = id_cliente;
}
public String getNome() {
	return Nome;
}
public void setNome(String nome) {
	Nome = nome;
}
public String getCpf() {
	return Cpf;
}
public void setCpf(String cpf) {
	Cpf = cpf;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getTelefone() {
	return Telefone;
}
public void setTelefone(String telefone) {
	Telefone = telefone;
}

@Override
public String toString() {
	return "Cadastro [Id_cliente=" + Id_cliente + ", Nome=" + Nome + ", Cpf=" + Cpf + ", Email=" + Email + ", Telefone="
			+ Telefone + "]";
}

}

