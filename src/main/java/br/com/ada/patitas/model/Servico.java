package br.com.ada.patitas.model;

public enum Servico {
    ATENDIMENTO_CLINICO("Consulta", "Medicação", "Curativo"),
    ATENDIMENTO_EMERGENCIAL("Primeiros Socorros", "Reanimação", "Estabilização"),
    CIRURGIA("Cirurgia de Castração", "Cirurgia Ortopédica", "Cirurgia Cardíaca", "Cirurgia Oncológica"),
    ESPECIALIDADES("Cardiologia", "Dermatologia", "Neurologia", "Oncologia");

    private String[] tipos;

    Servico(String... tipos) {
        this.tipos = tipos;
    }

    public String[] getTipos() {
        return tipos;
    }
}
