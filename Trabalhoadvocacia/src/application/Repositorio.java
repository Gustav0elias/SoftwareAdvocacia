package application;

import java.util.ArrayList;






public class Repositorio {

	
	private static ArrayList<Processo> listaProcesso = new ArrayList <Processo>();
	
	
	
	public void inserir (Processo p)
	{
		listaProcesso.add(p);
		
		
  }
	
	public void remover (Processo i) {
		listaProcesso.remove(i);
	}
		

	
	public ArrayList <Processo> getProcesso() {
		return listaProcesso;
	}
	
	
	}
	
