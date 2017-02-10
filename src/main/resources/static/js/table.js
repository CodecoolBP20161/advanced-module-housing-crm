$('#company_list').DataTable( {
    ajax: {
        url: 'admin/company',
        dataSrc: '_embedded.company'
    },
    columns: [
        { data: 'companyName' },
        { data: 'taxNumber' },
        { data: 'premise' },
        { data: 'regDate' }
    ]
} );
