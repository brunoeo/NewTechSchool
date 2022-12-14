package com.br.NewTechSchool.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public abstract class AbstractPersonDTO extends SmallPersonDTO {

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "{rg.not.valid}")
    private String rg;
    @NotBlank(message = "{ddd.not.blank}")
    @Size(max = 2, message = "{ddd.size}")
    private String ddd;
    @NotBlank(message = "{phonenumber.not.blank}")
    @Size(max = 9, message = "{phonenumber.size}")
    private String phonenumber;
    @Pattern(regexp = "(^[0-9]{5})-?([0-9]{3}$)", message = "{cep.Pattern}")
    private String cep;
    @NotBlank(message = "{street.not.blank}")
    private String street;
    @NotBlank(message = "{number.not.blank}")
    private String number;
    @NotBlank(message = "{district.not.blank}")
    private String district;
    @NotBlank(message = "{city.not.blank}")
    private String city;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
}
