package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Conexion {
	
	public Conexion()
	{}
	
	
	public void AbrirConexcion() throws ClassNotFoundException, SQLException

	{
		try
			{
		List<Persona> pers = new ArrayList<>();
		
				Class.forName("com.mysql.jdbc.Driver");//excepcion si cargamos mal la ruta
				//invocar constructor estatico clase Driver
				//invocado del archivo jar
				//levanta y poner en memoria ram los driver
				
				
				//utiñliuzar drivers para abrir conexion a bd
			Connection c =	DriverManager.getConnection("JDBC:mysql://localhost:3306/test");
				System.out.println("Conectó");
				
				//Statement st = c.createStatement();
				//st.execute("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value ('Jose','Perez',35,'30123456')");
				//PreparedStatement st = c.prepareStatement("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value ('Jose','Perez',35,'30123456')");
				//st.execute();
				
				//si la query usa select, hay que usar execute query, porque select tiene rretorno
				PreparedStatement st = c.prepareStatement("Select * From ejemplo");
				ResultSet rs = st.executeQuery();
				while(rs.next())
				{
					Persona p = new Persona();
					p.setNombre(rs.getString(1));
					p.setApellido(rs.getString(2));
					p.setEdad(rs.getInt(3));
					p.setDni(rs.getString(4));
					
					pers.add(p);
					
				}
				
				  /* for ( TipoARecorrer nombreVariableTemporal : nombreDeLaColección ) {
                       Instrucciones
                      }*/
				
				for(Persona temp : pers)
				{
					System.out.println(temp.toString());
				}
				
			}
		
		catch(Exception ex)
		{ex.printStackTrace();}
		
	}

	public static Connection AbrirConexion() throws ClassNotFoundException, SQLException
	{
		Connection c = null;
		
		try{
			
				Class.forName("com.mysql.jdbc.Driver");
				 c =	DriverManager.getConnection("JDBC:mysql://localhost:3306/test");
				System.out.println("Conectó");
			}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return c;
		
	}
	
	public static void CerrarConexion(Connection c)
	{
		try{
			
			c.close();
			}
		catch(Exception ex)
		   {
			ex.printStackTrace();
		   }
		
	}
}
