package com.codecool.hccrm.dto.builder;

import com.codecool.hccrm.dto.CondominiumDTO;
import com.codecool.hccrm.model.Condominium;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by balag3 on 2017.03.08..
 */
@Component
public class CondominiumDTOBuilder {

    @Transactional(readOnly = true)
    public CondominiumDTO fromCondominium(Condominium condominium){

        if (condominium == null) return null;

        CondominiumDTO dto = new CondominiumDTO();
        dto.setName(condominium.getName());
        dto.setParcelNumber(condominium.getParcelNumber());
        dto.setTopographicalNumber(condominium.getTopographicalNumber());
        dto.setContractingDate(condominium.getContractingDate().toString());
        dto.setGeneralMeetingDate(condominium.getGeneralMeetingResolutionDate().toString());
        if (condominium.getAddress() != null) {
            dto.setCity(condominium.getAddress().getCity());
            dto.setCountry(condominium.getAddress().getCountry());
            dto.setZipCode(condominium.getAddress().getZipCode());
            dto.setAddressLine1(condominium.getAddress().getAddressLine1());
            dto.setAddressLine2(condominium.getAddress().getAddressLine2());
        }
        return dto;
    }
}
