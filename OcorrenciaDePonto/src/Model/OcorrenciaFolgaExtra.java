package Model;

import java.util.Date;

public class OcorrenciaFolgaExtra extends Ocorrencia{
	
	
	private Date dataFolga;
	
 	public OcorrenciaFolgaExtra() {
 		super.tipo = 2;//Define o tipo como Folga Extra
 	}

	@Override
	public boolean persistir() {
		// implementar código para gravar no banco
		return false;
	}
	
	public Date getDataFolga() {
		return dataFolga;
	}
	
	public void setDataFolga(Date dataFolga) {
		this.dataFolga = dataFolga;
	}
}
