package ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class PersonaDAO {
	
	/*
	 *void insertar(Persona)
	 *void Modificar(Persona)
	 *void Eliminar(Persona)
	 *Persona ObtenerById(Long)
	 * List<Personas> ObtenerTodo()
	 * DataAccesObject*/

	public PersonaDAO()
	{}
	
	public void Insertar(Persona p)
	{
		try
		{
			
			Connection c =	Conexion.AbrirConexion();
			//PreparedStatement st = c.prepareStatement("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value ('"+p.nombre+"','"+p.apellido+"','"+p.edad+"','"+p.dni+"')");
			PreparedStatement ps = c.prepareStatement("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value (?,?,?,?)");
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido());
			ps.setInt(3, p.getEdad());
			ps.setString(4, p.getDni());
			ps.execute();
			c.close();
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
	public void Modificar(Persona p)
	{
		try
		{
			
			Connection c =	Conexion.AbrirConexion();
			//PreparedStatement st = c.prepareStatement("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value ('"+p.nombre+"','"+p.apellido+"','"+p.edad+"','"+p.dni+"')");
			PreparedStatement ps = c.prepareStatement("Update ejemplo SET nombre=? AND apellido=? AND edad=? AND dni=? where nombre=?");
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido());
			ps.setInt(3, p.getEdad());
			ps.setString(4, p.getDni());
			ps.setString(5,"Qwerty");
			ps.execute();
			c.close();
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void Eliminar(Persona p)
	{
		try
		{
			
			Connection c =	Conexion.AbrirConexion();
			//PreparedStatement st = c.prepareStatement("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value ('"+p.nombre+"','"+p.apellido+"','"+p.edad+"','"+p.dni+"')");
			//DELETE FROM tutorials_tbl WHERE tutorial_id=3;
			PreparedStatement ps = c.prepareStatement("Delete from ejemplo where nombre=? AND apellido=? AND edad=? AND dni=? ");
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido());
			ps.setInt(3, p.getEdad());
			ps.setString(4, p.getDni());
			ps.execute();
			c.close();
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public Persona ObtenerById(int id)
	{
		Persona p = null;
		try
		{
			
			Connection c =	Conexion.AbrirConexion();
			//PreparedStatement st = c.prepareStatement("Insert into ejemplo(Nombre,Apellido,Edad,Dni) value ('"+p.nombre+"','"+p.apellido+"','"+p.edad+"','"+p.dni+"')");
			//DELETE FROM tutorials_tbl WHERE tutorial_id=3;
			PreparedStatement st = c.prepareStatement("Select * From ejemplo where id=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p = new Persona();
				p.setNombre(rs.getString(1));
				p.setApellido(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setDni(rs.getString(4));
				
				
				
			}
			c.close();
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return p;
	}
	
	public List<Persona> ObtenerTodas()
	{
		List<Persona> pers = new ArrayList<>();
		
		
		try
		{
			
			Connection c =	Conexion.AbrirConexion();
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
			c.close();
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return pers;
	}
	
}
