package Model;

import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;

public class OcorrenciaHoraExtra extends Ocorrencia{
	//private int horas, minutos;//mudar isso, colocar uma variavel para registrar o tempo
	private Time horasExtras;
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
			throw new DateTimeException("A hora informada "+horas+" n�o � um valor v�lido");
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		if (horas >= 0)
			this.minutos = minutos;
		else
			throw new DateTimeException("O minutos informado "+minutos+" n�o � um valor v�lido");
		
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
