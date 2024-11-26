module SoftwaredeCaixaEletronico {
    // Requer a biblioteca JUnit 5 para testes
    requires org.junit.jupiter.api;

    // Exporta os pacotes do software
    exports com.softwareCaixaEletronico;

    // Abre o pacote de testes para o framework JUnit
    opens com.testeSoftwareCaixaEletronico to org.junit.jupiter.api;
}
