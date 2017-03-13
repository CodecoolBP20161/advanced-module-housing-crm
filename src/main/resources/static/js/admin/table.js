 $(document).ready(function() {
    // Setup - add a text input to each footer cell
    // $('#company_list tfoot th').each(function () {
    //     var title = $(this).text();
    //     $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    // });

    // Setup datatable
    // var table =
        $('#company_list').DataTable({
        ajax: {
            url: 'admin/company',
            dataSrc: '_embedded.company'
        },
        columns: [
            {data: 'companyName'},
            {data: 'taxNumber'},
            {data: 'premise'},
            {data: 'createDate'},
            {
                data: 'companyStatus',
                "render": function (data, type, row, meta) {
                    return '<form action=/admin/'+row.taxNumber+'/status method="get">'
                        +'<select name="status">'+'<option value="'+data+'" selected>'+data+'</option>'
                        +'<option value="ACCEPTED">ACCEPTED</option>'
                        +'<option value="REJECTED">REJECTED</option>'
                        +'<option value="PENDING">PENDING</option>'
                        +'</select>'
                        +'<input type="submit" value="save">'
                        +'</form>'
                }
            }
        ]
    });

     // "createDate" : "2017-03-13",
     //     "companyName" : "Landrum Temporary Services",
     //     "taxNumber" : "1234567892",
     //     "premise" : "Inverlaw",
     //     "companyStatus" : "REJECTED",

    // TODO: LOCALSTORAGE NOT SAVING ADDITIONAL SEARCH QUERIES
    // BUT SAVING THE RESULT, FOR QUICK FIX -> delete the empty input fields

    // Apply the search
    // table.columns().every(function () {
    //     var that = this;
    //
    //     $('input', this.footer()).on('keyup change', function () {
    //         if (that.search() !== this.value) {
    //             that
    //                 .search(this.value)
    //                 .draw();
    //         }
    //     });
    // });

});
