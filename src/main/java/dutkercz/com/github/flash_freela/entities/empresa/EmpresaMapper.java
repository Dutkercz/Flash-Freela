package dutkercz.com.github.flash_freela.entities.empresa;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    Empresa toEntity(EmpresaCadastroDTO cadastroDTO);
}
