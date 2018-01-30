package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

// Só haverá um único registro desta entidade no banco!
@Entity
@Data
public class ConfiguracaoSistema {
	@Id
	@GeneratedValue
	private Long id;
	private String tema;
}
