package xyz.javista.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import xyz.javista.dto.PersonDTO;
import xyz.javista.jooq.tables.tables.records.PersonRecord;
import xyz.javista.jooq.tables.tables.records.VPersonRecord;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(source = "firstname", target = "firstName"),
            @Mapping(source = "lastname", target = "lastName")
    })
    PersonDTO toDTO(VPersonRecord person);

    @Mappings({
            @Mapping(source = "firstname", target = "firstName"),
            @Mapping(source = "lastname", target = "lastName")
    })
    PersonDTO toDTO(PersonRecord person);

    PersonRecord toEntity(PersonDTO dto);

    List<PersonDTO> toDTO(List<VPersonRecord> personList);

}
