 $(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#company_list tfoot th').each(function () {
        var title = $(this).text();


        //get name for name attribute with some regex and save to localstorage
        var name = title.replace(/\s+/g, '-').toLowerCase();
        var value = window.localStorage.getItem(name);

        //needs to be done, because inserts "null"
        if(value === null){value = ""}

        //options for status
        if(title === "Status"){
            $(this).html('<select class="searchinput" name="'+ name +'">'
                +'<option id="noneselected" value="">ALL STATUS</option>'
                +'<option id="acceptselected" value="ACCEPTEDA">ACCEPTED</option>'
                +'<option id="rejectselected" value="REJECTEDA">REJECTED</option>'
                +'<option id="pendingselected" value="PENDINGA">PENDING</option>'
                +'</select>');

            // THIS RESTORES SELECTED FROM LOCALSTORAGE!
            if(value === "PENDINGA"){$('#pendingselected').attr("selected","selected")}
            else if(value === "ACCEPTEDA"){$('#acceptselected').attr("selected","selected")}
            else if(value === "REJECTEDA"){$('#rejectselected').attr("selected","selected")}
            else {$('#noneselected').attr("selected","selected")}

        //search inputs for everything else
        } else {
            $(this).html('<input name="'+ name +'" value="'+ value +'" class="searchinput" type="text" placeholder="Search ' + title + '" />');
        }
    });


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
                    var form = '<form class="statuses" action=/admin/'+row.taxNumber+'/status method="get">'
                        +'<select name="status" onchange="this.form.submit()">'
                        +'<option value="'+data+'" selected style="display: none;">'+data+'</option>'
                        +'<option id="accepted" value="ACCEPTED"';
                        if(data === "ACCEPTED") {form += ' selected'}
                        form += '>ACCEPTED</option>'

                        + '<option id="rejected" value="REJECTED"';
                        if(data === "REJECTED") {form += ' selected'}
                        form += '>REJECTED</option>'

                        + '<option id="pending" value="PENDING"';
                        if(data === "PENDING") {form += ' selected'}
                        form += '>PENDING</option>'

                        +'</select>'
                        +'</form>';

                    return form;
                    }
            }
                ],
            stateSave: true
    });



     // Apply the search
    table.columns().every(function () {
        var that = this;

        $('.searchinput', this.footer()).on('keyup change', function () {
            // SAVE TO LOCALSTORAGE
            window.localStorage.setItem(this.name, this.value);
            if (that.search() !== this.value) {
                that
                    .search(this.value)
                    .draw();
            }
        });
    });

});
