package com.codecool.hccrm.controller.admin;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.CompanyStatus;
import com.codecool.hccrm.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.codecool.hccrm.logging.LogFormatter.FORMAT;

/**
 * Created by turbek on 05.02.17.
 * Last edited by dorasztanko on 2017.02.18..
 */
@Controller
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndex() {
        logger.info(FORMAT.getFormatter() + "Admin page is called.");

        return "admin/admin_index";
    }

    @RequestMapping(value = {"admin/{company_id}/status"},method = RequestMethod.POST, consumes = "text/plain")
    public String changeCompanyStatus(@PathVariable("company_id") String companyId, @RequestBody String status) {
        Company company = companyService.findById(new Long(companyId));
        CompanyStatus newStatus = CompanyStatus.valueOf(status);
        company.setCompanyStatus(newStatus);
        companyService.save(company);
        return "admin/admin_index";
    }
}
