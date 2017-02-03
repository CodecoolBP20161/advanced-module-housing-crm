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

    @ManyToMany(mappedBy = "companyUsers")
    private Set<Company> companies;

    private CompanyUser() {
        super();
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
