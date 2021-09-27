package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tb_categorias")
@Data
public class Categoria {
	@Id
	private int idcategoria;
	private String descripcion;
}
