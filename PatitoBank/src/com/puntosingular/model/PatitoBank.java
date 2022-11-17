package com.puntosingular.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PatitoBank {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int opcion = 0;
		String password;
		String nombreTitular;
		String curp;
		int idCuenta;
		double monto;
		Account cuenta = new Account();
		Transaction transaccion = new Transaction();
		List<Account> cuentas = new ArrayList<Account>();
		List<Transaction> transacciones = new ArrayList<Transaction>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		boolean fin = false;
		
		for (;fin == false;) {
			System.out.println("Bienvenidos a PatitoBank");
			System.out.println("Seleccione su opción");
			System.out.println("1.- Crear Cuenta");
			System.out.println("2.- Mostrar Saldo de una cuenta");
			System.out.println("3.- Despositar a cuenta");
			System.out.println("4.- Retirar de cuenta");
			System.out.println("5.- Mostrar todas las cuentas");
			System.out.println("6.- Mostrar historial de transacciones de una cuenta");
			System.out.println("7.- Mostrar todas las cuentas - numero de cuenta");
			System.out.println("8.- Salir");
			System.out.println("opcion : ");
			opcion = Integer.parseInt (br.readLine());
			
			if (opcion==1) {
				System.out.println("Ingrese el nombre del titular: ");
				nombreTitular = br.readLine();
				System.out.println("Ingresa la curp del titular");
				curp = br.readLine();
				System.out.println();
				cuenta = new Account();
				cuenta.generateAccount();
				cuenta.setTitularName(nombreTitular);
				cuenta.setCurp(curp);
				cuentas.add(cuenta);
				System.out.println("la cuenta ha sido creada");
				System.out.println("Cuenta: " + cuenta.getIdAccount() + "  |  Titular: " + cuenta.getTitularName() +"  |  CURP :" + cuenta.getCurp());
				System.out.println();
			}else if (opcion==2){
				System.out.println("Porfavor ingrese la cuenta: ");
				cuenta = new Account();
				idCuenta = Integer.parseInt (br.readLine());
				//cuenta.setIdAccount(idCuenta);
				for (int i = 0; i < cuentas.size(); i++) {
					if (cuentas.get(i).getIdAccount() == idCuenta) {
						cuenta.setIdAccount(idCuenta);
						cuenta.setCurp(cuentas.get(i).getCurp());
						cuenta.setTitularName(cuentas.get(i).getTitularName());
					}
				}
				System.out.println("--------------------cuenta-------------------");
				System.out.println("Cuenta: "+cuenta.getIdAccount()+"  |  Nombre: "+cuenta.getTitularName()+"  |  Saldo: "+ cuenta.calculateAmount(transacciones));
				System.out.println();
			}else if (opcion==3){
				System.out.println("************DEPOSITAR************");
				System.out.println("Porfavor ingrese la cuenta: ");
				idCuenta = Integer.parseInt (br.readLine());
				System.out.println("Porfavor ingrese la cantidad: ");
				monto = Double.parseDouble(br.readLine());
				transaccion = new Transaction();
				transaccion.createTransaction(idCuenta, "Deposito", monto);
				transacciones.add(transaccion);
				System.out.println("*****DEPOSITO REALIZADO*****\"");
				System.out.println();
				
			}else if (opcion==4){
				System.out.println("************RETIRAR************");
				System.out.println("Porfavor ingrese la cuenta: ");
				idCuenta = Integer.parseInt (br.readLine());
				System.out.println("Porfavor ingrese la cantidad: ");
				monto = Double.parseDouble(br.readLine());
				transaccion = new Transaction();
				transaccion.createTransaction(idCuenta, "Retiro", monto);
				transacciones.add(transaccion);
				System.out.println("*****RETIRO REALIZADO*****\"");
				System.out.println();
			}else if (opcion==5){
				System.out.println("Por favor ingrese la contraseña : ");
				password = br.readLine();
				if (cuenta.verifyPasssword(password)==true) {
					System.out.println("************CUENTAS************");
					
					for (int i = 0; i < cuentas.size(); i++) {
						cuenta = new Account();
						cuenta.setIdAccount(cuentas.get(i).getIdAccount());
						System.out.println(cuentas.get(i).getTitularName() + " Balance : " + cuenta.calculateAmount(transacciones) );
						System.out.println();
					}
				}else {
					System.out.println("Lo sentimos la contraseña es incorrecta, no puede ver las cuentas");
					System.out.println();
				}
				System.out.println("");
			}else if (opcion==6){
				System.out.println("Por favor ingrese la contraseña : ");
				password = br.readLine();
				
				if (cuenta.verifyPasssword(password)==true) {
					System.out.println("************HISTORIAL DE TRANSACCIONES************");
					//cuenta = new Account();
					System.out.println("Porfavor ingrese la cuenta: ");
					idCuenta = Integer.parseInt (br.readLine());
					for (int i = 0; i < transacciones.size(); i++) {
						if (transacciones.get(i).getIdAccount() == idCuenta) {
							System.out.println("Monto: "+transacciones.get(i).getAmount() + "  |  Fecha : " + transacciones.get(i).getDate() + "  |  Concepto: " + transacciones.get(i).getConcept());
						}
					}
					System.out.println();
				}else {
					System.out.println("Lo sentimos la contraseña es incorrecta, no puede ver las cuentas");
					System.out.println();
				}
				
			}else if (opcion==7) {
				System.out.println("--------------------cuentas-------------------");
				for (int i = 0; i < cuentas.size(); i++) {
					System.out.println(cuentas.get(i).getIdAccount());
					System.out.println(cuentas.get(i).getTitularName());
					System.out.println(cuentas.get(i).getCurp());
					System.out.println();
				}
				System.out.println();
//				System.out.println("--------------------Transacciones-------------------");
//				for (int i = 0; i < transacciones.size(); i++) {
//					System.out.println(transacciones.get(i).getDate());
//					System.out.println(transacciones.get(i).getAmount());
//					System.out.println(transacciones.get(i).getConcept());
//					System.out.println(transacciones.get(i).getIdAccount());
//					System.out.println();
//				}
			}else if (opcion==8) {
				System.out.println("Saliendo de Patito Bank ......................");
				System.out.println("No me quiero ir señor Stark ......................");
				fin = true;
			}
		}
	}
}
