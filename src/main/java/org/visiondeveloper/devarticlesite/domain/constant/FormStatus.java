package org.visiondeveloper.devarticlesite.domain.constant;


import lombok.Getter;

@Getter
public enum FormStatus {
    CREATE("Save", false),
    UPDATE("Update", true);

    private final String description;

    private final Boolean update;

    FormStatus(String description, Boolean update) {
        this.description = description;
        this.update = update;
    }

}
