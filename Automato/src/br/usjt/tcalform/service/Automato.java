package br.usjt.tcalform.service;

import br.usjt.tcalform.model.*;

public class Automato {
	
	Pilha pilha = new Pilha();
	
	//adiciona uma nova quantia à pilha 
	public void adcValor(int valor)
	{
		pilha.setPilha(valor + pilha.getPilha());
	}
	
	//devolve todo o valor que está contido na pilha
	public int devValor()
	{
		int valTemp = pilha.getPilha();
		pilha.setPilha(0);
		return valTemp;
	}
	
	//realiaza a compra e retorna o valor restante da pilha
	public int rlzCompra(String opcao)
	{
		int valTemp = 0;
		
		if(opcao.equals("A"))
		{
			pilha.setPilha(pilha.getPilha() - 6);
			valTemp = pilha.getPilha();
		}
		else if(opcao.equals("B"))
		{
			pilha.setPilha(pilha.getPilha() - 7);
			valTemp = pilha.getPilha();
		}
		else if(opcao.equals("C"))
		{
			pilha.setPilha(pilha.getPilha() - 8);
			valTemp = pilha.getPilha();
		}
		
		return valTemp;
	}
	
	//busca o atual valor da pilha
	public int getValPilha()
	{
		return pilha.getPilha();
	}
	
}
