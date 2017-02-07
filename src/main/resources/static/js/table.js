$("#example").dataTable({
    "bServerSide": true,
    "sAjaxSource": "/admin/json",
    "aoColumns": [{
        "mData":"company",
        "sTitle": "Company name"
    },{
        "mData": "ceo",
        "sTitle" : "Ceo"
    },{
        "mData": "registered",
        "sTitle" : "Registered at",
        "sType" : "date"
    },{
        "mData": "updated",
        "sTitle" : "Updated at",
        "sType" : "date"
    },{
        "mData":"status"
    }]
});