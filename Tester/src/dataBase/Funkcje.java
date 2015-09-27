package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import log.Log;
import modele.GroupModel;

public class Funkcje {

	DataBase		dataBase;
	ResultSet		result;
	
	public Funkcje(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	public void dodajGrupe(String NazwaGrupy)
	{
		String zapytanie = "INSERT INTO TB__GRUPY_POMIARU(NAZWA_GRUPY, DATA_UTWORZENIA) VALUES (\""+NazwaGrupy+"\",\""+obecnaData()+"\")";
		try{
			dataBase.statement.execute(zapytanie);
			Log.logKomunikat("Dodano now¹ grupê do bazy danych", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
	}
	
	public LinkedList<GroupModel> pobierzListeGrup()
	{
		LinkedList<GroupModel> wynik = new LinkedList<>();
		String zapytanie = "SELECT * FROM TB__GRUPY_POMIARU";
		try{
			result=dataBase.statement.executeQuery(zapytanie);
			while(result.next())
			{
				wynik.add(new GroupModel(result.getInt(1), 
										result.getString(2), 
										result.getString(3)));
				
			}
			Log.logKomunikat("Pobrano liste grup", false);
		}catch(SQLException e){
			Log.logKomunikat("Nie mozna wykonac zapytania "+e.getLocalizedMessage(), true);
		}	
		return wynik;
	}
	
	private String obecnaData()
	{
		String data="";
		Date date = new Date();
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		data = ft.format(date);
		return data;
	}
	
	
}
