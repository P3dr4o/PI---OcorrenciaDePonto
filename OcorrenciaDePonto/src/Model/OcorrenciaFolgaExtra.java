package Model;



public class OcorrenciaFolgaExtra extends Ocorrencia{
	
	
	
	
 	public OcorrenciaFolgaExtra() {
 		super.tipo = 2;//Define o tipo como Folga Extra
 	}

	@Override
	public boolean persistir() {
		// implementar código para gravar no banco
		return false;
	}
}
