$("#company_table").DataTable({
    "bServerSide": true,
    "sAjaxSource": "/admin/company",
    "sAjaxDataProp" : "_embedded.company",
    "aoColumns": [{
        "mData":"companyName",
        "sTitle": "Company name"
    },{
        "mData": "taxNumber",
        "sTitle" : "Tax number"
    },{
        "mData": "premise",
        "sTitle" : "Premise"
    },{
        "mData": "regDate",
        "sTitle" : "Registered at",
        "sType" : "date"
    }]
});