package Model;

import java.time.DateTimeException;
import java.util.Date;

public class OcorrenciaHoraExtra extends Ocorrencia{
	private int horas, minutos;
	private boolean pagar;
	
	public OcorrenciaHoraExtra() {
		
	}
	
	public OcorrenciaHoraExtra(int horas, int minutos, boolean pagar) {
		setHoras(horas);
		setMinutos(minutos);
		setPagar(pagar);
		super.tipo = 3;//3 representa o tipo HORAS EXTRAS
	}
	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		if (horas >= 0)
			this.horas = horas;
		else
			throw new DateTimeException("A hora informada "+horas+" não é um valor válido");
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		if (horas >= 0)
			this.minutos = minutos;
		else
			throw new DateTimeException("O minutos informado "+minutos+" não é um valor válido");
		
	}

	public boolean isPagar() {
		return pagar;
	}

	public void setPagar(boolean pagar) {
		this.pagar = pagar;
	}

	

}
