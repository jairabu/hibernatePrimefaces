package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

// Recomendável utilizar variáveis do tipo Classe e não do tipo primitivo
// Assim é possível utilizar valor null (usuário informou ou não essa variável na tela)

@Entity
@Data
public class Filme {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Float nota;
	private Integer ano;
}
