package com.gamary.emailanalyzer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Setter
@Getter
public class Email {
    @Id
    private String id;
    @Lob
    private String emailContent;

    private String sender;

    private String subject;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        String objId = ((Email) obj).id;

        return objId==null? false:Objects.equals(id,objId);
    }

}
