package ru.itmo.wp.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DisableCredentials {

    @NotNull
    @NotEmpty
    private String disabled;
}
