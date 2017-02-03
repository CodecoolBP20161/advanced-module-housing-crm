package com.codecool.hccrm.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by balag3 on 2017.02.03..
 */
@Entity
@Table(name = "companyUser")
public class CompanyUser extends User {

    @ManyToMany(mappedBy = "ceoUsers")
    private Set<Company> companyCeos;

    @ManyToMany(mappedBy = "managerUsers")
    private Set<Company> companyManagers;

    private CompanyUser() {
        super();
    }

    public Set<Company> getCompanyCeos() {
        return companyCeos;
    }

    public void setCompanyCeos(Set<Company> companyCeos) {
        this.companyCeos = companyCeos;
    }

    public Set<Company> getCompanyManagers() {
        return companyManagers;
    }

    public void setCompanyManagers(Set<Company> companyManagers) {
        this.companyManagers = companyManagers;
    }
}
