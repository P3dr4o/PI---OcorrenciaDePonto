package Model;

import java.util.Calendar;

public class OcorrenciaFolgaExtra extends Ocorrencia{
	
	
	private Calendar dataFolga;
	
 	public OcorrenciaFolgaExtra() {
 		super.tipo = 2;//Define o tipo como Folga Extra
 	}

	@Override
	public boolean persistir() {
		// implementar código para gravar no banco
		return false;
	}
	
	public Calendar getDataFolga() {
		return dataFolga;
	}
}
