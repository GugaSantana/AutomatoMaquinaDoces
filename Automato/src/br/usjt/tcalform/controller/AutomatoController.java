package br.usjt.tcalform.controller;

import br.usjt.tcalform.service.*;

public class AutomatoController {
	
	Automato auto = new Automato();
	
	//adiciona valor a pilha 
	public void adcValorController(int valor)
	{
		auto.adcValor(valor);
	}
	
	//devolve todo o valor acumulado na pilha
	public int devValorController()
	{
		return auto.devValor();
	}
	
	//realiza o pedido de acordo com a op��o do doce(String: "a", "b" ou "c")
	public int rlzCompraController(String opcao)
	{
		return auto.rlzCompra(opcao);
	}
	
	//controle para desbloqueio das teclas, de acordo com o valor acumulado na pilha
	public int ctrlValPilha()
	{
		int valTemp = auto.getValPilha();
		int numOpcoes = 0;
		
		if(valTemp > 0 && valTemp < 6)//ativa apenas o bot�o de devolu��o
		{
			numOpcoes = 1;
		}
		else if(valTemp == 6)//ativa os bot�es de: devolu��o e doce "a"
		{
			numOpcoes = 2;
		}
		else if(valTemp == 7)//ativa os bot�es de: devolu��o, doce "a" e "b"
		{
			numOpcoes = 3;
		}
		else if(valTemp >= 8)//ativa os bot�es de: devolu��o e doce "a", "b" e "c"
		{
			numOpcoes = 4;
		}
		
		return numOpcoes;
	}
	
	public int getValPilha()
	{
		return auto.getValPilha();
	}
	
}
