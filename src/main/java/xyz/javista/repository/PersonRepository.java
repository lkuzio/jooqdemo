package xyz.javista.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.javista.dto.PersonDTO;
import xyz.javista.jooq.tables.tables.records.PersonRecord;
import xyz.javista.jooq.tables.tables.records.VPersonRecord;

import java.util.List;

import static xyz.javista.jooq.tables.Tables.PERSON;
import static xyz.javista.jooq.tables.tables.VPerson.V_PERSON;


@Component
public class PersonRepository {

    @Autowired
    private DSLContext context;

    public List<VPersonRecord> findAll() {
        return context.selectFrom(V_PERSON).fetch();
    }

    public VPersonRecord findOne(Integer id) {
        return context.selectFrom(V_PERSON).where(V_PERSON.ID.eq(id.longValue())).fetchOne();
    }

    public PersonRecord add(PersonDTO dto) {
        return context.insertInto(PERSON,
                PERSON.ID,
                PERSON.FIRSTNAME,
                PERSON.LASTNAME,
                PERSON.DATEOFBIRTH,
                PERSON.ENABLED)
                .values(dto.getId(),
                        dto.getFirstName(),
                        dto.getLastName(),
                        dto.getDateofbirth(),
                        dto.getEnabled())
                .returning(PERSON.fields())
                .fetchOne();
    }
}
