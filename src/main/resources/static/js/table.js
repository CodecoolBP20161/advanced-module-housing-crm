$(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#company_list tfoot th').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
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
            {data: 'regDate'}
        ],
        stateSave: true
    });

    // TODO: LOCALSTORAGE NOT SAVING ADDITIONAL SEARCH QUERIES
    // BUT SAVING THE RESULT, FOR QUICK FIX -> delete the empty input fields

    // Apply the search
    table.columns().every(function () {
        var that = this;

        $('input', this.footer()).on('keyup change', function () {
            if (that.search() !== this.value) {
                that
                    .search(this.value)
                    .draw();
            }
        });
    });

});
