/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import br.unicap.poo.clinicaMedica.repository.Repositable;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author aluno
 */
public abstract class Agendamento implements Repositable{
    private final int codigo;
    private Date data;
    private Status status;

    public Agendamento(int codigo, Date data) throws AgendamentoException {
        this.codigo = codigo;
        setData(data);
    }
    @Override
    public int getCodigo() {
        return codigo;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) throws DataInvalidaException {
        Calendar cal, cal2;
        cal2= Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.setTime(data);
        
        if(cal.compareTo(cal2)<0){
            throw new DataInvalidaException("Data inválida");
        }
        
        this.data = data;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int compareTo(Agendamento agendamento){
        if(this.codigo>codigo){
            return 1;
        }else if(this.codigo==codigo){
            return 0;
        }
        
        return -1;
    }
}
