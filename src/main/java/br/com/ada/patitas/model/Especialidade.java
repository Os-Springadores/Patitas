package br.com.ada.patitas.model;


public enum Especialidade {

    MEDICINA_GERAL(Servico.ATENDIMENTO_CLINICO),
    EMERGENCIA(Servico.ATENDIMENTO_EMERGENCIAL),
    CIRURGIA_GERAL(Servico.CIRURGIA),
    CARDIOLOGIA(Servico.ESPECIALIDADES),
    DERMATOLOGIA(Servico.ESPECIALIDADES),
    NEUROLOGIA(Servico.ESPECIALIDADES),
    ONCOLOGIA(Servico.ESPECIALIDADES);

    private Servico[] servicos;

    Especialidade(Servico... servicos) {

        this.servicos = servicos;
    }

    public boolean contem(Servico servico) {
        for (Servico s : servicos) {
            if (s.equals(servico))
                return true;
        }
        return false;
    }

    public static Especialidade fromString(String especialidade) {
        for (Especialidade e : values()) {
            if (e.name().equalsIgnoreCase(especialidade)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + especialidade);
    }
}