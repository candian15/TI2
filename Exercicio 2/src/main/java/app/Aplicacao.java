package app;

import java.util.List;

import dao.DAO;
import dao.CarrosDAO;
import model.Carros;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		CarroDAO carroDAO = new carroDAO();
		
		System.out.println("\n\n==== Inserir Carro  === ");
		Carros carros = new Carros(1, "GS29-4444", "palio",'preto');
		if(carrosDAO.insert(carros) == true) {
			System.out.println("Inserção com sucesso -> " + carros.toString());
		}
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Carro(" + carros.getLogin() + "): " + carrosDAO.autenticar("palio", "palio"));
			
	

		System.out.println("\n\n==== Atualizar placa (código (" + carros.getCodigo() + ") === ");
		carros.setPlaca(DAO.toMD5("palio"));
		carrosDAO.update(carros);
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("carro (" + carros.getLogin() + "): " + carrosDAO.autenticar("palio", DAO.toMD5("palio")));		
		
		System.out.println("\n\n==== Invadir carro SQL Injection ===");
		System.out.println("carro (" + carros.getLogin() + "): " + carrosDAO.autenticar("palio", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Mostrar caarros ordenados por código === ");
		carro = carrosDAO.getOrderByCodigo();
		for (Carrps c: carros) {
			System.out.println(c.toString());
		}
		
		System.out.println("\n\n==== Excluir carro (código " + carros.getCodigo() + ") === ");
		carrosDAO.delete(carros.getCodigo());
		
		System.out.println("\n\n==== Mostrar carros ordenados por cadastro === ");
		carros = carrosDAO.getOrderByLogin();
		for (Carros c: carros) {
			System.out.println(c.toString());
		}
	}
}