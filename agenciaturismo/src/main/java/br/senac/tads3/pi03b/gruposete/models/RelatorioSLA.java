package br.senac.tads3.pi03b.gruposete.models;

public class RelatorioSLA {

    private String filial;
    private int id_sla;
    private String mensagem;
    private String funcionario;
    private String cargo;
    private String data;
    private int id_func;

    public int getId_SLA() {
        return id_sla;
    }

    public void setId_sla(int id_sla) {
        this.id_sla = id_sla;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public RelatorioSLA() {
    }

}
