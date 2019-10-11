package br.com.tratamentovip.core.web.datatype;

public enum UFEnum {
	
	AC("AC", "Acre", "Rio Branco"),
	AL("AL", "Alagoas", "Maceió"),
	AM("AM", "Amazonas", "Manaus"),
	AP("AP", "Amapá", "Macapá"),
	BA("BA", "Bahia", "Salvador"),
	CE("CE", "Ceará", "Fortaleza"),
	DF("DF", "Distrito Federal", "Brasília"),
	ES("ES", "Espírito Santo", "Vitória"),
	GO("GO", "Goiás", "Goiânia"),
	MA("MA", "Maranhão", "São Luís"),
	MG("MG", "Minas Gerais", "Belo Horizonte"),
	MS("MS", "Mato Grosso do Sul", "Campo Grande"),
	MT("MT", "Mato Grosso", "Cuiabá"),
	PA("PA", "Pará", "Belém"),
	PB("PB", "Paraíba", "João Pessoa"),
	PE("PE", "Pernambuco", "Recife"),
	PI("PI", "Piauí", "Teresina"),
	PR("PR", "Paraná", "Curitiba"),
	RJ("RJ", "Rio de Janeiro", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte", "Natal"),
	RO("RO", "Rondônia", "Porto Velho"),
	RS("RS", "Rio Grande do Sul", "Porto Alegre"),
	RR("RR", "Roraima", "Boa Vista"),
	SC("SC", "Santa Catarina", "Florianópolis"),
	SE("SE", "Sergipe", "Aracaju"),
	SP("SP", "São Paulo", "São Paulo"),
	TO("TO", "Tocantins", "Palmas"),
	;
	
	private final String sigla;
	private final String nome;
	private final String capital;
	
	UFEnum(String sigla, String nome, String capital){
		this.sigla = sigla;
		this.nome = nome;
		this.capital = capital;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getCapital() {
		return capital;
	}
}
