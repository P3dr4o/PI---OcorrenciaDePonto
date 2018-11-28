package Model;

import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;

public class OcorrenciaHoraExtra extends Ocorrencia{
	
	private Time horasExtras;
	private boolean pagar;
	
	public OcorrenciaHoraExtra() {
		
	}
	
	public OcorrenciaHoraExtra(Time horasExtras, boolean pagar) {
		setHorasExtras(horasExtras);
		setPagar(pagar);
		super.tipo = 3;//3 representa o tipo HORAS EXTRAS
	}
	
	
	
	public Time getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(Time horasExtras) {
		this.horasExtras = horasExtras;
	}

	public boolean isPagar() {
		return pagar;
	}

	public void setPagar(boolean pagar) {
		this.pagar = pagar;
	}

	@Override
	public boolean persistir() {
		// implementar código para gravar no banco
		return false;
	}

	

}
