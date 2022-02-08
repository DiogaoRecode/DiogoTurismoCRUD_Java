package dao;

import java.util.List;

import model.Cadastro;

public interface CRUD {
public static void create (Cadastro cadastro) {};
public static void delete(int cadastroId) {};
public static List<Cadastro> find(String pesquisa) {return null;}
public static Cadastro findByPk(int cadastroId) {return null;}
public static void update (Cadastro cadastro) {}
}
