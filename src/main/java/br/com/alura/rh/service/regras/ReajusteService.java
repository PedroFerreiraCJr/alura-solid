package br.com.alura.rh.service.regras;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.ValidacaoReajuste;

public class ReajusteService {

	private List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		super();
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		
		validacoes.forEach((v) -> {
			v.validar(funcionario, aumento);
		});
		
		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
