package modele;

import java.util.Date;

public class GroupModel {

	private 		int			idGrupy;
	private 		String 		nazwa;
	private 		Date		dataUtworzenia;
	
	public GroupModel() {
		// TODO Auto-generated constructor stub
	}

	public GroupModel(int id, String nazwa, String data)
	{
		this.idGrupy=id;
		this.nazwa=nazwa;
		this.dataUtworzenia=new Date(data);
	}
	public void setId(int id){
		this.idGrupy=id;
	}
	
	public int getId(){
		return this.idGrupy;
	}
	
	public void setNazwa(String nazwa){
		this.nazwa=nazwa;
	}
	
	public String getNazwa(){
		return this.nazwa;
	}
	
	public void setDataUtworzenia(Date data){
		this.dataUtworzenia=data;
	}
	
	public Date getDataUtworzenia(){
		return this.dataUtworzenia;
	}
}
