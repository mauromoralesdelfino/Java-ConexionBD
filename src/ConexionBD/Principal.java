package ConexionBD;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//Conexion c = new Conexion();
		//c.AbrirConexcion();
		
		Persona a = new Persona("Mauro","Morales Delfino","37762902",25);
		Persona b = new Persona();
		b.setNombre("Qwerty");
		b.setApellido("123");
		b.setDni("12345678");
		b.setEdad(45);
		
		PersonaDAO PD = new PersonaDAO();
		PD.Insertar(a);
		
		
	}

	
	
}
