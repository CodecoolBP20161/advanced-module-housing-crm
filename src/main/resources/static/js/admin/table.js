 $(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#company_list tfoot th').each(function () {
        var title = $(this).text();
        if(title === "Status"){
            $(this).html('<select class="searchinput" name="status">'
                +'<option value="" selected>Select status</option>'
                +'<option value="accepteda">ACCEPTED</option>'
                +'<option value="rejecteda">REJECTED</option>'
                +'<option value="pendinga">PENDING</option>'
                +'</select>');
        } else {
            $(this).html('<input class="searchinput" type="text" placeholder="Search ' + title + '" />');
        }
    });

     // temperature = window.localStorage.getItem("temperature");

    // Setup datatable
    var table = $('#company_list').DataTable({
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
                    return '<form class="statuses" action=/admin/'+row.taxNumber+'/status method="get">'
                        +'<select name="status" onchange="this.form.submit()">'
                        +'<option value="'+data+'" selected>'+data+'</option>'
                        +'<option value="ACCEPTED">ACCEPTED</option>'
                        +'<option value="REJECTED">REJECTED</option>'
                        +'<option value="PENDING">PENDING</option>'
                        +'</select>'
                        +'</form>'
                    }
            }
                ],
            stateSave: true
    });

    // TODO: LOCALSTORAGE NOT SAVING ADDITIONAL SEARCH QUERIES
    // BUT SAVING THE RESULT, FOR QUICK FIX -> delete the empty input fields

    // Apply the search
    table.columns().every(function () {
        var that = this;

        $('.searchinput', this.footer()).on('keyup change', function () {
            // var values = ["pending", "rejected", "accepted"];
            // window.localStorage.setItem(this, that);
            if (that.search() !== this.value) {
                // if(values.indexOf(this.value)>-1){that.search(this.value+="a").draw()}
                that
                    .search(this.value)
                    .draw();
            }
        });
    });

});
